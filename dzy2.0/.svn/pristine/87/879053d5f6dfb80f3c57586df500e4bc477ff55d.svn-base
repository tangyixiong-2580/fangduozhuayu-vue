package cn.dzy.manage.boss.manage.controller;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WeChatController {
/*

    private Map<String, LinkedHashMap> USERS = new LinkedHashMap<>();

    @GetMapping("/auth")
    public void auth(String code, HttpSession session, HttpServletResponse response) throws IOException {

        // 获取accessToken和openId
        RestTemplate restTemplate = new RestTemplate();
        String accessTokeUrl = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxc3758a49f9d0e965&secret=d87264c0049d20cc3d4a90124e2125d8&code=%s&grant_type=authorization_code", code);
        ResponseEntity<String> entity = restTemplate.getForEntity(accessTokeUrl, String.class);
        LinkedHashMap hashMap = JSON.parseObject(entity.getBody(), LinkedHashMap.class);
        String accessToken = (String) hashMap.get("access_token");
        String openId = (String) hashMap.get("openid");

        // 用户授权登录
        String userInfoUrl = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", accessToken, openId);
        LinkedHashMap userInfoMap = JSON.parseObject(restTemplate.getForObject(userInfoUrl, String.class), LinkedHashMap.class);

        session.setAttribute("USER", userInfoMap);
        USERS.put(openId, userInfoMap);
    }

    @GetMapping("/info")
    public Object info(HttpSession session) {
        LinkedHashMap user = (LinkedHashMap) session.getAttribute("USER");
        if (user == null) return "没有登录";
        return user;
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        LinkedHashMap user = (LinkedHashMap) session.getAttribute("USER");
        if (user == null) return "没有登录";
        USERS.remove(user.get("openid"));
        session.invalidate();
        return "退出成功";
    }

    @GetMapping("/users")
    public Object users(HttpSession session) {
        LinkedHashMap user = (LinkedHashMap) session.getAttribute("USER");
        if (user == null) return "没有登录";
        System.out.println(USERS);
        return USERS;
    }

    @RequestMapping("/getcode")
    public BizResponse getCode() {
        String AppKey = "980f3a792e72d63ecfa2328aaa65d927";
        String Text= "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc3758a49f9d0e965&redirect_uri=http://192.168.6.24:9090/dzy/user/login/newUser&response_type=code&scope=snsapi_userinfo#wechat_redirect";
        String url = "http://apis.juhe.cn/qrcode/api?key=" + AppKey + "&text="+Text;
        String str = HttpUtil.client(url);
        JSONObject object = JSON.parseObject(str);
        String base64 = object.getJSONObject("result").get("base64_image").toString();

        return BizResponse.of(0,base64);
    }
*/

}
