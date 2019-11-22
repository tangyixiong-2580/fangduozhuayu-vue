package cn.dzy.manage.boss.manage.bean.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    //订单id
    private String orderId;
    //订单状态
    private Integer orderStatus;
    //交易时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date transactionTime;
    //卖书书籍的Id
    private String sellBookId;
    //用户id
    private Integer userId;
    //是否匿名卖书
    private Integer sellAnonymous;
    //订单金额
    private  Double sellPrice;
    //寄件地址Id
    private String mailingId;
    //订单创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //订单修改时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private  Date updateTime;

    private List<String> pic;

}
