package com.youzhong.message.req;
/**
 * 文本消息
 *
 * @author liufeng
 * @date 2013-05-19
 */
public class TextMessage  extends BaseMessage {
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
