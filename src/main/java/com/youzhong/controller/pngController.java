package com.youzhong.controller;

import com.youzhong.util.HttpUtil;
import net.sf.json.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 接收二维码图片的地址
 */
@RequestMapping("png")
@Controller
public class pngController {

    @RequestMapping("png")
    @ResponseBody
    public String png(String uuid, String code, HttpServletRequest request) {//接收二维码图片的方法
        request.setAttribute("uuid", uuid);
        System.out.println("Ss");
        request.setAttribute("code", code);
        System.out.println(uuid);
        System.out.println(code);
        //根据token换取token
        String user = HttpUtil.post("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx3062a29394cca3bd&secret=21c57543d22b176cede3babd5567011f&code=" + code + "&grant_type=authorization_code", null);
        JSONObject jsonObject = JSONObject.fromObject(user);
        String access_token = jsonObject.get("access_token").toString();
        String openid = jsonObject.get("openid").toString();
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://wenxin.jinghuiyang.top/services/UserBindServiceImpl?wsdl");
        Object[] objects = new Object[0];

        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("login", uuid, openid);
            // Object[] tests = client.invoke("a", "1");

            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
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
