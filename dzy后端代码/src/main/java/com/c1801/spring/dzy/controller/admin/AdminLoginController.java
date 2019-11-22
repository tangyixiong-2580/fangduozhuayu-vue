package com.c1801.spring.dzy.controller.admin;

import com.c1801.spring.dzy.common.ResData;
import com.c1801.spring.dzy.mapper.AdminMapper;
import com.c1801.spring.dzy.model.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 后台管理
 * user：少
 * dateTime: 2019/8/7 22:43
 */
@RestController
@Transactional
@RequestMapping("/manage/login")
public class AdminLoginController {

    @Autowired
    AdminMapper adminMapper;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @PostMapping
    public ResData adminLogin(@RequestBody Admin admin){
        logger.info("管理员登录 = " + admin);
        admin = adminMapper.adminLogin(admin.getName(), admin.getPassword());
        return ResData.ofSuccess(0, "成功", admin);
    }
}
