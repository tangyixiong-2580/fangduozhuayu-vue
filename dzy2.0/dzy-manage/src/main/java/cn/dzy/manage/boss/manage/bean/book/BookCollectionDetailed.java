package cn.dzy.manage.boss.manage.bean.book;

import cn.dzy.manage.boss.manage.bean.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 书单详情实体类
 */
@Data
public class BookCollectionDetailed {
    //书单详情id
    private int id;
    //所属的书单id
    private String bookCollectionId;
    //书籍id
    private String bookId;
    //书籍信息
    private Book book;
    //推荐理由
    private String reason;
    //推荐人id
    private int userId;
    //推荐人
    private  User user;
    //是否点赞
    private  boolean isUp;
    //点赞数量
    private int count;
    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //更新时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    //距离当前时间
    private String timeDiff;




}
