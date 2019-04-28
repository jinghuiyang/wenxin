package com.youzhong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 接收二维码图片的地址
 */
@RequestMapping("png")
public class pngController {

    @RequestMapping("png")

    public String png(String uuid, String code, HttpServletRequest request) {//接收二维码图片的方法
        request.setAttribute("uuid", uuid);
        request.setAttribute("code", code);
        System.out.println(uuid);
        System.out.println(code);
        return "affirm";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(String uuid, String code) {//接收二维码图片的方法
        System.out.println(uuid);
        System.out.println(code);
        return "affirm";
    }

}
