package com.c1801.spring.dzy.controller.user;

import com.c1801.spring.dzy.common.ResData;
import com.c1801.spring.dzy.mapper.BalanceDetailMapper;
import com.c1801.spring.dzy.mapper.UserMapper;
import com.c1801.spring.dzy.model.BalanceDetail;
import com.c1801.spring.dzy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dzy/detail")
public class BalanceDetailController {
    @Autowired
    BalanceDetailMapper balanceDetailMapper;

    @Autowired
    UserMapper userMapper;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping
    public ResData getByuserId(HttpSession session){
        User u = (User)session.getAttribute("user");
        User user = userMapper.getUserById(u.getId());
        List<BalanceDetail> balanceDetail =  balanceDetailMapper.getUserById(user.getId());
        logger.info("用户获取明细：" + balanceDetail);
        return ResData.of(0, "成功",balanceDetail);
    }

}
