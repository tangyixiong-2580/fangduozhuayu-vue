package cn.dzy.manage.boss.manage.controller;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.bean.book.BookOfWarehouse;
import cn.dzy.manage.boss.manage.service.WarehouseService;
import cn.dzy.manage.boss.manage.utils.DiscountUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/dzy/warehouse")
public class WarehouseController {
    @Resource
    WarehouseService service;

    // 获取仓库所有的书
    @GetMapping("/books")
    public BizResponse getAllBooks() {
        List<BookOfWarehouse> bookOfWarehouses = service.queryAllBook();
        if (bookOfWarehouses.isEmpty()) return BizResponse.of(205, null);

        for (BookOfWarehouse book : bookOfWarehouses) {
            book.setCurrentPrice(Double.valueOf(book.getPrice()) * DiscountUtil.CODE_BUY.get(book.getAppearance()) / 10);
            book.setDiscount(DiscountUtil.CODE_BUY.get(book.getAppearance()));
        }

        Set<BookOfWarehouse> books = new TreeSet<BookOfWarehouse>(new Comparator<BookOfWarehouse>() {
            public int compare(BookOfWarehouse o1, BookOfWarehouse o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        bookOfWarehouses.stream().forEach(book -> books.add(book));

        System.out.println("books = " + books);
        return BizResponse.of(0, books);
    }


    //根据书籍Id查询单个书籍详情
    @GetMapping("/bookInfo/{bookId}")
    private BizResponse getBookByBookId(@PathVariable("bookId") String bookId) {
        List<BookOfWarehouse> books = service.getBookIdByBook(bookId);
        if (books.isEmpty()) return BizResponse.of(205, null);
        BookOfWarehouse book = books.get(0);
        book.setCurrentPrice(Double.valueOf(book.getPrice()) * DiscountUtil.CODE_BUY.get(book.getAppearance()) / 10);
        book.setDiscount(DiscountUtil.CODE_BUY.get(book.getAppearance()));
        return BizResponse.of(0, book);
    }

    //根据书籍Id查询单个书籍详情
    @GetMapping("/books/{bookId}")
    private BizResponse getBooksByBookId(@PathVariable("bookId") String bookId) {
        List<BookOfWarehouse> books = service.getBookIdByBook(bookId);
        if (books.isEmpty()) return BizResponse.of(205, null);
        books = DiscountUtil.getDiscountByWarehouseBooks(books);
        return BizResponse.of(0, books);
    }

    // 相关推荐
    @GetMapping("/recommend")
    public BizResponse getRecommendByBookId(@RequestParam("bookId") String bookId) {
        List<BookOfWarehouse> result = service.getBooks(bookId);

        Set<BookOfWarehouse> books = new TreeSet<BookOfWarehouse>(new Comparator<BookOfWarehouse>() {
            public int compare(BookOfWarehouse o1, BookOfWarehouse o2) {
                return o1.getBookId().compareTo(o2.getBookId());
            }
        });

        result.stream().forEach(book -> books.add(book));
        System.out.println("books = " + books);

        return BizResponse.of(0, books);
    }

}
