package cn.dzy.manage.boss.manage.bean.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BookOfWarehouse {
    //序号
    private Integer bookWarehouseId;
    //书籍id
    private String bookId;
    //品像
    private Integer appearance;
    //库存
    private Integer stock;

    private String title;

    private String author;

    private String publisher;

    private String pubdate;

    private String binding;

    private String summary;

    private String pic;

    private String price;

    private Double currentPrice;

    private Double discount;

    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //更新时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
}
