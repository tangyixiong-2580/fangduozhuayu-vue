package cn.dzy.manage.boss.manage.service;

import cn.dzy.manage.boss.manage.bean.Fabulous;
import cn.dzy.manage.boss.manage.bean.book.Book;
import cn.dzy.manage.boss.manage.bean.book.BookCollectionDetailed;
import cn.dzy.manage.boss.manage.bean.user.User;
import cn.dzy.manage.boss.manage.dao.BookCollectionDetailedDao;
import cn.dzy.manage.boss.manage.dao.BookDao;
import cn.dzy.manage.boss.manage.dao.FabulousDao;
import cn.dzy.manage.boss.manage.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookCollectionDetailedService {
    @Resource
    BookCollectionDetailedDao detailedDao;
    @Resource
    UserMapper userMapper;
    @Resource
    BookDao bookDao;
    @Resource
    FabulousDao fabulousDao;

    //第一本
    public BookCollectionDetailed firstInfo(String id){
        BookCollectionDetailed firstInfo = detailedDao.getFirstInfo(id);
        User user = userMapper.get(firstInfo.getUserId());
        firstInfo.setUser(user);
        Book book = bookDao.getBookByBookId(firstInfo.getBookId());
        firstInfo.setBook(book);
        return firstInfo;
    }
    //除了第一本
    public List<BookCollectionDetailed> getAllDetailed(String id,int first) {
        List<BookCollectionDetailed> allDetailed = detailedDao.getDetailedByCId(id,first);
        System.out.println("书单id:"+id);
        System.out.println("书单详情id:"+id);
        for (BookCollectionDetailed detailed : allDetailed) {
            System.err.println("111"+detailed);
            System.out.println("详情id："+detailed.getId());
            int userId = detailed.getUserId();
            User user = userMapper.get(userId);
            detailed.setUser(user);
            String bookId = detailed.getBookId();
            Book book = bookDao.getBookByBookId(bookId);
            detailed.setBook(book);
        }
        return allDetailed;
    }


    public String recommend(BookCollectionDetailed bookCollectionDetailed){
        Book book = bookDao.getBookByBookId(bookCollectionDetailed.getBookId());
        double score = Double.parseDouble(book.getScore());
        String msg = "";
        if (score < 7.5){
            return msg= "该书豆瓣评分少于7.5，不符合推荐要求";
        }
        BookCollectionDetailed detailed = detailedDao.getDetailedByBookIdAndCId(book.getBookId(), bookCollectionDetailed.getBookCollectionId());
        if (detailed != null){
            return msg= "该书籍在书单已经存在";
        }
        if (bookCollectionDetailed.getReason().length() > 200){
            return msg= "推荐语不得超过200字";
        }
        System.err.println(bookCollectionDetailed);
        detailedDao.add(bookCollectionDetailed);
        return  "成功";
    }
    //根据书单详情id获取书单详情信息
    public BookCollectionDetailed getSingleDetailed(int id){
        BookCollectionDetailed detailedByDetailedId = detailedDao.getDetailedByDetailedId(id);
        Book book = bookDao.getBookByBookId(detailedByDetailedId.getBookId());
        detailedByDetailedId.setBook(book);
        User user = userMapper.get(detailedByDetailedId.getUserId());
        detailedByDetailedId.setUser(user);
        Date updateTime = detailedByDetailedId.getUpdateTime();
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = formatter.format(updateTime);
        System.err.println(format);
        int year = Integer.parseInt(format.substring(0, 4));
        int month = Integer.parseInt(format.substring(5, 7));
        int day = Integer.parseInt(format.substring(8,10));
        int hour = Integer.parseInt(format.substring(12, 14));
        int minute = Integer.parseInt(format.substring(15, 17));

        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentDay = cal.get(Calendar.DATE);
        int currentHour = cal.get(Calendar.HOUR_OF_DAY);
        System.out.println("当前小时："+currentHour);
        int currentMinute = cal.get(Calendar.MINUTE);


        if (currentYear != year){
            System.out.println("年份不一样");
            detailedByDetailedId.setTimeDiff(format);
        }else if (currentMonth != month){
            System.out.println("月份不一样");
            detailedByDetailedId.setTimeDiff(month+"月"+day+"日");
        }else if (currentDay != day){
            System.out.println("天数不一样");
            detailedByDetailedId.setTimeDiff((currentDay-day)+"天前");
        }else if (currentHour != hour){
            System.out.println("小时不一样");
            detailedByDetailedId.setTimeDiff((currentHour-hour)+"小时前");
        }else if (currentMinute != minute){
            System.out.println("分钟不一样");
            detailedByDetailedId.setTimeDiff((currentMinute-minute)+"分钟前");
        }else {
            detailedByDetailedId.setTimeDiff("1分钟前");
        }
        System.err.println(detailedByDetailedId.getTimeDiff());
        return detailedByDetailedId;
    }
}
