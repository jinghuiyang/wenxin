package com.youzhong.controller;

import com.youzhong.service.UserService;
import com.youzhong.util.HttpUtil;
import net.sf.json.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/test")

    public String test(String code, Model model) {//重定向到这个方法
        System.out.println(code);
        String mes = HttpUtil.post("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx3062a29394cca3bd&secret=21c57543d22b176cede3babd5567011f&code="+code+"&grant_type=authorization_code", null);
         //根据code获取token和openid
        JSONObject jsonObject = JSONObject.fromObject(mes);
        String access_token = jsonObject.get("access_token").toString();
        System.out.println(access_token);
        String openid = jsonObject.get("openid").toString();
        System.out.println(openid);
        //根据token和openid得到用户信息
        String user = HttpUtil.post("https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid + "&lang=zh_CN", null);
        //得到的用户信息
        JSONObject userObject = JSONObject.fromObject(user);
        model.addAttribute("openid",userObject.get("openid").toString());
        model.addAttribute("nickname",userObject.get("nickname").toString());

        return "user";
    }
    @ResponseBody
    @RequestMapping("/test1")
    public String test1() {
        return "user1";
    }

    @RequestMapping("login")
    public void login(String tel,String password, String openid){
        System.out.println(tel);
        System.out.println(password);
        System.out.println(openid);
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/userWebService?wsdl");
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("bindUser", tel,password,openid);
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
