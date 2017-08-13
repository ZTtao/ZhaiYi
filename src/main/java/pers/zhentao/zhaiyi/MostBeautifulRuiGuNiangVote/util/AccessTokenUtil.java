package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * @author ZhangZhentao
 *         2017-08-13
 */
public class AccessTokenUtil {
    private static Logger logger = Logger.getLogger(AccessTokenUtil.class);
    private volatile static AccessTokenUtil accessTokenUtil = null;
    private String accessToken = null;
    private int expiresIn = 0;
    private Date lastUpdate = null;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //刷新accessToken
            String APPID = "wxa4acc514572f1238";
            String APPSECRET = "5eca522851575a5dcf4aa0127023ef1a";
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
            url = url.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
            logger.info(url);
            JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);
            logger.info("["+new Date()+"]jsonObject:"+jsonObject.toJSONString());
            accessToken = jsonObject.getString("access_token");
            expiresIn = jsonObject.getInteger("expires_in");
            lastUpdate = new Date();
            //
            logger.info("[" + new Date() + "]accessToken:" + accessToken);
            logger.info("[" + new Date() + "]expiresIn:" + expiresIn);
        }
    };

    private AccessTokenUtil() {
    }

    public static AccessTokenUtil getInstance() {
        if (accessTokenUtil == null) {
            synchronized (AccessTokenUtil.class) {
                if (accessTokenUtil == null) {
                    accessTokenUtil = new AccessTokenUtil();
                }
            }
        }
        return accessTokenUtil;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
