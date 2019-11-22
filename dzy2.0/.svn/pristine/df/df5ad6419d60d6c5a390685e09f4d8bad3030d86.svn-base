package cn.dzy.manage.boss.manage.dao;

import cn.dzy.manage.boss.manage.bean.book.Book;
import cn.dzy.manage.boss.manage.bean.order.Order;
import cn.dzy.manage.boss.manage.bean.order.OrderTemp;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper//生成动态代理
public interface OrderMapper {
    /**
     * 根据用户id获取用户的订单
     * @param userId
     * @return
     */
    @Select("SELECT * FROM `order` WHERE user_id = #{userId}")
    List<Order> queryAllOrder(Integer userId);

    @Insert("INSERT INTO `order`(order_id,user_id, order_status, sell_book_id, sell_anonymous, mailing_id, sell_price)" +
            "VALUES (#{orderId},#{userId},#{orderStatus},#{sellBookId},#{sellAnonymous},#{mailingId},#{sellPrice})")
    void add(@RequestBody Order order);

    @Select("SELECT o.sell_book_id, o.order_id, o.order_status,a.mailing_name,a.mailing_address,a.detailed_address,a.mailing_phone FROM `order` o inner join `address` as a on o.order_id = a.order_id and o.order_id = #{orderId}")
    OrderTemp get(String orderId);

    @Select("SELECT b.book_id, b.book_title title, b.author, b.price, b.images pic, b.book_isbn10 isbn10, b.appearance FROM book_sold bd LEFT JOIN book b ON bd.isbn13 = b.book_isbn13 WHERE bd.sell_book_id = #{sellBookId}")
    List<Book> queryBookBySellBookId(String sellBookId);

    /**
     * 根据订单id修改订单状态为已取消
     * @param orderId
     */
    @Update("update `order` set order_status = 2 where order_id = #{orderId}")
    void updateOrderStatus(String orderId);

}
