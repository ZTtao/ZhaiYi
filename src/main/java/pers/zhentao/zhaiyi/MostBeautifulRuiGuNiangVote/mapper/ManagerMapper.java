package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.mapper;

import org.apache.ibatis.annotations.Param;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Manager;

import java.util.List;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public interface ManagerMapper {
    List<Manager> selectByAccountPassword(@Param(value = "account")String account,@Param(value = "password")String password);
}
