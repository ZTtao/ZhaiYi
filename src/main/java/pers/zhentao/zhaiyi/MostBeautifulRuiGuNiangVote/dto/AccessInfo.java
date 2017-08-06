package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto;

import java.util.Date;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public class AccessInfo {
    private Long access_id;
    private String openId;
    private Date createdDate;

    public Long getAccess_id() {
        return access_id;
    }

    public void setAccess_id(Long access_id) {
        this.access_id = access_id;
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
