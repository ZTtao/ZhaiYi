package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Competitor;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Manager;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.ICheckService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
@Controller
@RequestMapping(value = "/mbrgnvcheck")
public class CheckController {

    @Autowired
    @Qualifier("CheckServiceImpl")
    private ICheckService checkService;

    @RequestMapping(value = "")
    public String checkPage(HttpServletRequest request,String account,String password) {
        if (account == null || password == null) {
            return "/mbrgnv/login.html";
        } else if (!checkService.checkAccount(account, password)) {
            return "/mbrgnv/login.html";
        }
        return "/mbrgnv/manager-page.jsp";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, String> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();
        String account = (String) request.getParameter("account");
        String password = (String) request.getParameter("password");
        if (checkService.checkAccount(account, password)) {
            map.put("success", "true");
        } else {
            map.put("success", "false");
        }
        return map;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public Map<String, Object> query(HttpServletRequest request, String number, String phone, String name, String declaration, String check, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "1") int pageNum) {
        Competitor competitor = new Competitor();
        if (number != null && !number.equals(""))
            competitor.setNumber(Integer.parseInt(number));
        competitor.setPhone(phone);
        competitor.setName(name);
        competitor.setDeclaration(declaration);
        if (check.equals("true")) {
            competitor.setIsPass(true);
        } else if (check.equals("false")) {
            competitor.setIsPass(false);
        }
        return checkService.getCompetitors(competitor, pageSize, pageNum);
    }

    @RequestMapping(value = "/changeState")
    @ResponseBody
    public Map<String, Object> changeState(HttpServletRequest request, int competitorId,Boolean isPass) {
        Map<String, Object> map = new HashMap<>();
        if(isPass){
            if(checkService.setIsPass(competitorId)){
                map.put("success", "true");
            }else{
                map.put("success", "false");
            }
        }else{
            if(checkService.setNotPass(competitorId)){
                map.put("success", "true");
            }else{
                map.put("success", "false");
            }
        }
        return map;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("account");
        request.getSession().removeAttribute("password");
        return "/mbrgnv/login.html";
    }
}
