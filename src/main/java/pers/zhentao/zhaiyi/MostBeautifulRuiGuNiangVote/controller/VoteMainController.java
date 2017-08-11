package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.AccessInfo;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Competitor;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.WeixinOauth2Token;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.IVoteService;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.util.OauthUtil;
import sun.util.resources.cldr.aa.CalendarData_aa_DJ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangZhentao
 *         2017-08-05
 */
@Controller
@RequestMapping(value = "/mbrgnv")
public class VoteMainController {

    @Autowired
    @Qualifier("VoteServiceImpl")
    private IVoteService voteService;

    @RequestMapping(value = "")
    public String homepage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (!voteService.hasAccess(session.getId())) {
            AccessInfo accessInfo = new AccessInfo();
            accessInfo.setSessionId(session.getId());
            voteService.addAccessRecord(accessInfo);
        }
        return "/mbrgnv/homepage.jsp";
    }

    @RequestMapping(value = "/explain")
    public String explain(HttpServletRequest request) {
        return "/mbrgnv/explain.jsp";
    }

    @RequestMapping(value = "/rank")
    public String rank(HttpServletRequest request) {
        return "/mbrgnv/rank-list.jsp";
    }

    @RequestMapping(value = "/apply")
    public String apply(HttpServletRequest request) {
        return "/mbrgnv/apply.jsp";
    }

    @RequestMapping(value = "/info")
    public String info(HttpServletRequest request, Model model) {
        String id = (String) request.getParameter("id");
        Competitor competitor = voteService.getCompetitorById(Integer.parseInt(id));
        model.addAttribute("competitor", competitor);
        return "/mbrgnv/info-page.jsp";
    }

    @RequestMapping(value = "/picture")
    public String picture(HttpServletRequest request, Model model) {
        String url = request.getParameter("pictureUrl");
        model.addAttribute("pictureUrl", url);
        return "/mbrgnv/show-picture.jsp";
    }

    @RequestMapping(value = "/submit")
    public String submitData(Model model, @RequestParam(value = "file", required = false) MultipartFile file, String name, String phone, String declaration, HttpServletRequest request) {
        //校验微信号是否已报名

        Competitor competitor = new Competitor();
        competitor.setName(name);
        competitor.setPhone(phone);
        competitor.setWechatId("test");
        competitor.setOpenId("test1");
        competitor.setDeclaration(declaration);
        competitor.setNumber(0);
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = competitor.getOpenId() + "-" + new Date().getTime() + ".jpg";
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fileUrl = request.getContextPath() + "/upload/" + fileName;
        competitor.setPictureUrl(fileUrl);
        if (voteService.apply(competitor)) {
            model.addAttribute("apply", "success");
        } else {
            model.addAttribute("apply", "error");
            model.addAttribute("result", "未知错误，请重试");
        }
        return "/mbrgnv/apply.jsp";
    }

    @RequestMapping(value = "/auth")
    public String auth(HttpServletRequest request, Model model) {
        String code = request.getParameter("code");
        String appId = "wxa4acc514572f1238";
        String appSecret = "5eca522851575a5dcf4aa0127023ef1a";
        if (!"authdeny".equals(code)) {
            WeixinOauth2Token weixinOauth2Token = OauthUtil.getOauth2AccessToken(appId, appSecret, code);
            String accessToken = weixinOauth2Token.getAccessToken();
            String openId = weixinOauth2Token.getOpenId();
            model.addAttribute("openId", openId + "-m");
            model.addAttribute("accessToken", accessToken + "-m");
            request.setAttribute("openId", openId);
            request.setAttribute("accessToken", accessToken);
        }
        return "/mbrgnv/test-auth.jsp";
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public Map<String, Object> query(HttpServletRequest request, String name, String number, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "1") int pageNum) {
        Competitor competitor = new Competitor();
        if (number != null && !number.equals(""))
            competitor.setNumber(Integer.parseInt(number));
        competitor.setName(name);
        competitor.setIsPass(true);
        Map<String, Object> map = voteService.getCompetitors(competitor, pageSize, pageNum);
        map.put("joinCount", voteService.getTotalJoin());
        map.put("totalPoll", voteService.getTotalPoll());
        map.put("totalAccess", voteService.getTotalAccess());
        return map;
    }

    @RequestMapping(value = "/poll")
    @ResponseBody
    public Map<String, Object> poll(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        int competitorId = Integer.parseInt(request.getParameter("competitorId"));
        String openId = request.getParameter("openId");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        date.setYear(117);
        date.setMonth(8);
        date.setDate(16);
        date.setHours(23);
        date.setMinutes(59);
        date.setSeconds(59);
        Date date1 = new Date();
        if (date1.after(date)) {
            map.put("success", "false");
            map.put("result", "4");
            return map;
        }
        String str = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + (calendar.get(Calendar.DATE) - 1);
        if (voteService.isAllowedPoll(openId, str)) {
            if (voteService.addPoll(openId, competitorId)) {
                map.put("success", "true");
                map.put("result", "1");
            } else {
                map.put("success", "false");
                map.put("result", "2");
            }
        } else {
            map.put("success", "false");
            map.put("result", "3");
        }
        return map;
    }

    @RequestMapping(value = "/queryRank")
    @ResponseBody
    public Map<String, Object> queryRank(HttpServletRequest request, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "1") int pageNum) {
        Map<String, Object> map = voteService.getRank(pageSize, pageNum);
        map.put("joinCount", voteService.getTotalJoin());
        map.put("totalPoll", voteService.getTotalPoll());
        map.put("totalAccess", voteService.getTotalAccess());
        return map;
    }
}
