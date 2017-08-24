package pers.zhentao.zhaiyi.backend.dto.request;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class VoiceMessage extends BaseMessage {
    private String mediaId;
    private String format;
    private String recognition;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}
