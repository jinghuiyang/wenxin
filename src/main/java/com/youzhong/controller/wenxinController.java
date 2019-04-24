package com.youzhong.controller;

import com.youzhong.service.CoreService;
import com.youzhong.util.SignUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@RequestMapping("wenxin")
@RestController
public class wenxinController {
    //get请求
    @RequestMapping(value = "verify", method = RequestMethod.GET)//校验
    public void verify(String signature, String timestamp,//
                       String nonce, String echostr, HttpServletResponse response) {//接收参数与微信校验
        try {
            PrintWriter out = response.getWriter();
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
            out.close();
            out = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostMapping("verify")
    public void verifyPost(HttpServletRequest request, HttpServletResponse response) {//接收参数与微信校验

        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
      try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");


        // 调用核心业务类接收消息、处理消息
        String respMessage = CoreService.processRequest(request);

        // 响应消息
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print(respMessage);
        out.close();

    }
}
