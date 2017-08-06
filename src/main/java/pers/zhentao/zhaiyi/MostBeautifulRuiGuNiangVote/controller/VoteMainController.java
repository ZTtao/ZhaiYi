package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.Competitor;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.IVoteService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

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
    public String info(HttpServletRequest request) {
        return "/mbrgnv/info-page.jsp";
    }

    @RequestMapping(value = "/submit")
    public String submitData(Model model, @RequestParam(value = "file", required = false) MultipartFile file, String name, String phone, String declaration, HttpServletRequest request) {
        //校验微信号是否已报名

        //
        int number = 0;
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
}
