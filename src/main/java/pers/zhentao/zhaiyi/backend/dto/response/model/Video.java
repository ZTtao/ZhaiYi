package pers.zhentao.zhaiyi.backend.dto.response.model;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class Video {
    private String MediaId;
    private String ThumbMediaId;
    private String Title;
    private String Description;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.ThumbMediaId = thumbMediaId;
    }
}
