package com.youzhong.mes;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 消息实时推送类
 */
public class TextMessage implements MessageCreator{
   //消息内容
    private String msg;

    public TextMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(msg);
    }
}
