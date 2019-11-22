package cn.dzy.manage.boss.manage.service;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.bean.book.Append;
import cn.dzy.manage.boss.manage.bean.book.Book;
import cn.dzy.manage.boss.manage.bean.order.Order;
import cn.dzy.manage.boss.manage.bean.order.OrderTemp;
import cn.dzy.manage.boss.manage.dao.*;
import cn.dzy.manage.boss.manage.utils.DiscountUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class OrderService {

    @Resource
    OrderMapper mapper;
    @Resource
    AddressMapper addressMapper;
    @Resource
    BookDao bookDao;

    List<Order> orders = new ArrayList<>();

    public BizResponse queryAll(Integer userId) {
        List<Append> appends = bookDao.queryPicByUserId(userId);
        orders = mapper.queryAllOrder(userId);
        Map<String, Order> hashMap = new HashMap<>();

        orders.stream().forEach(o -> hashMap.put(o.getOrderId(), o));
        hashMap.forEach((s, order) -> {
            List<String> tempAppends = new ArrayList<>();
            appends.stream().forEach(append -> {
                if (append.getOrderId().equals(order.getOrderId())) {
                    tempAppends.add(append.getPic());
                    order.setPic(tempAppends);
                }
            });
        });
        if (hashMap.isEmpty()) return BizResponse.of(205,null);
        return  BizResponse.of(0,hashMap);
    }

    //新增
    public BizResponse add(String o,Integer userId) {
        JSONObject jsonObject = JSONObject.fromObject(o);
        String name = jsonObject.getString("name");
        String mailingPhone = jsonObject.getString("mailingPhone");
        String detailedAddress = jsonObject.getString("detailedAddress");
        System.out.println("detailedAddress:"+detailedAddress);
        String address = jsonObject.getString("mailingAddress");
        String sellPrice = jsonObject.getString("sellPrice");
        Double price = Double.parseDouble(sellPrice);
        Random random = new Random();
        String id = System.currentTimeMillis() + "" + random.nextInt(1000);
        Order order = new Order();
        order.setOrderId(id);
        order.setOrderStatus(1);
        order.setSellBookId(id + "1");
        order.setMailingId(id + "2");
        order.setUserId(userId);
        order.setSellAnonymous(0);
        order.setSellPrice(price);
        orders.add(order);

        System.out.println("order = " + order);
        mapper.add(order);

        addressMapper.add(id + "1",userId,id,address,detailedAddress,mailingPhone,name);
        bookDao.changeOrderId(userId, id, id + "1");
        bookDao.changeReceiveStatus();
       return BizResponse.of(0,order);
    }

    public BizResponse get(String orderId){
        OrderTemp orderTemp = mapper.get(orderId);
        if(orderTemp == null) return BizResponse.of(205,null);

        List<Book> books = mapper.queryBookBySellBookId(orderTemp.getSellBookId());
        if(books.isEmpty()) return BizResponse.of(205,null);

        books = DiscountUtil.getDiscount(books);
        orderTemp.setBooks(books);
        System.out.println("订单信息："+orderTemp);
        return BizResponse.of(0,orderTemp);
    }

    /**
     * 取消订单
     * @return
     */
    public  BizResponse cancelOrder(String orderId){
        mapper.updateOrderStatus(orderId);
        List<Book> books = bookDao.getBookSoldByOrderId(orderId);
        for (int i = 0; i < books.size(); i++) {
            bookDao.updateUnsoldBooks(books.get(i).getIsbn10(),books.get(i).getSellBookId(),books.get(i).getUserId());
        }
        return BizResponse.of(0,null);
    }
}
