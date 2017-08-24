package pers.zhentao.zhaiyi.backend.dto.response;

import pers.zhentao.zhaiyi.backend.dto.response.model.Music;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class MusicMessage extends BaseMessage {
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        this.Music = music;
    }
}
