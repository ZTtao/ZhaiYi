package pers.zhentao.zhaiyi.backend.dto.request;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-03
 */
public class LocationMessage extends BaseMessage {
    private String locationX;
    private String locationY;
    private String scale;
    private String label;

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
