package com.gavin.sanyuandb.controller;

import com.gavin.sanyuandb.model.Users;
import com.gavin.sanyuandb.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/9/6 0006
 * Time: 0:07
 */
@Controller
public class UserController {

    @Resource
    UsersService usersService;

    @RequestMapping(value = "/hello")
    public String signin() {
        return "sign_in";
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(@RequestParam("account") String account,
                        @RequestParam("pwd") String pwd,
                        ModelMap modelMap, HttpServletRequest request) {
        Users user = new Users(account, pwd);
        int result = usersService.login(user);
        if (result == UsersService.LOGIN_RESULT.SUCCESS.getKey()) {
            // Session会话传值
            try {
                HttpSession session = request.getSession() ;
                session.setAttribute( "account", user.getName() ) ;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return "{\"result\":\""+result+"\"}";
    }
}
