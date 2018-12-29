package com.talent.resolver;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author guobing
 * @Title: MyLocaleResolver
 * @ProjectName spring-boot-02-config
 * @Description: 可以通过发送get请求，携带参数实现区域解析器
 * @date 2018/12/29上午10:31
 */
public class MyLocaleResolver implements LocaleResolver {

    /**
     * 解析区域信息
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("language");
        // 使用默认的区域解析器
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
