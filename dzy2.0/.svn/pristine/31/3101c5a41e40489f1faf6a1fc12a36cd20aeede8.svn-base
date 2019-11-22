
package cn.dzy.manage.boss.manage.bean.book;

import cn.dzy.manage.boss.manage.bean.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 书单实体类
 */
@Data
public class BookCollection {
    //书单id
    private String id;
    //书单名
    private String name;
    //书单简介
    private String intro;
    //书单背景图
    private String image;
    //书单背景颜色
    private String bgColor;
    //过期时间
    private long expiredTime;
    //推荐人数
    private int recommendCount;
   //推荐人id
    private String userId;
    //推荐人
    private List<User> users;
    //书单的书籍数量
    private int bookCount;
    //优先级
    private int priority;
    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //更新时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;


}
