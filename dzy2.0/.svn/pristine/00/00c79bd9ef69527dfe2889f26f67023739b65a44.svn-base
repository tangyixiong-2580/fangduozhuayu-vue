package cn.dzy.manage.boss.manage.controller;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.bean.Token;
import cn.dzy.manage.boss.manage.bean.address.Address;
import cn.dzy.manage.boss.manage.bean.user.*;
import cn.dzy.manage.boss.manage.dao.CartMapper;
import cn.dzy.manage.boss.manage.dao.UserMapper;
import cn.dzy.manage.boss.manage.service.*;
import cn.dzy.manage.boss.manage.utils.TokenUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/dzy/user")
public class UserController {
    // 用户Service
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserMapper mapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    StringRedisTemplate redisTemplate;

    private final String APPID = "wxc3758a49f9d0e965";

    private final String SECRET = "d87264c0049d20cc3d4a90124e2125d8";

    // 查询单个用户信息
    @GetMapping
    public BizResponse getUserByUserId(@RequestHeader("token") String token) {
        Integer userId = TokenUtil.getUserId(token);
        User user = userService.get(userId);
        System.out.println("user = " + user);
        if (user == null) return BizResponse.of(205, null);
        return BizResponse.of(0, user);
    }

    // 发送手机号码获取验证码
    @GetMapping("/sendMsg")
    public BizResponse getMsgByPhone(@RequestParam("phone") String phone, HttpServletRequest request) {
        User user = userService.queryUserByPhone(phone);
        if (user != null && user.getDisabledStatus() == 1) {
            return BizResponse.of(209, null);
        }

        String msg = userService.mobileQuery(phone);
        request.getSession().setAttribute("verification", msg);
        request.getSession().setMaxInactiveInterval(60 * 3);
        System.out.println("验证码：" + msg);
        return BizResponse.of(0, msg);
    }

    // 发送手机号码和验证码进行登录
    @PostMapping("/login/oldUser")//验证码
    public BizResponse login(@RequestParam("phoneNum") String phoneNum, @RequestParam("verification") String verification, HttpSession session) {
        System.out.println("verification = " + verification);
        if (verification.isEmpty() || verification == null) return BizResponse.of(250, null);

        Object verification1 = session.getAttribute("verification");
        System.out.println("verification1 = " + verification1);
        if (!verification.equals(verification1.toString())) return BizResponse.of(250, null);

        System.out.println("登录，手机号码：" + phoneNum);

        User user = userService.queryUserByPhone(phoneNum);
        if (user == null) return BizResponse.of(206, null);

        LinkedHashMap userInfoMap = (LinkedHashMap) session.getAttribute("USERS");
        if (userInfoMap == null) return BizResponse.of(240, null);
        if (user.getOpenId() != "" && user.getOpenId() != userInfoMap.get("openid")) {
            return BizResponse.of(220, null);
        }
      /*  String users = redisTemplate.opsForValue().get("USERS");
        System.out.println("users = " + users);
        if(users == null) return BizResponse.of(240,null);
        LinkedHashMap userInfoMap = JSON.parseObject(users,LinkedHashMap.class);*/

        user.setOpenId((String) userInfoMap.get("openid"));
        user.setHeaderImg((String) userInfoMap.get("headimgurl"));
        user.setName((String) userInfoMap.get("nickname"));
        user.setSex((Integer) userInfoMap.get("sex"));

        System.out.println("user = " + user);
        userService.updateUser(user);

        Token token = tokenService.queryByUserId(user.getUserId());
        String TokenStr = "";
        Date date = new Date();
        int nowTime = (int) (date.getTime() / 1000);
        //生成Token
        TokenStr = TokenUtil.creatToken(user.getUserId(), date);
        if (token == null) {
            token = new Token();
            token.setToken(TokenStr);
            token.setBuildTime(nowTime);
            token.setUserId(user.getUserId());
            tokenService.addToken(token);
        } else {
            token.setToken(TokenStr);
            token.setBuildTime(nowTime);
            tokenService.updateToken(token);
        }

        //将用户信息存进redis
        redisTemplate.opsForValue().set(token.getToken(), JSON.toJSONString(user));
        System.out.println("token = " + token);

        return BizResponse.of(0, token.getToken());
    }

    @GetMapping("/auth")
    public BizResponse auth(@RequestParam("code") String code, HttpSession session) throws UnsupportedEncodingException {
        System.out.println(code);
        RestTemplate restTemplate = new RestTemplate();

        String accessTokeUrl = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", APPID, SECRET, code);
        ResponseEntity<String> entity = restTemplate.getForEntity(accessTokeUrl, String.class);
        System.out.println("entity.getStatusCode() = " + entity.getStatusCode());
        LinkedHashMap hashMap = JSON.parseObject(entity.getBody(), LinkedHashMap.class);
        String accessToken = (String) hashMap.get("access_token");
        String openId = (String) hashMap.get("openid");
        String userInfoUrl = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", accessToken, openId);

        //解决乱码
        String forObject = restTemplate.getForObject(userInfoUrl, String.class);
        forObject = new String(forObject.getBytes("ISO-8859-1"), "UTF-8");
        LinkedHashMap userInfoMap = JSON.parseObject(forObject, LinkedHashMap.class);

        session.setAttribute("USERS", userInfoMap);
//        redisTemplate.opsForValue().set("USERS",JSON.toJSONString(userInfoMap));
        User user = userService.queryUserByOpenId(openId);
        if (user == null) return BizResponse.of(230, null);

        System.out.println("user = " + user);
        Token token = tokenService.queryByUserId(user.getUserId());
        System.out.println("token = " + token);
        System.out.println("user.getUserId() = " + user.getUserId());
        //为生成Token准备
        String TokenStr = "";
        Date date = new Date();
        int nowTime = (int) (date.getTime() / 1000);
        //生成Token
        TokenStr = TokenUtil.creatToken(user.getUserId(), date);

        if (token == null) {
            token = new Token();
            token.setToken(TokenStr);
            token.setBuildTime(nowTime);
            token.setUserId(user.getUserId());
            tokenService.addToken(token);
        } else {
            token.setToken(TokenStr);
            token.setBuildTime(nowTime);
            tokenService.updateToken(token);
        }

        //将用户信息存进redis
        redisTemplate.opsForValue().set(token.getToken(), JSON.toJSONString(user));
        System.out.println("token = " + token);

        return BizResponse.of(0, token.getToken());

    }

    @PostMapping("/login/newUser")// 微信授权登录
    public BizResponse login(HttpSession session) {
        LinkedHashMap userInfoMap = (LinkedHashMap) session.getAttribute("USERS");
        if (userInfoMap == null) return BizResponse.of(240, null);

        System.out.println("userInfoMap = " + userInfoMap);
        String openId = (String) userInfoMap.get("openid");

        User user = new User();
        user.setOpenId(openId);
        user.setSellFee(0.00);
        user.setHeaderImg((String) userInfoMap.get("headimgurl"));
        user.setName((String) userInfoMap.get("nickname"));
        user.setSex((Integer) userInfoMap.get("sex"));
        user.setLoginStatus(1);

        userService.insertNewUser(user);
        user = userService.queryUserByOpenId(openId);

        String TokenStr = "";
        Date date = new Date();
        int nowTime = (int) (date.getTime() / 1000);
        //生成Token
        TokenStr = TokenUtil.creatToken(user.getUserId(), date);

        Token token = new Token();
        token.setToken(TokenStr);
        token.setBuildTime(nowTime);
        token.setUserId(user.getUserId());
        Boolean bool = tokenService.addToken(token);
        System.out.println("bool = " + bool);

        cartMapper.insertCartByCartIdAndUserId(new Random().nextInt(99999) + "" + System.currentTimeMillis() + user.getUserId(), user.getUserId());

//        将用户信息存进redis
        redisTemplate.opsForValue().set(token.getToken(), JSON.toJSONString(user));

        return BizResponse.of(0, token.getToken());
    }

    @GetMapping("/info")
    public BizResponse info(HttpSession session) {
        LinkedHashMap user = (LinkedHashMap) session.getAttribute("USER");
        if (user == null) return BizResponse.of(204, null);
        return BizResponse.of(0, user);
    }

    @PostMapping("/logout")
    public BizResponse logout(@RequestHeader("token") String token, HttpSession session) {
        Boolean bool = tokenService.deleteToken(token);
        if (!bool) return BizResponse.of(206, null);
        return BizResponse.of(0, null);
    }

    // 获取用户地址
    @GetMapping("/addr")
    public BizResponse getAddressByUserId(@RequestHeader("token") String token) {
        Integer userId = TokenUtil.getUserId(token);
        Address address = userService.getAddressByUserId(userId);
        if (address == null) return BizResponse.of(205, null);
        return BizResponse.of(0, address);
    }

    @PostMapping("/upload/avatar")
    public BizResponse uploadImg(@RequestHeader("token") String token, @RequestParam("headerImg") String avatar) {
        Integer userId = TokenUtil.getUserId(token);
        userService.updateAvatar(userId, avatar);
        return BizResponse.of(0, null);
    }

    @GetMapping("/money")
    public BizResponse getMoneyDetailedByUserId(@RequestHeader("token") String token) {
        List<Money> moneyList = mapper.getMoneyDetailedByUserId(TokenUtil.getUserId(token).toString());
        return BizResponse.of(0, moneyList);
    }

    @GetMapping("/coupon")
    public BizResponse getCouponsByUserId(@RequestHeader("token") String token) {
        List<Coupon> coupons = mapper.getCouponsByUserId(TokenUtil.getUserId(token).toString());
        coupons.stream().forEach(coupon -> coupon.setStartTime(coupon.getCreateTime().getTime()));
        System.out.println("coupons = " + coupons);
        return BizResponse.of(0, coupons);
    }

}