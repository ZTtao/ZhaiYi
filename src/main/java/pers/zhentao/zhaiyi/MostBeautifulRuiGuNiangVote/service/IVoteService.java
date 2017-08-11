package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service;

import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.AccessInfo;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Competitor;

import java.util.Map;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public interface IVoteService {
    Boolean apply(Competitor dto);
    Map<String,Object> getCompetitors(Competitor dto, int pageSize, int pageNum);
    Map<String,Object> getRank(int pageSize, int pageNum);
    int getTotalPoll();
    int getTotalAccess();
    int getTotalJoin();
    Boolean hasAccess(String sessionId);
    Boolean addAccessRecord(AccessInfo dto);
    Competitor getCompetitorById(int id);
    Boolean isAllowedPoll(String openId,String day);
    Boolean addPoll(String openId,int competitorId);
}
