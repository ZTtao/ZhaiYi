package pers.zhentao.zhaiyi.backend.dto.response.model;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class Music {
    private String Title;
    private String Description;
    private String MusicUrl;
    private String HQMusicUrl;
    private String ThumbMediaId;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getMusicUrl() {
        return MusicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.MusicUrl = musicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.ThumbMediaId = thumbMediaId;
    }
}
