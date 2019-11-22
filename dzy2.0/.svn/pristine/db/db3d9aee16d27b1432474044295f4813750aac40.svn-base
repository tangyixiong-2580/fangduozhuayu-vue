package cn.dzy.manage.boss.manage.controller;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.service.OrderService;
import cn.dzy.manage.boss.manage.service.TokenService;
import cn.dzy.manage.boss.manage.utils.ReadJsonFile;
import cn.dzy.manage.boss.manage.utils.TokenUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dzy/order")
public class OrderController {

    @Resource
    OrderService service;

    @Resource
    TokenService tokenService;

    ReadJsonFile file;

    // 根据用户Id获取所有订单
    @GetMapping
    public BizResponse queryAllOrderByUserId(@RequestHeader ("token") String token) {
        Integer userId = TokenUtil.getUserId(token);
        return service.queryAll(userId);
    }

    // 生成订单
        @PostMapping
        public BizResponse addOrderByUserId(@RequestBody String o,@RequestHeader ("token") String token) {
            System.out.println("订单信息" + o);
            Integer userId = TokenUtil.getUserId(token);
            return service.add(o,userId);
    }

    // 根据订单Id获取订单详情
    @GetMapping("/orderInfo")
    public BizResponse getOrderByOrderId(@RequestParam("orderId") String orderId){
        System.out.println("orderId = " + orderId);
        return service.get(orderId);
    }

    // 取消订单
    @PatchMapping("/cancel")
    public BizResponse cancelOrderByOrderId(@RequestParam String orderId){
        BizResponse bizResponse = service.cancelOrder(orderId);
        return bizResponse;
    }

    // 区号
    @GetMapping("/area")
    public BizResponse getArea(){
        String path = "src/main/resources/area.json";
        String s = file.readJsonFile(path);
        JSONObject jsonObject = JSONObject.fromObject(s);
        System.out.println("jsonObject = " + jsonObject);
        return  BizResponse.of(0,jsonObject);
    }
}