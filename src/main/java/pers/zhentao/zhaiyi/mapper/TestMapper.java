package pers.zhentao.zhaiyi.mapper;

import org.apache.ibatis.annotations.Param;
import pers.zhentao.zhaiyi.dto.Test;

import java.util.List;

/**
 * Created by 张镇涛 on 2017/8/2.
 */
public interface TestMapper {
    Test selectByPrimaryKey(@Param(value = "id") int id);
}
