package cn.dzy.manage.boss.manage.utils;

import cn.dzy.manage.boss.manage.bean.book.Book;
import cn.dzy.manage.boss.manage.bean.book.BookOfWarehouse;
import cn.dzy.manage.boss.manage.bean.cart.Cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountUtil {

    public static List<Book> getDiscount(List<Book> books) {
        books.stream().forEach(v -> {
            v.setHighestPrice(Double.valueOf(v.getPrice()) * CODE_SELL.get(0) / 10);
            v.setLowestPrice(Double.valueOf(v.getPrice()) * CODE_SELL.get(2) / 10);
            v.setDiscount(DiscountUtil.CODE_SELL.get(0));
        });
        return books;
    }

    public static List<BookOfWarehouse> getDiscountByWarehouseBooks(List<BookOfWarehouse> books) {
        books.stream().forEach(v -> {
            v.setPrice((Double.parseDouble(v.getPrice()) * CODE_BUY.get(v.getAppearance()) / 10) + "");
            v.setDiscount(DiscountUtil.CODE_BUY.get(v.getAppearance()));
        });
        return books;
    }

    public static List<Cart> getDiscountByCart(List<Cart> carts) {
        carts.stream().forEach(v -> {
            v.setPrice((Double.parseDouble(v.getPrice()) * CODE_BUY.get(v.getAppearance()) / 10) + "");
        });
        return carts;
    }

    public static Map<Integer, Double> CODE_BUY = new HashMap<>();
    public static Map<Integer, Double> CODE_SELL = new HashMap<>();

    static {
        CODE_BUY.put(0, 7.5);
        CODE_BUY.put(1, 5.0);
        CODE_BUY.put(2, 4.0);
        CODE_BUY.put(3, 0.0);

        CODE_SELL.put(0, 3.0);
        CODE_SELL.put(1, 2.5);
        CODE_SELL.put(2, 2.0);
    }

}
