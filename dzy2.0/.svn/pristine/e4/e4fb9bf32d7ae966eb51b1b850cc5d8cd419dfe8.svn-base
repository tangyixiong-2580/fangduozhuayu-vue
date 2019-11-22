package cn.dzy.manage.boss.manage.controller;


import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.bean.book.BookCollection;
import cn.dzy.manage.boss.manage.dao.BookCollectionDao;
import cn.dzy.manage.boss.manage.service.BookCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@RequestMapping("/dzy/book/collection")
@RestController
public class BookCollectionController {
    @Resource
    BookCollectionDao dao;
    @Autowired
    BookCollectionService service;


    @GetMapping
    private BizResponse getBookCollection(@RequestParam("isLimit")int isLimit,@RequestParam(value = "page", defaultValue = "1") Integer page,@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        long time = new Date().getTime();
        System.err.println(time);
        return service.getBookCollections(new Date().getTime(), isLimit, page, pageSize);
    }
    @PostMapping
    private BizResponse add(@RequestBody BookCollection bookCollection){
        dao.add(bookCollection);
        return BizResponse.of(0,null);
    }
    @GetMapping("/{id}")
    private BizResponse getBookCollectionById(@PathVariable("id") String id){
        BookCollection collectionById = service.getCollectionById(id);
        if (collectionById == null) return  BizResponse.of(205,null);
        return  BizResponse.of(0,collectionById);
    }
    @GetMapping("/img")
    public BizResponse getHeaderImg(@RequestParam("count") int count,@RequestParam("collectionId") String collectionId){
        List<String> imgs = dao.getHeaderImgByDetailed(count, collectionId);
        if (imgs == null) return  BizResponse.of(0,null);
        return  BizResponse.of(0,imgs);
    }
}


