package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto;

import java.util.Date;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public class Poll {
    private int pollId;
    private int competitorId;
    private String openId;
    private Date createdDate;

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public int getCompetitorId() {
        return competitorId;
    }

    public void setCompetitorId(int competitorId) {
        this.competitorId = competitorId;
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
