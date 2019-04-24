package com.youzhong.message.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 文本消息
 *
 * @author liufeng
 * @date 2013-05-19
 */
public class NewsMessage extends BaseMessage  implements Serializable{
    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<Article> Articles;

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }
}
