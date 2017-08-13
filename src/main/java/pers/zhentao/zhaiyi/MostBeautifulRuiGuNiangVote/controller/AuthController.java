package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.AccessInfo;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.WeixinOauth2Token;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.service.IVoteService;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.util.AccessTokenUtil;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.util.CommonUtil;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.util.OauthUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangZhentao
 *         2017-08-12
 */
@Controller
@RequestMapping(value = "/mbrgna")
public class AuthController {
    private Logger logger = Logger.getLogger(AuthController.class);
    @Autowired
    @Qualifier("VoteServiceImpl")
    private IVoteService voteService;

    @RequestMapping(value = "")
    public String auth(HttpServletRequest request, Model model) {
        String code = request.getParameter("code");
        String appId = "wxa4acc514572f1238";
        String appSecret = "5eca522851575a5dcf4aa0127023ef1a";
        logger.info("["+new Date()+"]code:"+code);
        if (!"authdeny".equals(code)) {
            WeixinOauth2Token weixinOauth2Token = OauthUtil.getOauth2AccessToken(appId, appSecret, code);
            logger.info(weixinOauth2Token);
            String accessToken = weixinOauth2Token.getAccessToken();
            String openId = weixinOauth2Token.getOpenId();
            model.addAttribute("openId", openId);
            model.addAttribute("accessToken", accessToken);
            request.setAttribute("openId", openId);
            request.setAttribute("accessToken", accessToken);

            logger.info("["+new Date()+"]accessToken:"+accessToken);
            logger.info("["+new Date()+"]openId:"+openId);

            HttpSession session = request.getSession();
            if (!voteService.hasAccess(session.getId())) {
                AccessInfo accessInfo = new AccessInfo();
                accessInfo.setSessionId(session.getId());
                voteService.addAccessRecord(accessInfo);
            }
            return "/mbrgnv/homepage.jsp";
        }else {
            return "/mbrgnv/error-page.html";
        }
    }

    @RequestMapping(value = "/subscript")
    @ResponseBody
    public Map<String,Object> subscript(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String openId = (String) request.getAttribute("openId");
        String accessToken = AccessTokenUtil.getInstance().getAccessToken();
        logger.info("[" + new Date() + "]openId:"+openId);
        logger.info("[" + new Date() + "]accessToken:"+accessToken);
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        url = url.replace("ACCESS_TOKEN",accessToken).replace("OPENID",openId);
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);
        logger.info("[" + new Date() + "]jsonObject:"+jsonObject.toJSONString());
        int subscribe = jsonObject.getInteger("subscribe");
        if(subscribe == 1){
            map.put("result","true");
        }else{
            map.put("result","false");
        }
        return map;
    }
}
