package com.youzhong.controller;

import com.youzhong.util.SignUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequestMapping("wenxin")
@RestController
public class wenxinController {
    @RequestMapping("verify")//校验
    public void verify(String signature,String timestamp,//
                         String nonce,String echostr,HttpServletResponse response){//接收参数与微信校验
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
}
