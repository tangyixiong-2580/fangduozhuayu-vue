package cn.dzy.manage.boss.manage.service;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.bean.Pager;
import cn.dzy.manage.boss.manage.bean.book.BookCollection;
import cn.dzy.manage.boss.manage.bean.user.User;
import cn.dzy.manage.boss.manage.dao.BookCollectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookCollectionService {
    @Resource
    BookCollectionDao dao;
    @Autowired
    UserService service;
    public BizResponse getBookCollections(long now, Integer isLimit, Integer page, Integer pageSize){
        List<BookCollection> bookCollections = new ArrayList<>();
        //查询所有书单
        if (isLimit == 0) {
            bookCollections = dao.getAllBookCollection(now);
        }else if (isLimit == 1){
            //查询前5个书单
            bookCollections = dao.getBookCollectionLimit(now);
        }
        if (bookCollections.isEmpty()) return  BizResponse.of(205,null);
        for (BookCollection bc:bookCollections) {
            try {
                String userIds = bc.getUserId();
                String[] ids = userIds.split(",");
                List<String> idsList = Arrays.asList(ids);
                HashSet<String> set = new HashSet<>(idsList);
                ArrayList<User> users = new ArrayList<>();
                for (String id : set) {
                    System.err.printf("id:"+id);
                    User user = service.get(Integer.parseInt(id));
                    users.add(user);
                    bc.setUsers(users);
                }
            }catch (NullPointerException e){
                String message = e.getMessage();
            }
        }
        //分页
        Pager pager=new Pager();
        pager.setTotal(bookCollections.size());//总数据
        pager.setIndex(page);//当前所在页数
        int toalpages=(int)Math.ceil(bookCollections.size()/Double.valueOf(pageSize));//最大页数 （总数据除每页条数）
        if(toalpages>0 && page>toalpages){
            page=toalpages;
        }
        pager.setSize(pageSize);//每页数据多少条
        pager.setTotalPage(toalpages);//总页t数
        int extents=(page-1)*  pageSize;//
        bookCollections=bookCollections.stream().skip(extents).limit(pageSize).collect(Collectors.toList());

        return BizResponse.of(0,bookCollections,pager);
    }

    public BookCollection getCollectionById(String id){
        BookCollection bookCollection = dao.getBookCollectionById(id);
        String userId = bookCollection.getUserId();
        ArrayList<User> users = new ArrayList<>();
        String[] ids = userId.split(",");
        List<String> idsList = Arrays.asList(ids);
        HashSet<String> set = new HashSet<>(idsList);
        try {
            for (String i : set) {
                User user = service.get(Integer.parseInt(i));
                users.add(user);
                bookCollection.setUsers(users);
            }
        }catch (NullPointerException e){
            String message = e.getMessage();
        }
        return  bookCollection;
    }
}
