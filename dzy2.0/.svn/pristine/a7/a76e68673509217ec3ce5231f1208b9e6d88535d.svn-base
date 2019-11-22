package cn.dzy.manage.boss.manage.service;

import cn.dzy.manage.boss.manage.bean.CodeYml;
import cn.dzy.manage.boss.manage.bean.address.Address;
import cn.dzy.manage.boss.manage.bean.user.User;
import cn.dzy.manage.boss.manage.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    static CodeYml codeYml;
    @Resource
    UserMapper mapper;

    @Autowired
    public List<User> queryAll() {
        return mapper.queryAll();
    }

    public void insert(User user) {
        mapper.insert(user);
    }

    public void insertNewUser(User user) {
        mapper.insertNewUser(user);
    }

    public User get(int id) {
        User user = mapper.get(id);
        return user;
    }

    public User queryUserByPhone(String phone) {
        return mapper.getUserByPhone(phone);
    }

    public User queryUserByOpenId(String openId) {
        return mapper.getUserByOpenId(openId);
    }

    /**
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return 网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params, String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if (method == null || method.equals("GET")) {
                strUrl = strUrl + "?" + urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (method == null || method.equals("GET")) {
                conn.setRequestMethod("GET");
            } else {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params != null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String, String> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String mobileQuery(String phone) {
//        String result = null;
//        String url = codeYml.getUrl();//请求接口地址
//        Map params = new HashMap();//请求参数
        int random = (int) ((Math.random() * 9 + 1) * 100000);
//        params.put("mobile", phone);//接受短信的用户手机号码
//        params.put("tpl_id", codeYml.getTplId());//您申请的短信模板ID，根据实际情况修改
//        params.put("tpl_value", "#code#="+random);//您设置的模板变量，根据实际情况修改
//        params.put("key", codeYml.getKey());//应用APPKEY(应用详细页查询)
//        try {
//            result = net(url, params, "GET");
//            JSONObject object = JSONObject.fromObject(result);
//            if (object.getInt("error_code") == 0) {
//                System.out.println(object.get("result"));
//            } else {
//                System.out.println(object.get("error_code") + ":" + object.get("reason"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return random + "";
    }

    public Address getAddressByUserId(Integer userId) {
        List<Address> list = mapper.getAddressByUserId(userId);
        System.out.println(list);
        if (list.isEmpty()) return null;
        Address address = list.get(list.size() - 1);
        System.out.println("数量：" + list.size());
        return address;
    }

    public User getDisabledStatusByUserId(Integer userId) {
        return mapper.getDisabledStatusByUserId(userId);
    }

    public void updateAvatar(Integer userId, String avatar) {
        mapper.updateAvatar(userId, avatar);
    }

    public void updateUser(User user) {
        mapper.updateUser(user);
    }
}
