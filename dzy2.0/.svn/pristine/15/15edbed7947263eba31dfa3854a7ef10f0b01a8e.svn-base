package cn.dzy.manage.boss.manage.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BizResponse {

    private Integer code;

    private String msg;

    private Object data;

    private  Pager pager;

    private final static Map<Integer,String> CODE_DESC = new HashMap<>();
    {
        CODE_DESC.put(0, "成功");
        CODE_DESC.put(201, "ISBN为空");
        CODE_DESC.put(202, "ISBN不正确");
        CODE_DESC.put(203, "该书籍以在书架");
        CODE_DESC.put(204, "没有登录");
        CODE_DESC.put(205, "没有信息");
        CODE_DESC.put(206, "失败");
        CODE_DESC.put(207, "没有koken");
        CODE_DESC.put(208, "登录超时");
        CODE_DESC.put(209, "该账号已被封禁");
        CODE_DESC.put(220, "该手机号以有用户");
        CODE_DESC.put(230, "新用户");
        CODE_DESC.put(240, "没有授权");
        CODE_DESC.put(250, "验证码不对");
        CODE_DESC.put(301, "购物车为空");
    }

    public static BizResponse of(Integer code,String msg,Object data){
        BizResponse bizResponse = new BizResponse();
        bizResponse.code = code;
        bizResponse.msg = msg;
        bizResponse.data = data;
        return bizResponse;
    }
    public static BizResponse of(Integer code,Object data) {
        BizResponse bizResponse = new BizResponse();
        bizResponse.code = code;
        bizResponse.msg = CODE_DESC.get(code);
        bizResponse.data = data;
        return bizResponse;
    }
    public static BizResponse of(Integer code,Object data,Pager pager) {
        BizResponse bizResponse = new BizResponse();
        bizResponse.code = code;
        bizResponse.msg = CODE_DESC.get(code);
        bizResponse.data = data;
        bizResponse.pager = pager;
        return bizResponse;
    }

}
