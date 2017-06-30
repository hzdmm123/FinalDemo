package com.finaldemo.controller;

import javax.servlet.http.HttpServletRequest;

import com.finaldemo.model.User;
import com.finaldemo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.InvocableHandlerMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
/*@RequestMapping("/user")*/
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    @RequestMapping("/login")
    @ResponseBody
    public String loginCheck(@RequestParam(value = "userName", required = false) String userName,
                             @RequestParam(value = "password", required = false) String password) {
        if (userService.CheckLogin(userName, password) > 0) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public List<User> showUser() {
        List<User> list = userService.showUser();
        return list;
    }


}