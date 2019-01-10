package com.talent.config;

import com.talent.filter.MyFilter;
import com.talent.listener.MyListener;
import com.talent.servlet.MyServlet;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author guobing
 * @Title: MyServerConfig
 * @ProjectName spring-boot-02-config
 * @Description: 注册服务器组件
 * @date 2019/1/9上午10:16
 */
@Configuration
public class MyServerConfig {

    /**
     * 配置嵌入式servlet容器，用来修改Servlet容器的配置
     * @return
     */
    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory() {
        // 嵌入式tomcat容器
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8083);
        return factory;
    }

    /**
     * 注册三大组件
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        // 使用ServletRegistrationBean的有参构造器
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        return new ServletListenerRegistrationBean(new MyListener());
    }
}
