package pers.zhentao.zhaiyi.backend.dto.event;

/**
 * @author ZhangZhentao
 *         2017-08-03
 */
public class QRCodeEvent extends BaseEvent {
    private String eventKey;
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
