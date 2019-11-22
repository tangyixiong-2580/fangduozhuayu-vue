package cn.dzy.manage.boss.manage.utils;

import cn.dzy.manage.boss.manage.bean.Token;
import cn.dzy.manage.boss.manage.bean.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {
    //生成Token信息方法（根据有效的用户信息）
    public static String creatToken(Integer userId, Date date) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT") // 设置header
                .setHeaderParam("alg", "HS256").setIssuedAt(date) // 设置签发时间
                .setExpiration(new Date(date.getTime() + 1000 * 60 * 60 * 24 * 3))
                .claim("userId",String.valueOf(userId) ) // 设置内容
                .setIssuer("lws")// 设置签发人
                .signWith(signatureAlgorithm, "jiayu"); // 签名，需要算法和key
        String jwt = builder.compact();
        return jwt;
    }

    //根据token拿到用户id
    public static Integer getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey("jiayu").parseClaimsJws(token).getBody();
        String userIds = (String)claims.get("userId");
        Integer userId = Integer.parseInt(userIds);
        return userId;
    }

}
