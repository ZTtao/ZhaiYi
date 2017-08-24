package pers.zhentao.zhaiyi.backend.dto.response;

import pers.zhentao.zhaiyi.backend.dto.response.model.Video;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class VideoMessage extends BaseMessage {
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        this.Video = video;
    }
}
