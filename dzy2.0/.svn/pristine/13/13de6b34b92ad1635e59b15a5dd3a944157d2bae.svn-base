package cn.dzy.manage.boss.manage.service;

import cn.dzy.manage.boss.manage.bean.book.Book;
import cn.dzy.manage.boss.manage.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookDao bookDao;

    public void addBooks(String isbn10, String isbn13, Integer userId){
        bookDao.addBooks(isbn10, isbn13, userId);
    }

    public void addUnsoldBooks(String bookId, String bookIsbn13, String bookIsbn10, String bookTitle, String author, String price, String publisher, String pic, String pubdate, String score,String summary,String binding) {
        bookDao.addUnsoldBooks(bookId, bookIsbn13, bookIsbn10, bookTitle, author, price, publisher, pic, pubdate, score,summary,binding);
    }

    public Boolean deleteUnsoldBooks(Integer userId, String isbn) {
        return bookDao.deleteUnsoldBooks(userId, isbn);
    }

    public List<Book> qeuryUnsoldBooks(Integer id) {
        return bookDao.qeuryUnsoldBooks(id);
    }

    public List<Book> queryByIsbn(Integer userId, String isbn) {
        return bookDao.queryByIsbn(userId, isbn);
    }

    public List<Book> queryBookIsRepeat(String bookTitle, String author, String publisher, String isbn10, String isbn13) {
        return bookDao.queryBookIsRepeat(bookTitle, author, publisher, isbn10, isbn13);
    }

    public List<Book> qeuryUnsoldRefusedBooks(Integer userId) {
        return bookDao.qeuryUnsoldRefusedBooks(userId);
    }

}
