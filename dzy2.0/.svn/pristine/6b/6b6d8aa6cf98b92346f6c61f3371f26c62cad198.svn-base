package cn.dzy.manage.boss.manage.service;

import cn.dzy.manage.boss.manage.bean.book.BookOfWarehouse;
import cn.dzy.manage.boss.manage.dao.book.WarehouseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WarehouseService {
    @Resource
    WarehouseMapper mapper;

    public List<BookOfWarehouse> queryAllBook(){
        return mapper.queryAllBook();
    }

    public List<BookOfWarehouse> getBooks(String bookId){
        List<BookOfWarehouse> books = mapper.queryAllExceptTheBook(bookId);
        return books;
    }

    public List<BookOfWarehouse> getBookIdByBook(String bookId) {
        return mapper.getBookIdByBook(bookId);
    }
}
