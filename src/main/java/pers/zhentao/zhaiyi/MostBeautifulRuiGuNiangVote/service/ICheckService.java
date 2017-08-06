package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service;

import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Competitor;

import java.util.Map;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public interface ICheckService {
    Boolean checkAccount(String account,String password);
    Map<String,Object> getCompetitors(Competitor dto, int pageSize, int pageNum);
    Boolean changeState(int competitorId);
}
