package cn.dzy.manage.boss.manage.service;

import cn.dzy.manage.boss.manage.bean.Fabulous;
import cn.dzy.manage.boss.manage.bean.book.BookCollectionDetailed;
import cn.dzy.manage.boss.manage.dao.BookCollectionDao;
import cn.dzy.manage.boss.manage.dao.BookCollectionDetailedDao;
import cn.dzy.manage.boss.manage.dao.FabulousDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FabulousService {
    @Resource
    FabulousDao fabulousDao;
    @Resource
    BookCollectionDao  bookCollectionDao;
    @Resource
    BookCollectionDetailedDao bookCollectionDetailedDao;
    public void add(int bookCollectionDetailedId,int userId){
        fabulousDao.add(bookCollectionDetailedId, userId);
        Fabulous lastInfo = fabulousDao.getLastInfo();
        //获取最新的修改时间
        Date updateTime = lastInfo.getUpdateTime();
        BookCollectionDetailed detailed = bookCollectionDetailedDao.getDetailedByFabulous(lastInfo.getId());
        bookCollectionDetailedDao.editUpdate(detailed.getBookId(),updateTime);
        bookCollectionDao.update(updateTime,detailed.getBookCollectionId());
    }
}