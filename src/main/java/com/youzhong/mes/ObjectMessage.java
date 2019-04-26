package com.youzhong.mes;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

public class ObjectMessage implements MessageCreator {

    private Object object;

    public ObjectMessage(Object object) {
        this.object = object;
    }

    public Object getObject() {

        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createObjectMessage((Serializable) object);
    }
}
