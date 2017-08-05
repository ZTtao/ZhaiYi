package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZhangZhentao
 *         2017-08-05
 */
@Controller
@RequestMapping(value = "/mbrgnv")
public class VoteMainController {

    @RequestMapping(value = "")
    public String homepage(HttpServletRequest request){
        return "/mbrgnv/homepage.jsp";
    }

    @RequestMapping(value = "/explain")
    public String explain(HttpServletRequest request){
        return "/mbrgnv/explain.jsp";
    }

    @RequestMapping(value = "/rank")
    public String rank(HttpServletRequest request){
        return "/mbrgnv/rank-list.jsp";
    }

    @RequestMapping(value = "/apply")
    public String apply(HttpServletRequest request){
        return "/mbrgnv/apply.jsp";
    }

    @RequestMapping(value = "/info")
    public String info(HttpServletRequest request){
        return "/mbrgnv/info-page.jsp";
    }
}
