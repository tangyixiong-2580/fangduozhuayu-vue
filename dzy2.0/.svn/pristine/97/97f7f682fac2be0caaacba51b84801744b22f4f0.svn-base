package cn.dzy.manage.boss.manage.dao;

import cn.dzy.manage.boss.manage.bean.book.Append;
import cn.dzy.manage.boss.manage.bean.book.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {

    @Insert("INSERT INTO book_sold (isbn10, isbn13, user_id) VALUE(#{isbn10},#{isbn13},#{userId})")
    void addBooks(String isbn10, String isbn13, Integer userId);

    /**
     * 添加待卖书籍
     */
    @Insert("INSERT INTO book (book_id, book_isbn13, book_isbn10, book_title, author, price, publisher, images, pubdate, douban_score, summary, binding) VALUES(#{bookId},#{bookIsbn13},#{bookIsbn10},#{bookTitle},#{author},#{price},#{publisher},#{pic},#{pubdate},#{score},#{summary},#{binding})")
    void addUnsoldBooks(String bookId, String bookIsbn13, String bookIsbn10, String bookTitle, String author, String price, String publisher, String pic, String pubdate, String score, String summary, String binding);

    /**
     * 删除待卖书籍
     */
    @Delete("DELETE book_sold FROM book_sold LEFT JOIN book ON book.book_isbn13 = book_sold.isbn13 OR book.book_isbn10 = book_sold.isbn10 WHERE book_sold.isbn13 = #{isbn} OR book_sold.isbn10 = #{isbn} AND book_sold.user_id = #{userId}")
    Boolean deleteUnsoldBooks(Integer userId, String isbn);

    /**
     * 查询单个用户所有待卖要收书籍
     */
    @Select("SELECT b.receive, b.appearance, bd.sell_book_id, b.book_id,b.book_title title,b.book_isbn13 isbn13, b.book_isbn10 isbn10, b.author, b.price, b.images pic FROM book_sold bd LEFT JOIN book b ON bd.isbn13 = b.book_isbn13 WHERE bd.user_id = #{id} and bd.is_sold = 0 AND b.receive = 1")
    List<Book> qeuryUnsoldBooks(Integer id);

    /**
     * 查询单个用户所有待卖不收书籍
     */
    @Select("SELECT b.receive, b.appearance, bd.sell_book_id, b.book_id,b.book_title title,b.book_isbn13 isbn13, b.book_isbn10 isbn10, b.author, b.price, b.images pic FROM book_sold bd LEFT JOIN book b ON bd.isbn13 = b.book_isbn13 WHERE bd.user_id = 10001 AND bd.is_sold = 0 AND b.receive = 0")
    List<Book> qeuryUnsoldRefusedBooks(Integer id);

    /**
     * 根据isbn查询书籍
     */
    @Select("SELECT user_id, isbn10, isbn13, is_sold FROM book_sold WHERE user_id = #{userId} and is_sold = 0 and (isbn13 = #{isbn} OR isbn10 = #{isbn})")
    List<Book> queryByIsbn(Integer userId, String isbn);

    /**
     *
     */
    @Select("SELECT book_id FROM book WHERE book_title = #{bookTitle} and author = #{author} and publisher = #{publisher} and (book_isbn10 = #{isbn10} or book_isbn13 = #{isbn13})")
    List<Book> queryBookIsRepeat(String bookTitle, String author, String publisher, String isbn10, String isbn13);

    /**
     * 修改订单状态
     */
    @Update("UPDATE book_sold bd,book b SET bd.is_sold = 1, bd.order_id = #{orderId}, bd.sell_book_id = #{sellBookId} WHERE bd.is_sold = 0 AND b.receive = 1 AND bd.user_id = #{userId} ")
    Boolean changeOrderId(Integer userId, String orderId, String sellBookId);

    /**
     * 根据用户id查询订单书籍图片
     */
    @Select("SELECT bd.order_id, b.images pic FROM book_sold bd JOIN book b ON bd.isbn13 = b.book_isbn13 WHERE bd.user_id = #{userId} AND bd.order_id != 0")
    List<Append> queryPicByUserId(Integer userId);

    /**
     * 根据订单id获取用户id,isbn10,isbn13
     *
     * @param orderId
     * @return
     */
    @Select("SELECT user_id,isbn10,sell_book_id from `book_sold` where order_id = #{orderId}")
    List<Book> getBookSoldByOrderId(String orderId);

    @Update("UPDATE book_sold bd, book b SET bd.sell_book_id=0, bd.order_id=0,bd.is_sold=0 WHERE b.book_isbn13 = bd.isbn13 AND b.receive = 0")
    void changeReceiveStatus();

    @Update("UPDATE book_sold SET sell_book_id = 0, order_id = 0, is_sold=0 WHERE user_id = #{userId} AND isbn10 = #{isbn10} AND sell_book_id = #{sellBookId}")
    void updateUnsoldBooks(String isbn10, String sellBookId, Integer userId);

    //根据书名模糊查询
    @Select("SELECT book.book_id as bookId,book.book_title AS title,book.douban_score,book.author,book.publisher,book.images pic,k.stock FROM book INNER JOIN \n" +
            "(\n" +
            "SELECT bw.book_id,SUM(bw.stock) AS stock FROM book_warehouse bw GROUP BY bw.book_id\n" +
            ")k ON k.book_id = book.book_id \n" +
            "AND book.book_title LIKE '%${title}%'")
    List<Book> fuzzyQueryByTitle(@Param("title") String title);

    @Select("SELECT book_id, book.book_title title, bw.appearance FROM book LEFT JOIN book_warehouse bw ON bw.book_id = book.book_id AND book.book_title LIKE '%${title}%'")
    List<Book> fuzzyQueryAppearanceByTitle(@Param("title") String title);

    //根据书籍id获取书籍信息
    @Select("SELECT id, book_id, book_isbn13, book_isbn10, book_title AS title, author, price, douban_score AS score, publisher, pubdate, images AS pic, appearance, receive, binding, summary, classification, create_time, update_time\n" +
            "\tFROM book WHERE book_id = #{bookId}")
    Book getBookByBookId(String bookId);
}
