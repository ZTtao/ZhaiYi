package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto;

import java.util.Date;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public class AccessInfo {
    private Long accessId;
    private String openId;
    private Date createdDate;
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getAccessId() {
        return accessId;
    }

    public void setAccessId(Long accessId) {
        this.accessId = accessId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
