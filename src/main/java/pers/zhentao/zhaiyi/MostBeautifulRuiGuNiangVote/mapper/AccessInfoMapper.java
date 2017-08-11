package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper;

import org.apache.ibatis.annotations.Param;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.AccessInfo;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public interface AccessInfoMapper {
    int selectTotal();
    int countBySessionId(@Param(value = "sessionId") String sessionId);
    int insert(@Param(value = "dto") AccessInfo dto);
}
