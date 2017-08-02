package pers.zhentao.zhaiyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zhentao.zhaiyi.dto.Test;
import pers.zhentao.zhaiyi.mapper.TestMapper;
import pers.zhentao.zhaiyi.service.ITestService;

import java.util.List;

/**
 * Created by 张镇涛 on 2017/8/2.
 */
@Service
public class TestServiceImpl implements ITestService{

    @Autowired
    private TestMapper testMapper;

    @Override
    public Test getByPrimaryKey(int id) {
        return testMapper.selectByPrimaryKey(id);
    }
}
