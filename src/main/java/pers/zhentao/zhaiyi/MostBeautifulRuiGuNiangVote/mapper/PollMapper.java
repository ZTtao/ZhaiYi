package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper;

import org.apache.ibatis.annotations.Param;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Poll;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public interface PollMapper {
    int selectTotal();
    int countByCompetitorId(@Param(value = "competitorId")int competitorId);
    int countAfterDay(@Param(value = "openId")String openId,@Param(value = "day")String day);
    int insert(@Param(value = "dto") Poll dto);
}
