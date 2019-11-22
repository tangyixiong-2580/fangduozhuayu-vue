package cn.dzy.manage.boss.manage.dao;

import cn.dzy.manage.boss.manage.bean.cart.Cart;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Mapper
public interface CartMapper {

    @Select("SELECT c.cart_id, c.user_id, cd.book_id, cd.selection, book.images, book.book_title title, book.price, cd.appearance, bw.stock\n" +
            "FROM cart c \n" +
            "LEFT JOIN cart_detailed cd ON c.cart_id = cd.cart_id \n" +
            "LEFT JOIN book ON cd.book_id = book.book_id\n" +
            "LEFT JOIN book_warehouse bw ON cd.book_id = bw.book_id AND bw.appearance = cd.appearance\n" +
            "WHERE c.user_id = #{userId} AND bw.stock > 0\n" +
            "ORDER BY cd.create_time DESC")
    List<Cart> queryCartBooksAndSellingByUserId(String userId);

    @Select("SELECT c.cart_id, c.user_id, cd.book_id, cd.selection, book.images, book.book_title title, book.price, cd.appearance, bw.stock\n" +
            "FROM cart c \n" +
            "LEFT JOIN cart_detailed cd ON c.cart_id = cd.cart_id \n" +
            "LEFT JOIN book ON cd.book_id = book.book_id\n" +
            "LEFT JOIN book_warehouse bw ON cd.book_id = bw.book_id AND bw.appearance = cd.appearance\n" +
            "WHERE c.user_id = #{userId} AND bw.stock = 0\n" +
            "ORDER BY cd.create_time DESC")
    List<Cart> queryCartBooksAndShortageByUserId(String userId);

    @Select("SELECT cart_id FROM cart WHERE user_id = #{userId}")
    String queryCartIdByUserId(String userId);

    @Select("SELECT book_id, appearance, selection, create_time, update_time FROM cart_detailed WHERE cart_id = #{cartId} AND book_id = #{bookId}")
    Cart queryBookByCartIdAndBookId(String cartId, String bookId);

    @Select("SELECT cd.book_id, bw.appearance, book.price, bw.stock, cd.selection FROM cart_detailed cd LEFT JOIN book ON book.book_id = cd.book_id LEFT JOIN book_warehouse bw ON cd.book_id = bw.book_id WHERE cd.cart_id = #{cartId}")
    List<Cart> queryBookAppearanceByCartIdAndBookId(String cartId);

    @Delete("DELETE cart_detailed FROM cart_detailed,cart WHERE cart.user_id = #{userId} AND cart_detailed.book_id = #{bookId}")
    void delCartBookByUserIdAndBookId(String userId, String bookId);

    @Insert("INSERT INTO cart (cart_id, user_id) VALUES (#{cartId}, #{userId})")
    void insertCartByCartIdAndUserId(String cartId, Integer userId);

    @Insert("INSERT INTO cart_detailed (cart_id, book_id, appearance, selection) VALUES (#{cartId}, #{bookId}, #{appearance}, 1)")
    void insertCartDetailedByCartIdAndBookId(String cartId, String bookId, String appearance);

    @Update("UPDATE cart_detailed SET appearance = #{appearance} WHERE cart_id= #{cartId} AND book_id = #{bookId}")
    void patchCartDetailedByCartIdAndBookId(String appearance, String cartId, String bookId);

    @Update("UPDATE cart_detailed SET selection = #{selection} WHERE cart_id= #{cartId} AND book_id = #{bookId}")
    void patchCartDetailedSelectionByCartIdAndBookId(String selection, String cartId, String bookId);

    @Update("UPDATE cart_detailed SET selection = #{selection} WHERE cart_id = #{cartId}")
    void patcCartDetailedAllSelectionByCartIdAndBookId(String selection, String cartId);
}
