package cn.dzy.manage.boss.manage.controller;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.bean.Fabulous;
import cn.dzy.manage.boss.manage.bean.book.BookCollectionDetailed;
import cn.dzy.manage.boss.manage.bean.user.User;
import cn.dzy.manage.boss.manage.dao.FabulousDao;
import cn.dzy.manage.boss.manage.utils.TokenUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dzy/upvote")
public class FabulousController {
    @Resource
    FabulousDao dao;
    //点赞
    @PostMapping("/{detailedId}")
    public BizResponse add(@PathVariable("detailedId") int bookCollectionDetailedId, @RequestHeader ("token")String token){
        if (token == null) return BizResponse.of(205,"需要登录",new Object());
        Integer userId = TokenUtil.getUserId(token);
        dao.add(bookCollectionDetailedId,userId);
        BookCollectionDetailed fabulous = dao.getFabulousByUserIdAndDetailedId(userId, bookCollectionDetailedId);
        System.err.println(fabulous);
        return BizResponse.of(0,fabulous);
    }

    //取消点赞
    @DeleteMapping("/cancel/{id}")
    public BizResponse del(@PathVariable("id") int id,@RequestHeader("token") String token){
        Integer userId = TokenUtil.getUserId(token);
        Fabulous fabulous = dao.get(userId, id);
        System.err.println(fabulous);
        System.out.println("取消点赞："+id);
        dao.delete(fabulous.getId());
        return BizResponse.of(0,null);
    }
    //用户是否点赞了指定的书单详情
    @GetMapping("/up/{detailedId}")
    public BizResponse getFabulousByUserIdAndDetailedId(@RequestHeader ("token")String token,@PathVariable("detailedId") int detailedId){
        Integer userId = TokenUtil.getUserId(token);
        BookCollectionDetailed fabulous = dao.getFabulousByUserIdAndDetailedId(userId, detailedId);
        if (fabulous == null) return BizResponse.of(0,null);
        fabulous.setUp(true);
        return BizResponse.of(0,fabulous);
    }
    @GetMapping("/up")
    public BizResponse getUp(@RequestParam("id") int id){
        List<User> up = dao.getUp(id);
        if (up == null) return  BizResponse.of(205,null);
        return BizResponse.of(0,up);
    }
}
