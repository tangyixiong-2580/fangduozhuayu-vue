package cn.dzy.manage.boss.manage.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:code.yml")//制定读取配置文件的路径
@ConfigurationProperties(prefix = "info.code")//指定读取的前缀
public class CodeYml {
    @Value("${url}")
    private String url;
    @Value("${tpl_id}")
    private String tplId;
    @Value("${key}")
    private String key;

}
