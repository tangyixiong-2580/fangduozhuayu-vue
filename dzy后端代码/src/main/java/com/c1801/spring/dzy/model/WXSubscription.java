package com.c1801.spring.dzy.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("wx.subscription")
public class WXSubscription {
    private String appid;
    private String appsecret;
    private String domain;
    private String mchid;
}
