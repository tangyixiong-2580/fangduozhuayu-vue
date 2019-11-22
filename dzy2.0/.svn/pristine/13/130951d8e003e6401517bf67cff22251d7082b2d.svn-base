package cn.dzy.manage.boss.manage.bean.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    //用户id
    private Integer userId;
    //用户名
    private String name;
    //手机号码
    private Long phone;
    //openId
    private String openId;
    //性别
    private Integer sex;
    //用户余额
    private Double sellFee;
    //登录状态
    private Integer loginStatus;
    //禁用状态
    private Integer disabledStatus;
    //头像
    private String headerImg;
    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //更新时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
}