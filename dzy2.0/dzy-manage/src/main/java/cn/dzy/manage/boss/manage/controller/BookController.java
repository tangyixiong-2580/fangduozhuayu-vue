package cn.dzy.manage.boss.manage.controller;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.bean.book.Book;
import cn.dzy.manage.boss.manage.dao.BookDao;
import cn.dzy.manage.boss.manage.service.BookService;
import cn.dzy.manage.boss.manage.utils.DiscountUtil;
import cn.dzy.manage.boss.manage.utils.HttpUtil;
import cn.dzy.manage.boss.manage.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/dzy/book")
@Slf4j
public class BookController {

    @Resource
    private BookService bookService;
    @Resource
    private BookDao dao;

    // 用户添加待卖书籍
    @PostMapping("/unsold/isbn")
    private BizResponse addUnsoldBookByIsbn(@RequestHeader("token") String token, @RequestParam("isbn") String isbns) {
        String URL = "http://book.api.p.cn/isbn/";

        //根据token获取用户id
        Integer userId = TokenUtil.getUserId(token);

        List<Book> bool = bookService.queryByIsbn(userId, isbns);
        if (!bool.isEmpty()) return BizResponse.of(203, null);

        String url = URL + isbns;
        Book book = HttpUtil.clientUrl(url);
        System.out.println("book = " + book);
        if (book == null) return BizResponse.of(202, null);


        Random random = new Random();
        String id = System.currentTimeMillis() + "" + random.nextInt(1000);

        List<Book> isBook = bookService.queryBookIsRepeat(book.getTitle(), book.getAuthor(), book.getPublisher(), book.getIsbn10(), book.getIsbn13());
        if (isBook.isEmpty())
            bookService.addUnsoldBooks(id, book.getIsbn13(), book.getIsbn10(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getPublisher(), book.getPic(), book.getPubdate(), book.getScore(), book.getSummary(), book.getBinding());
        bookService.addBooks(book.getIsbn10(), book.getIsbn13(), userId);

        book.setUserId(userId);
        book.setBookId(id);
        return BizResponse.of(0, book);
    }

    //删除单个书籍
    @DeleteMapping("/unsold/cancel/isbn/{isbn}")
    private BizResponse delUnsoldBookByIsbnAndUserId(@RequestHeader("token") String token, @PathVariable("isbn") String isbn) {
        Integer userId = TokenUtil.getUserId(token);

        Boolean bool = bookService.deleteUnsoldBooks(userId, isbn);
        if (!bool) return BizResponse.of(206, null);
        System.out.println("删除-----bool = " + bool);
        return BizResponse.of(0, null);
    }

    //书籍列表（收）
    @GetMapping("/unsold")
    private BizResponse getUnsoldBookByUserId(@RequestHeader("token") String token) {
        Integer userId = TokenUtil.getUserId(token);
        List<Book> books = bookService.qeuryUnsoldBooks(userId);
        if (books.isEmpty()) return BizResponse.of(205, null);

        books = DiscountUtil.getDiscount(books);

        System.out.println("待卖列表----books = " + books);
        return BizResponse.of(0, books);
    }

    //书籍列表（不收）
    @GetMapping("/unsold/refused")
    private BizResponse getUnsoldBookRefusedByUserId(@RequestHeader("token") String token) {
        Integer userId = TokenUtil.getUserId(token);

        List<Book> books = bookService.qeuryUnsoldRefusedBooks(userId);
        if (books.isEmpty()) return BizResponse.of(205, null);
        return BizResponse.of(0, books);
    }
    //根据书名模糊查询
    @GetMapping("/search")
    private BizResponse fuzzyQueryByTitle(@RequestParam("title") String title){
        List<Book> books = dao.fuzzyQueryByTitle(title);
        if (books.isEmpty()) return BizResponse.of(205,null);
        return BizResponse.of(0,books);
    }

    //根据书名和品相模糊查询
    @GetMapping("/search/appearance")
    private BizResponse fuzzyQueryAppearanceByTitle(@RequestParam("title") String title) {
        List<Book> books = dao.fuzzyQueryAppearanceByTitle(title);
        if (books.isEmpty()) return BizResponse.of(205, null);
        return BizResponse.of(0, books);
    }
    @GetMapping("/{id}")
    public BizResponse getBookByBookId(@PathVariable("id") String id){
        Book book = dao.getBookByBookId(id);
        if (book == null) return BizResponse.of(205,null);
        return BizResponse.of(0,book);
    }
}
