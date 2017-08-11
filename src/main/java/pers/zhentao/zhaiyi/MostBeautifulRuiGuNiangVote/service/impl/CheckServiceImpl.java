package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Competitor;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Manager;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper.CompetitorMapper;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper.ManagerMapper;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.ICheckService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
@Service(value = "CheckServiceImpl")
public class CheckServiceImpl implements ICheckService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private CompetitorMapper competitorMapper;

    @Override
    public Boolean checkAccount(String account, String password) {
        List<Manager> list = managerMapper.selectByAccountPassword(account, password);
        if (list.size() > 0) return true;
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
    public Boolean setIsPass(int competitorId) {
        int number = competitorMapper.selectMaxNumber();
        int count = competitorMapper.updateIsPass(competitorId, number + 1);
        if (count > 0) return true;
        return false;
    }

    @Override
    public Boolean setNotPass(int competitorId) {
        int count = competitorMapper.updateNotPass(competitorId);
        if (count > 0) return true;
        return false;
    }
}
