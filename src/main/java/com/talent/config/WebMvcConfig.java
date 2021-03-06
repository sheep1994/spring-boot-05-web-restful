package com.talent.config;

import com.talent.interceptor.LoginHandlerInterceptor;
import com.talent.resolver.MyLocaleResolver;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author guobing
 * @Title: WebMvcConfig
 * @ProjectName spring-boot-02-config
 * @Description: TODO
 * @date 2018/12/28下午3:32
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**
         * addViewController == RequestMapping
         * setViewName == return "index"
         */
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/talent").setViewName("404");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 添加区域解析器bean，bean的名称必须为localeResolver
     * @return
     */
    @Bean
    public MyLocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login");
    }
}
