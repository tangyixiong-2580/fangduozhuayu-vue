package com.c1801.spring.dzy.service;

import com.c1801.spring.dzy.common.ResData;
import com.c1801.spring.dzy.mapper.CouponMapper;
import com.c1801.spring.dzy.model.Coupon;
import com.c1801.spring.dzy.model.CouponRule;
import com.c1801.spring.dzy.model.UserCoupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 黄
 * 优惠券
 */
@Service
public class CouponService {
    @Autowired
    CouponMapper couponMapper;

    /**
     * 满足消费门槛发送优惠券
     * @param id                用户id
     * @param money             金额
     * @param remarks           备注
     */
    public void sendCouponByMoney(Integer id, double money,String remarks){
        CouponRule rule = couponMapper.queryCouponByMoney(money);
        if(rule!=null){
            Integer couponID = rule.getId();
            Integer count = rule.getCount();
            Integer expiresIn = couponMapper.queryCouponInfoByID(couponID).getExpiresIn();


            SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

            Calendar cd = Calendar.getInstance();
            cd.setTime(new Date());
            cd.add(Calendar.DAY_OF_MONTH, expiresIn);


            Date expirationDate = new Date(cd.getTimeInMillis ());
            UserCoupon coupon = new UserCoupon(id, couponID,remarks,expirationDate);


            for (Integer i = 0; i < count; i++) {
                couponMapper.sendCoupon(coupon);
            }
        }
    }

    /**
     * 发送优惠券
     * @param coupon
     */
    public boolean sendCoupon(UserCoupon coupon){
        return couponMapper.sendCoupon(coupon);
    }


    /**
     * 给新用户发送优惠券
     * @param id
     * @param remark
     * @return
     */
    public boolean sendUserCoupon(Integer id ,String remark){
        UserCoupon coupon =new UserCoupon();
        coupon.setUserId(id);
        coupon.setCouponId(1);
        coupon.setRemark(remark==null?"":remark);
        return couponMapper.sendCoupon(coupon);
    }

    /**
     * 使用优惠券
     * @param id
     */
    public boolean useCoupon(Integer id){
        return couponMapper.updateCoupon(id,1)&&couponMapper.updateUseTime(id,new Date());
    }


    /**
     * 取消使用优惠券-取消订单时调用
     * @param id
     */
    public boolean cancelUseCoupon(Integer id){
        return couponMapper.updateCoupon(id,0)&&couponMapper.updateUseTime(id,null);
    }
    /**
     * 查询用户某张优惠券的信息，若查询不到则被使用了
     * @param id        优惠券id
     * @param userId    用户id
     * @return Coupon   {id,name,remark备注,type类型,amount费用,c.per_limit使用门槛,expiration_date截止日期,c.expires_in,uc.create_date,uc.update_date}
     */
    public Coupon queryCouponByUser(Integer id , Integer userId){
        return couponMapper.queryCouponByUserID(id,userId,0);
    }
}
