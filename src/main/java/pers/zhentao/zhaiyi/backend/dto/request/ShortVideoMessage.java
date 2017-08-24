package pers.zhentao.zhaiyi.backend.dto.request;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-24
 */
public class ShortVideoMessage extends BaseMessage{
    private String mediaId;
    private String thumbMediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
