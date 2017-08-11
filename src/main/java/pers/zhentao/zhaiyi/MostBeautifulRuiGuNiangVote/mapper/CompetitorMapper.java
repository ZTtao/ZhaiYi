package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper;

import org.apache.ibatis.annotations.Param;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Competitor;

import java.util.List;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public interface CompetitorMapper {
    List<Competitor> select(@Param(value = "dto") Competitor dto);

    int updateIsPass(@Param(value = "id") int id, @Param(value = "number") int number);

    int updateNotPass(@Param(value = "id") int id);

    int insert(@Param(value = "dto") Competitor dto);

    int selectMaxNumber();

    List<Competitor> selectRank();
}
