package cn.dzy.manage.boss.manage.log;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Filterconfig {

    @Bean
    public FilterRegistrationBean registFilter() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        //注入过滤器
        registration.setFilter(new Filters());

        //拦截规则
        registration.addUrlPatterns("/*");

        //过滤器名称
        registration.setName("Filters");

        //过滤器顺序
        registration.setOrder(1);
        return registration;
    }

}