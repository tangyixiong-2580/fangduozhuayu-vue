package cn.dzy.manage.boss.manage.interceptor;

import cn.dzy.manage.boss.manage.bean.user.User;
import cn.dzy.manage.boss.manage.service.TokenService;
import cn.dzy.manage.boss.manage.service.UserService;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;
    @Autowired
    StringRedisTemplate redisTemplate;

    private String[] uri = {"/dzy/warehouse/books", "/dzy/warehouse/recommend","/dzy/warehouse/bookInfo", "/dzy/user/sendMsg", "/dzy/user/login/oldUser", "/dzy/book", "/dzy/user/login/newUser","/dzy/user/auth","/dzy/collection/detailed","/dzy/book/collection","/dzy/thumbsUp"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request = " + request.getRequestURI());

        for (int i = 0; i < uri.length; i++) {
//            System.out.println(request.getRequestURI().contains(uri[i]));
            if (request.getRequestURI().contains(uri[i])) return true;
        }
//        权限路径拦截
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();
        final String headerToken = request.getHeader("token");

        //判断请求信息
        if (null == headerToken || headerToken.trim().equals("")) {
            System.out.println("你没有token,需要登录");
            outputStream.print(207);
            return false;
        }

        try {
            Claims claims = Jwts.parser().setSigningKey("jiayu").parseClaimsJws(headerToken).getBody();
            Date tokenDate = claims.getExpiration();
            int timeOut = (int) (new Date().getTime() - tokenDate.getTime()) / 1000;
            System.out.println("timeOut = " + timeOut);
            if(timeOut > 0){
                System.out.println("token已过期---------timeOut = " + timeOut);
                outputStream.print(208);
                return false;
            }

            String users = redisTemplate.opsForValue().get(headerToken);
            User usr = JSON.parseObject(users, User.class);
            System.out.println("usr = " + usr);
            if (usr.getDisabledStatus() == 1) {
                outputStream.print(209);
                return false;
            }

        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("异常-------------" + e);
            if (e instanceof ExpiredJwtException) {
                outputStream.print(208);
            }
            outputStream.print(210);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
