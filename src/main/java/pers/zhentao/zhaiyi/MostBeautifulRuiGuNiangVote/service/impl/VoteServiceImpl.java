package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Competitor;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper.CompetitorMapper;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.IVoteService;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
@Service(value = "VoteServiceImpl")
public class VoteServiceImpl implements IVoteService{
    @Autowired
    private CompetitorMapper competitorMapper;

    @Override
    public Boolean apply(Competitor dto) {
        int count = competitorMapper.insert(dto);
        if(count > 0)return true;
        return false;
    }
}
