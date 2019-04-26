package com.youzhong.config;

import com.youzhong.entity.AccessToken;
import com.youzhong.mes.Mes;
import com.youzhong.mes.MesTemplate;
import com.youzhong.mes.Title;
import com.youzhong.util.WeixinUtil;
import net.sf.json.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MQReceiver {

    @JmsListener(destination = "object", containerFactory = "jmsListenerContainerTopic")
    public void receiveObjTopic(Mes mes) throws Exception {
        System.out.println("BTopicConsumer接收到对象主题消息...." + mes.toString());
        //封装传回去的数据
        MesTemplate mesTemplate = new MesTemplate();
        mesTemplate.setTouser(mes.getOpenid());
        mesTemplate.setTemplate_id("Nm0fToaOf1mR-zZLOrluuh-XBR-bpy2_c4UsDA5E6uo");
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Title title = new Title();//数量对象
        title.setColor("#173177");
        title.setValue(mes.getSum() + "");
        objectObjectHashMap.put("num", title);
        Title title1 = new Title();//花费对象
        title.setColor("#173177");
        title.setValue(mes.getPrice() + "");
        objectObjectHashMap.put("price", title1);
        //获取token值
        AccessToken accessToken = WeixinUtil.getAccessToken(WeixinUtil.APPID, WeixinUtil.APPSECRET);
       String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken.getToken();
       //将数据发送到微信端
        JSONObject post = WeixinUtil.httpRequest(url, "post", JSONObject.fromObject(mesTemplate).toString());
        System.out.println(post.toString());

    }

    @JmsListener(destination = "stringTopic", containerFactory = "jmsListenerContainerTopic")
    public void receiveStringTopic(String msg) {
        System.out.println("BTopicConsumer接收到消息...." + msg);
    }

}
