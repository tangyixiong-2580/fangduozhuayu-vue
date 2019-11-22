package cn.dzy.manage.boss.manage.service;

import cn.dzy.manage.boss.manage.bean.Token;
import cn.dzy.manage.boss.manage.dao.TokenMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TokenService {

    @Resource
    TokenMapper tokenMapper;

    public Token getUserIdByToken(String token){
        return tokenMapper.getUserIdByToken(token);
    }

    public Boolean addToken(Token token){
        return tokenMapper.addToken(token);
    };

    public Token queryByUserId(Integer userId){
        return tokenMapper.queryByUserId(userId);
    };

    public void updateToken(Token token) {
        tokenMapper.updateToken(token);
    }

    public Boolean deleteToken(String token) {
        return tokenMapper.deleteToken(token);
    }
}
