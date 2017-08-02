package pers.zhentao.zhaiyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.zhentao.zhaiyi.dto.Test;
import pers.zhentao.zhaiyi.service.ITestService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by 张镇涛 on 2017/8/2.
 */
@Controller
public class TestController {

    @Autowired
    private ITestService testService;

    @RequestMapping(value="/queryByPrimaryKey")
    public String queryByPrimaryKey(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Test dto = testService.getByPrimaryKey(id);
        model.addAttribute("dto",dto);
        return "showTest";
    }
}
