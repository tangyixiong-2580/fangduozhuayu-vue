package com.c1801.spring.dzy.controller.coupon;

import com.c1801.spring.dzy.common.PageInfo;
import com.c1801.spring.dzy.common.ResData;
import com.c1801.spring.dzy.mapper.CouponMapper;
import com.c1801.spring.dzy.model.Coupon;
import com.c1801.spring.dzy.model.User;
import com.c1801.spring.dzy.model.UserCoupon;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/dzy/coupon")
public class CouponController {
    @Autowired
    public CouponMapper couponMapper;

    @GetMapping
    public ResData queryCoupon(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<UserCoupon> coupons = couponMapper.queryCouponByUser(user.getId(),0);
        System.out.println(coupons);
        return ResData.ofSuccess(0,coupons.size()+"",coupons);
    }

}
