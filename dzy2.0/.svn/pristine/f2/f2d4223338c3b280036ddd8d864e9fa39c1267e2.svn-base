package cn.dzy.manage.boss.manage.dao;

import cn.dzy.manage.boss.manage.bean.address.Address;
import org.apache.ibatis.annotations.*;
import cn.dzy.manage.boss.manage.bean.user.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Select("SELECT user_id, phone, sell_fee,login_status, create_time,update_time\n" +
            "\tFROM user")
    List<User> queryAll();

    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    @Select("SELECT user_id as userId, name, sex, open_id as openId, phone, sell_fee as sellFee, login_status as loginStatus, disabled_status as disabledStatus, header_img as headerImg, create_time as createTime, update_time as updateTime FROM user WHERE user_id = #{userId}")
    User get(int id);

    /**
     * 新增
     *
     * @param user
     */
    @Insert("INSERT INTO user\n" +
            "\t(phone,sell_fee,login_status)\n" +
            "\tVALUES (#{phone}, #{sellFee},#{loginStatus})")
    void insert(User user);

    @Insert("INSERT INTO user (name, sex, open_id, sell_fee, login_status, header_img) VALUES (#{name}, #{sex}, #{openId}, #{sellFee}, 1, #{headerImg})")
    void insertNewUser(User user);

    /**
     * 根据手机号码获取用户信息
     *
     * @param phoneNum
     */
    @Select("SELECT user_id, phone, sell_fee, disabled_status, header_img, login_status,create_time,update_time FROM user WHERE phone=#{phoneNum}")
    User getUserByPhone(String phoneNum);

    @Select("SELECT user_id, phone, sell_fee, disabled_status, header_img, login_status,create_time,update_time FROM user WHERE open_id=#{openId}")
    User getUserByOpenId(String openId);

    /**
     * 查询指定用户的所有地址
     *
     * @param userId
     * @return
     */
    @Select("SELECT mailing_id, user_id, order_id, mailing_name as name, mailing_address, detailed_address, mailing_phone, create_time, update_time from `address` where user_id = #{userId}")
    List<Address> getAddressByUserId(Integer userId);

    @Select("SELECT disabled_status FROM user WHERE user_id = #{userId}")
    User getDisabledStatusByUserId(Integer userId);

    @Update("UPDATE user SET header_img=#{avatar} WHERE user_id =#{userId} ")
    void updateAvatar(Integer userId, String avatar);

    @Update("UPDATE user SET name=#{name}, sex=#{sex}, open_id=#{openId}, sell_fee=#{sellFee},header_img=#{headerImg} WHERE user_id = #{userId} ORDER BY expired_time")
    void updateUser(User user);


    @Select("SELECT md.id, md.userId, md.money, md.`type`, md.create_time, md.update_time, `order`.order_id\n" +
            "FROM money_detailed md \n" +
            "LEFT JOIN `order` ON `order`.money_id = md.id WHERE md.userId = #{userId}")
    List<Money> getMoneyDetailedByUserId(String userId);

    @Select("SELECT id, user_id, money, expired_time, `status`, `type`, create_time, update_time FROM coupon WHERE user_id = #{userId}")
    List<Coupon> getCouponsByUserId(String userId);
}
