package cn.dzy.manage.boss.manage.bean.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Book {
    //书名
    private String title;
    //图片
    private String pic;
    //作者
    private String author;
    //出版社
    private String publisher;
    //出版时间
    private String pubdate;
    //价格
    private String price;
    //ISBN13
    private String isbn13;
    //ISBN10
    private String isbn10;
    //待卖书id
    private String bookId;
    //用户id
    private Integer userId;
    //
    private String sellBookId;
    //库存
    private Integer stock;
    //是否接受
    private Integer isSold;
    //简介
    private String summary;
    //装帧
    private String binding;
    //豆瓣评分
    private String score;
    //品相
    private Integer appearance;
    //最高价格
    private Double highestPrice;
    //最低价格
    private Double lowestPrice;
    //折扣
    private Double discount;

    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    //是否接受
    private Integer receive;

    public Book(Integer userId, String bookId, String title, String pic, String author, String publisher, String pubdate, String price, String isbn13, String isbn10, String score) {
        this.userId = userId;
        this.bookId = bookId;
        this.title = title;
        this.pic = pic;
        this.author = author;
        this.publisher = publisher;
        this.pubdate = pubdate;
        this.price = price;
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.score = score;
    }
}
