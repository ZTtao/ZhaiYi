package pers.zhentao.zhaiyi.backend.dto.event;

/**
 * @author ZhangZhentao
 *         2017-08-24
 */
public class ViewEvent extends BaseEvent{
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
