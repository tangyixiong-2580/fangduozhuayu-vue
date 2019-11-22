package cn.dzy.manage.boss.manage.controller;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.bean.Fabulous;
import cn.dzy.manage.boss.manage.bean.Pager;
import cn.dzy.manage.boss.manage.bean.book.BookCollectionDetailed;
import cn.dzy.manage.boss.manage.dao.BookCollectionDetailedDao;
import cn.dzy.manage.boss.manage.dao.FabulousDao;
import cn.dzy.manage.boss.manage.service.BookCollectionDetailedService;
import cn.dzy.manage.boss.manage.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dzy/collection/detailed")
public class BookCollectionDetailedController {
    @Autowired
    BookCollectionDetailedService service;
    @Resource
    BookCollectionDetailedDao dao;
    @Resource
    FabulousDao fabulousDao;
    @GetMapping
    public BizResponse allDetailedByCId(@RequestParam("collectionId") String collectionId, @RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<BookCollectionDetailed> detailedList = new ArrayList<>();
        //第一本
        BookCollectionDetailed first = service.firstInfo(collectionId);
        detailedList.add(first);
        //其他的书
        List<BookCollectionDetailed> other = service.getAllDetailed(collectionId, first.getId());
        for (BookCollectionDetailed detailed : other) {
            detailedList.add(detailed);
        }
        if (detailedList == null) return BizResponse.of(205, null);
        //分页
        Pager pager = new Pager();
        pager.setIndex(page);//当前所在页数
        pager.setTotal(detailedList.size());//总数据
        int totalPages = (int) Math.ceil(detailedList.size() / Double.valueOf(pageSize));//最大页数 （总数据除每页条数）
        if (totalPages > 0 && page > totalPages) {
            page = totalPages;
        }
        pager.setTotalPage(totalPages);//总页数
        pager.setSize(pageSize);//每页数据多少条
        int extents = (page - 1) * pageSize;
        detailedList = detailedList.stream().skip(extents).limit(pageSize).collect(Collectors.toList());
        return BizResponse.of(0, detailedList);
    }

    //推荐
    @PostMapping
    public BizResponse add(@RequestHeader("token") String token, @RequestParam("bookId") String bookId, @RequestParam("reason") String reason, @RequestParam("bookCollectionId") String bookCollectionId) {
        int userId = TokenUtil.getUserId(token);
        BookCollectionDetailed detailed = new BookCollectionDetailed();
        detailed.setUserId(userId);
        detailed.setBookId(bookId);
        detailed.setBookCollectionId(bookCollectionId);
        detailed.setReason(reason);
        String msg = service.recommend(detailed);
        Object o = null;
        return BizResponse.of(0, msg, o);
    }

    //获取指定的书单详情
    @GetMapping("/{id}")
    public BizResponse getSingleDetailed(@PathVariable("id") int id) {
        BookCollectionDetailed singleDetailed = service.getSingleDetailed(id);
        if (singleDetailed == null) return BizResponse.of(205, null);
        return BizResponse.of(0, singleDetailed);
    }
}
