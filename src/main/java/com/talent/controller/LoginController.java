package com.talent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author guobing
 * @Title: LoginController
 * @ProjectName spring-boot-02-config
 * @Description: TODO
 * @date 2018/12/29上午10:47
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {

        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {

            session.setAttribute("loginUser", username);
            // 登录成功，为了防止表单重复提交，可以使用重定向
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名密码错误");
            return "index";
        }
    }
}
