package com.cas.client2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: lj
 * @date: 2019/07/19
 */
@Controller
public class LogoutController {

    @RequestMapping("/logoutDefault")
    public String logout1(HttpSession session) {
        session.invalidate();
        // 直接退出，走默认退出方式
        return "redirect:http://101.132.45.82:8080/cas/logout";
    }

    @RequestMapping("/logoutCustom")
    public String logout2(HttpSession session) {
        session.invalidate();
        // 退出登录后，跳转到退出成功的页面，不走默认页面
        return "redirect:http://101.132.45.82:8080/cas/logout?service=http://101.132.45.82:9300/logout/success";
    }

    @RequestMapping("/logout/success")
    public String logout2() {
        return "success";
    }
}
