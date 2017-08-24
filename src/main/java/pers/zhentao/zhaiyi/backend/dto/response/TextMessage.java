package pers.zhentao.zhaiyi.backend.dto.response;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class TextMessage extends BaseMessage {
    /**
     * 文本内容不得超过2048字节，否则服务器不予响应
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }
}
