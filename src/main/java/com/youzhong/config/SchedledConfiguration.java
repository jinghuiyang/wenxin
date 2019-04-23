package com.youzhong.config;

import com.youzhong.entity.AccessToken;
import com.youzhong.service.AccessTokenService;
import com.youzhong.util.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时器的配置类
 */
@Component
@EnableScheduling
public class SchedledConfiguration {
    @Autowired
    private AccessTokenService accessTokenService;

    // 第三方用户唯一凭证
    private static final String APPID = "wx3062a29394cca3bd";

    // 第三方用户唯一凭证密钥
    private static final String APPSECRET = "21c57543d22b176cede3babd5567011f";

    @Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime() {
        System.out.println("Scheduling Tasks Examples: The time is now " + dateFormat().format(new Date()));
    }

    //每2个小时分钟执行一次
    @Scheduled(cron = "0 0 */2  * * ? ")
    public AccessToken reportCurrentByCron() {
        //System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date ()));
        //从数据库获取以前的accessToken
        AccessToken token = WeixinUtil.getAccessToken(APPID, APPSECRET);
        AccessToken accessToken = accessTokenService.getToken();
        if(accessToken!=null){//先判断数据库数据是否存在
            //再从微信那边获取值看是否数据还一致吗

            if (accessToken.getToken().equals(token.getToken())) {
                return accessToken;
            } else {
                accessTokenService.update(token);
                return token;
            }
        }else{
            accessTokenService.insert(token);
            return  token;
        }


    }

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }
}
