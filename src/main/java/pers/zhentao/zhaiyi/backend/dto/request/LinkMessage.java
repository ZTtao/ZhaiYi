package pers.zhentao.zhaiyi.backend.dto.request;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class LinkMessage extends BaseMessage {
    private String title;
    private String description;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
