package cn.dzy.manage.boss.manage.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class Filters implements Filter {
    public void init(Filterconfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        MDC.put("请求IP", String.valueOf(servletRequest.getLocalAddr()));

        log.warn("访问的ip = " + servletRequest.getLocalAddr());

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }


}