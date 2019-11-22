package cn.dzy.manage.boss.manage.bean.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Money {
    // 余额明细id
    private Integer moneyId;
    // 用户id
    private String userId;
    // 金额
    private Double money;
    // 类型 0支出1收入
    private Integer type;
    // 订单id
    private String orderId;
    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}