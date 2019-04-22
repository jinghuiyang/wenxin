package com.youzhong.controller;

import com.youzhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
     @ResponseBody
    public String test(Model model) {
        List list = userService.list();
        model.addAttribute("list", list);
        return "user";
    }

    @RequestMapping("/test1")
    public String test1() {
        return "user1";
    }
}
