package pers.zhentao.zhaiyi.TheFirstHalfTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZhangZhentao
 *         2017-08-04
 */
@Controller
@RequestMapping(value = "/tfht")
public class MainController {

    @RequestMapping(value = "")
    public String mainpage(HttpServletRequest request){
        return "tfht/the-first-half-test.html";
    }

}
