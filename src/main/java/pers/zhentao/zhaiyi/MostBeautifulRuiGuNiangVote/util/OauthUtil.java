package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.util;

import com.alibaba.fastjson.JSONObject;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.SNSUserInfo;
import pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.WeixinOauth2Token;

/**
 * @author ZhangZhentao
 *         2017-08-08
 */
public class OauthUtil {
    public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
        WeixinOauth2Token weixinOauth2Token = null;
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);
        requestUrl = requestUrl.replace("CODE", code);
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                weixinOauth2Token = new WeixinOauth2Token();
                weixinOauth2Token.setAccessToken(jsonObject.getString("access_token"));
                weixinOauth2Token.setExpiresIn(jsonObject.getInteger("expires_in"));
                weixinOauth2Token.setRefreshToken(jsonObject.getString("refresh_token"));
                weixinOauth2Token.setOpenId(jsonObject.getString("openid"));
                weixinOauth2Token.setScope(jsonObject.getString("scope"));
            } catch (Exception e) {
                weixinOauth2Token = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
            }
        }
        return weixinOauth2Token;
    }

    public static WeixinOauth2Token refreshOauth2AccessToken(String appId, String refreshToken) {
        WeixinOauth2Token weixinOauth2Token = null;
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("REFRESH_TOKEN", refreshToken);
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                weixinOauth2Token = new WeixinOauth2Token();
                weixinOauth2Token.setAccessToken(jsonObject.getString("access_token"));
                weixinOauth2Token.setExpiresIn(jsonObject.getInteger("expires_in"));
                weixinOauth2Token.setRefreshToken(jsonObject.getString("refresh_token"));
                weixinOauth2Token.setOpenId(jsonObject.getString("openid"));
                weixinOauth2Token.setScope(jsonObject.getString("scope"));
            } catch (Exception e) {
                weixinOauth2Token = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
            }
        }
        return weixinOauth2Token;
    }

    public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
        SNSUserInfo snsUserInfo = null;
        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                snsUserInfo = new SNSUserInfo();
                snsUserInfo.setOpenId(jsonObject.getString("openid"));
                snsUserInfo.setNickname(jsonObject.getString("nickname"));
                snsUserInfo.setSex(jsonObject.getInteger("sex"));
                snsUserInfo.setCountry(jsonObject.getString("country"));
                snsUserInfo.setProvince(jsonObject.getString("province"));
                snsUserInfo.setCity(jsonObject.getString("city"));
                snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
                snsUserInfo.setPrivilegeList(jsonObject.getJSONArray("privilege").toJavaList(String.class));
            }catch (Exception e){
                snsUserInfo = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
            }
        }
        return snsUserInfo;
    }
}
