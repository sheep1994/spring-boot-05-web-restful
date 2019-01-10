package com.talent.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author guobing
 * @Title: MyFilter
 * @ProjectName spring-boot-02-config
 * @Description: 自定义Filter
 * @date 2019/1/9上午10:39
 */
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        // 放行
        filterChain.doFilter(request, response);
    }
}
