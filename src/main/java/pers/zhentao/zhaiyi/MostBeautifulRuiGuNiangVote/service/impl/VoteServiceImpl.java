package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.AccessInfo;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Competitor;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Poll;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper.AccessInfoMapper;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper.CompetitorMapper;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper.PollMapper;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.IVoteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
@Service(value = "VoteServiceImpl")
public class VoteServiceImpl implements IVoteService {
    @Autowired
    private CompetitorMapper competitorMapper;
    @Autowired
    private PollMapper pollMapper;
    @Autowired
    private AccessInfoMapper accessInfoMapper;

    @Override
    public Boolean apply(Competitor dto) {
        int count = competitorMapper.insert(dto);
        if (count > 0) return true;
        return false;
    }

    @Override
    public Map<String, Object> getCompetitors(Competitor dto, int pageSize, int pageNum) {
        Page<Competitor> p = PageHelper.startPage(pageNum, pageSize);
        List<Competitor> list = competitorMapper.select(dto);
        Long total = p.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public Map<String, Object> getRank(int pageSize, int pageNum) {
        Page<Competitor> p = PageHelper.startPage(pageNum, pageSize);
        List<Competitor> list = competitorMapper.selectRank();
        Long total = p.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public int getTotalPoll() {
        return pollMapper.selectTotal();
    }

    @Override
    public int getTotalAccess() {
        return accessInfoMapper.selectTotal();
    }

    @Override
    public int getTotalJoin() {
        Competitor competitor = new Competitor();
        competitor.setIsPass(true);
        return competitorMapper.select(competitor).size();
    }

    @Override
    public Boolean hasAccess(String sessionId) {
        int count = accessInfoMapper.countBySessionId(sessionId);
        if (count > 0) return true;
        return false;
    }

    @Override
    public Boolean addAccessRecord(AccessInfo dto) {
        int count = accessInfoMapper.insert(dto);
        if (count > 0) return true;
        return false;
    }

    @Override
    public Competitor getCompetitorById(int id) {
        Competitor competitor = new Competitor();
        competitor.setCompetitorId(id);
        int pollCount = pollMapper.countByCompetitorId(id);
        List<Competitor> list = competitorMapper.select(competitor);
        if (list != null && list.size() > 0) {
            list.get(0).setPollCount(pollCount);
            return list.get(0);
        }
        return null;
    }

    @Override
    public Boolean isAllowedPoll(String openId, String day) {
        int count = pollMapper.countAfterDay(openId, day);
        if (count >= 3) return false;
        return true;
    }

    @Override
    public Boolean addPoll(String openId, int competitorId) {
        Poll poll = new Poll();
        poll.setCompetitorId(competitorId);
        poll.setOpenId(openId);
        int count = pollMapper.insert(poll);
        if(count > 0)return true;
        return false;
    }
}
