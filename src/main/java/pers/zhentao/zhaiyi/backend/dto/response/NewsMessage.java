package pers.zhentao.zhaiyi.backend.dto.response;

import pers.zhentao.zhaiyi.backend.dto.response.model.Article;

import java.util.List;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class NewsMessage extends BaseMessage {
    /**
     * 消息个数限制为10条以内
     */
    private int ArticleCount;

    /**
     * 默认第一个item为大图
     */
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        this.ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        this.Articles = articles;
    }
}
