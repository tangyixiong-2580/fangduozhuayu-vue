package cn.dzy.manage.boss.manage.dao;

import cn.dzy.manage.boss.manage.bean.Token;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TokenMapper {

    @Insert("INSERT INTO token (user_id, token, build_time) VALUES (#{userId}, #{token}, #{buildTime})")
    Boolean addToken(Token token);

    @Select("SELECT token_id, user_id, token, build_time FROM token WHERE user_id = #{userId}")
    Token queryByUserId(Integer userId);

    @Select("SELECT token_id, user_id, token, build_time FROM token WHERE token = #{token}")
    Token getUserIdByToken(String token);

    @Update("UPDATE token SET token=#{token}, build_time=#{buildTime} WHERE user_id=#{userId}")
    void updateToken(Token token);

    @Delete("DELETE token FROM token WHERE token = #{token}")
    Boolean deleteToken(String token);
}
