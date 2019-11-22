package cn.dzy.manage.boss.manage.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddressMapper {

    @Insert("INSERT INTO address\n" +
            "\t(mailing_id, user_id, order_id, mailing_address,detailed_address, mailing_phone,mailing_name)\n" +
            "\tVALUES (#{mailing_id}, #{user_id}, #{order_id},#{mailing_address},#{detailedAddress}, #{mailing_phone},#{name})")
    void add(@Param("mailing_id") String mailing_id,@Param("user_id") int user_id, @Param("order_id") String order_id,
             @Param("mailing_address") String mailing_address,String detailedAddress, @Param("mailing_phone") String mailing_phone,
             @Param("name")  String name);

}
