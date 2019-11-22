package com.c1801.spring.dzy.controller.collection;

import com.c1801.spring.dzy.common.PageInfo;
import com.c1801.spring.dzy.common.ResData;
import com.c1801.spring.dzy.mapper.BookCollectionMapper;
import com.c1801.spring.dzy.model.BookCollection;
import com.c1801.spring.dzy.model.BookCollectionList;
import com.c1801.spring.dzy.model.Pager;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 后台管理：书单
 * user：黄
 * dateTime: 2019/8/26 11:16
 */
@RestController
@Transactional
@RequestMapping("/manage/collection")
public class ManageCollectionController {
    @Autowired
    BookCollectionMapper bookCollectionMapper;

    /**
     * 查询所有书籍
     * @param page
     * @param size
     * @return
     */
    @GetMapping()
    public ResData queryBookCollection(@RequestParam(value = "page", defaultValue = "1") Integer page
                                      ,@RequestParam(value = "size", defaultValue = "5") Integer size){
        PageHelper.startPage(page,size,"sort desc");
        Page<BookCollection> bookCollections = bookCollectionMapper.queryBookCollection();
        PageInfo pageInfo = PageInfo.ofPageInfo(bookCollections);
        System.out.println(pageInfo);
        return ResData.ofSuccess(0, "查询成功",pageInfo);
    }

    /**
     * 查询书单下的书籍
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResData queryBookCollectionByID(@PathVariable Integer id){
        BookCollection bookCollection = bookCollectionMapper.queryBookCollectionByID(id);
        try{
            for(BookCollectionList item :bookCollection.getList()){
                System.out.println(item);
                Integer total = bookCollectionMapper.queryBookCollectionApplaudTotal(item.getId());
                item.setApplaudsTotal(total==null?0:total);
            }
            return ResData.ofSuccess(0, "查询成功",bookCollection);
        }catch(NullPointerException e1){
            return ResData.ofSuccess(1008, "查询成功-但没有数据");
        }
    }
    /**
     * 创建书单
     * @param map
     * @return
     */
    @PostMapping()
    public ResData addBookCollection(@RequestBody HashMap<String,String> map){
        BookCollection bookCollection = new BookCollection();
        bookCollection.setName(map.get("name"));
        bookCollection.setIntro(map.get("intro"));
        bookCollection.setBackgroundImage(map.get("image"));
        bookCollection.setBackgroundColor(map.get("color"));
        bookCollection.setSort(Integer.valueOf(map.get("sort")));
        bookCollection.setState(Boolean.valueOf(map.get("state")));
        bookCollection.setExpirationDate(new Date(Long.valueOf(map.get("expirationDate"))));
        System.out.println(bookCollection);
        bookCollectionMapper.addBookCollection(bookCollection);
        return ResData.ofSuccess(0, "添加成功");
    }


    /**
     * 修改书单信息
     * @param map
     * @return
     */
    @PutMapping
    public ResData updateBookCollectionState(@RequestBody HashMap<String,String> map){
        BookCollection bookCollection = new BookCollection();
        bookCollection.setId(Integer.valueOf(map.get("id")));
        bookCollection.setName(map.get("name"));
        bookCollection.setIntro(map.get("intro"));
        bookCollection.setBackgroundImage(map.get("image"));
        bookCollection.setBackgroundColor(map.get("color"));
        bookCollection.setSort(Integer.valueOf(map.get("sort")));
        bookCollection.setState(Boolean.valueOf(map.get("state")));
        bookCollection.setExpirationDate(new Date(Long.valueOf(map.get("expirationDate"))));
        System.out.println(bookCollection);
        bookCollectionMapper.updateBookCollection(bookCollection);
        return ResData.ofSuccess(0, "修改成功");
    }

    /**
     * 修改上下架状态
     * @param id
     * @param state
     * @return
     */
    @PatchMapping
    public ResData updateBookCollectionState(@RequestParam(value = "id") Integer id,
                                             @RequestParam(value = "state") Boolean state){
        bookCollectionMapper.updateBookCollectionState(id, state);
        return ResData.ofSuccess(0, "修改成功");
    }


}
