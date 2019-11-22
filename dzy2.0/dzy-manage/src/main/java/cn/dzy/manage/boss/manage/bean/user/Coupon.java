package cn.dzy.manage.boss.manage.bean.user;

import lombok.Data;

import java.util.Date;

@Data
public class Coupon {
    private Integer id;
    private Integer userId;
    private User user;
    private Double money;
    private Long expiredTime;
    private Long startTime;
    private Integer status;
    private Integer type;
    private Date createTime;
    private Date updateTime;
}
