package pers.zhentao.zhaiyi.backend.dto.response;

import pers.zhentao.zhaiyi.backend.dto.response.model.Voice;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class VoiceMessage extends BaseMessage {
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        this.Voice = voice;
    }
}
