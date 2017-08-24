package pers.zhentao.zhaiyi.backend.dto.response;

import pers.zhentao.zhaiyi.backend.dto.response.model.Image;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class ImageMessage extends BaseMessage {
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        this.Image = image;
    }
}
