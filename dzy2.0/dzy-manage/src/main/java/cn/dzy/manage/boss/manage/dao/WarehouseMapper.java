package cn.dzy.manage.boss.manage.dao.book;

import cn.dzy.manage.boss.manage.bean.book.BookOfWarehouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    /**
     * 查询指定外的书籍id所有仓库书籍
     * @param bookId
     * @return
     */
    @Select("SELECT b.book_id,b.images pic FROM book_warehouse bw JOIN book b ON bw.book_id = b.book_id WHERE bw.book_id != #{bookId}")
    List<BookOfWarehouse> queryAllExceptTheBook(String bookId);

    //用于首页
    @Select("SELECT b.book_title title, b.douban_score as score, b.author, b.publisher, b.images pic, bw.book_warehouse_id, bw.book_id, bw.appearance, bw.stock, b.price, bw.create_time, bw.update_time FROM book_warehouse bw JOIN book b ON b.book_id = bw.book_id ORDER BY bw.appearance ASC")
    List<BookOfWarehouse> queryAllBook();

    /**
     * 根据书籍id查询书籍
     */
    @Select("SELECT b.book_title title, b.binding, b.pubdate, b.summary, b.author, b.publisher, b.images pic, bw.book_warehouse_id, bw.book_id, bw.appearance, bw.stock, b.price, bw.create_time, bw.update_time FROM book_warehouse bw JOIN book b ON b.book_id = bw.book_id WHERE b.book_id = #{bookId}")
    List<BookOfWarehouse> getBookIdByBook(String bookId);

}
