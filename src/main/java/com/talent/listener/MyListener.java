package com.talent.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author guobing
 * @Title: MyListener
 * @ProjectName spring-boot-02-config
 * @Description: 自定义listener
 * @date 2019/1/9上午11:10
 */
public class MyListener implements ServletContextListener {

    /**
     * web启动时触发
     * @param event
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("web容器启动....");
    }

    /**
     * web销毁时触发
     * @param event
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        String contextPath = event.getServletContext().getContextPath();
        System.out.println("web容器销毁...." + contextPath);
    }
}
