package pers.zhentao.zhaiyi.backend.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.zhentao.zhaiyi.backend.dto.event.*;
import pers.zhentao.zhaiyi.backend.dto.request.*;
import pers.zhentao.zhaiyi.backend.service.event.ISubscribeEventService;
import pers.zhentao.zhaiyi.backend.util.MessageUtil;
import pers.zhentao.zhaiyi.backend.util.SignUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-24
 */
@Controller
public class CoreController {
    private Logger logger = Logger.getLogger(CoreController.class);

    @Autowired
    private ISubscribeEventService subscribeEventServiceImpl;

    /**
     * 请求校验（确认请求来自微信服务器）
     */
    @RequestMapping(value = "/backend", method = RequestMethod.GET)
    @ResponseBody
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        logger.info("[" + new Date() + "]signature:" + signature + ",timestamp:" + timestamp + ",nonce:" + nonce + ",echostr:" + echostr);
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            logger.info("[" + new Date() + "]check pass!");
            return echostr;
        }
        logger.info("[" + new Date() + "]check failed!");
        return null;
    }

    /**
     * 处理用户消息
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/backend", method = RequestMethod.POST)
    @ResponseBody
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        String respXml = "";
        try {
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            String fromUserName = requestMap.get("FromUserName");
            String toUserName = requestMap.get("ToUserName");
            String createTime = requestMap.get("CreateTime");
            String msgType = requestMap.get("MsgType");
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                String content = requestMap.get("Content");
                String msgId = requestMap.get("MsgId");
                TextMessage textMessage = new TextMessage();
                textMessage.setFromUserName(fromUserName);
                textMessage.setToUserName(toUserName);
                textMessage.setCreateTime(Long.parseLong(createTime));
                textMessage.setMsgType(msgType);
                textMessage.setContent(content);
                textMessage.setMsgId(Long.parseLong(msgId));
                logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(textMessage));
                //TODO 处理文本消息
                respXml = "";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                String picUrl = requestMap.get("PicUrl");
                String mediaId = requestMap.get("MediaId");
                String msgId = requestMap.get("MsgId");
                ImageMessage imageMessage = new ImageMessage();
                imageMessage.setFromUserName(fromUserName);
                imageMessage.setToUserName(toUserName);
                imageMessage.setCreateTime(Long.parseLong(createTime));
                imageMessage.setMsgType(msgType);
                imageMessage.setPicUrl(picUrl);
                imageMessage.setMediaId(mediaId);
                imageMessage.setMsgId(Long.parseLong(msgId));
                logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(imageMessage));
                //TODO 处理图片消息
                respXml = "";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                String mediaId = requestMap.get("MediaId");
                String format = requestMap.get("Format");
                String msgId = requestMap.get("MsgId");
                VoiceMessage voiceMessage = new VoiceMessage();
                voiceMessage.setFromUserName(fromUserName);
                voiceMessage.setToUserName(toUserName);
                voiceMessage.setCreateTime(Long.parseLong(createTime));
                voiceMessage.setMsgType(msgType);
                voiceMessage.setMediaId(mediaId);
                voiceMessage.setFormat(format);
                voiceMessage.setMsgId(Long.parseLong(msgId));
                logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(voiceMessage));
                //TODO 处理语音消息
                respXml = "";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                String mediaId = requestMap.get("MediaId");
                String thumbMediaId = requestMap.get("ThumbMediaId");
                String msgId = requestMap.get("MsgId");
                VideoMessage videoMessage = new VideoMessage();
                videoMessage.setFromUserName(fromUserName);
                videoMessage.setToUserName(toUserName);
                videoMessage.setCreateTime(Long.parseLong(createTime));
                videoMessage.setMsgType(msgType);
                videoMessage.setMediaId(mediaId);
                videoMessage.setThumbMediaId(thumbMediaId);
                videoMessage.setMsgId(Long.parseLong(msgId));
                logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(videoMessage));
                //TODO 处理视频消息
                respXml = "";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
                String mediaId = requestMap.get("MediaId");
                String thumbMediaId = requestMap.get("ThumbMediaId");
                String msgId = requestMap.get("MsgId");
                ShortVideoMessage shortVideoMessage = new ShortVideoMessage();
                shortVideoMessage.setFromUserName(fromUserName);
                shortVideoMessage.setToUserName(toUserName);
                shortVideoMessage.setCreateTime(Long.parseLong(createTime));
                shortVideoMessage.setMsgType(msgType);
                shortVideoMessage.setMediaId(mediaId);
                shortVideoMessage.setThumbMediaId(thumbMediaId);
                shortVideoMessage.setMsgId(Long.parseLong(msgId));
                logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(shortVideoMessage));
                //TODO 处理小视频消息
                respXml = "";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                String lat = requestMap.get("Location_X");
                String lng = requestMap.get("Location_Y");
                String label = requestMap.get("Label");
                String scale = requestMap.get("Scale");
                String msgId = requestMap.get("MsgId");
                LocationMessage locationMessage = new LocationMessage();
                locationMessage.setFromUserName(fromUserName);
                locationMessage.setToUserName(toUserName);
                locationMessage.setCreateTime(Long.parseLong(createTime));
                locationMessage.setMsgType(msgType);
                locationMessage.setLocationX(lat);
                locationMessage.setLocationY(lng);
                locationMessage.setLabel(label);
                locationMessage.setScale(scale);
                locationMessage.setMsgId(Long.parseLong(msgId));
                logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(locationMessage));
                //TODO 处理位置消息
                respXml = "";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                String title = requestMap.get("Title");
                String description = requestMap.get("Description");
                String url = requestMap.get("Url");
                String msgId = requestMap.get("MsgId");
                LinkMessage linkMessage = new LinkMessage();
                linkMessage.setFromUserName(fromUserName);
                linkMessage.setToUserName(toUserName);
                linkMessage.setCreateTime(Long.parseLong(createTime));
                linkMessage.setMsgType(msgType);
                linkMessage.setTitle(title);
                linkMessage.setDescription(description);
                linkMessage.setUrl(url);
                linkMessage.setMsgId(Long.parseLong(msgId));
                logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(linkMessage));
                //TODO 处理链接消息
                respXml = "";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                String eventType = requestMap.get("Event");
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    SubscribeEvent subscribeEvent = new SubscribeEvent();
                    subscribeEvent.setFromUserName(fromUserName);
                    subscribeEvent.setToUserName(toUserName);
                    subscribeEvent.setCreateTime(Long.parseLong(createTime));
                    subscribeEvent.setMsgType(msgType);
                    subscribeEvent.setEvent(eventType);
                    logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(subscribeEvent));
                    //TODO 处理用户关注事件
                    respXml = subscribeEventServiceImpl.produceSubscribeEvent(subscribeEvent);
                    String eventKey = requestMap.get("EventKey");
                    String ticket = requestMap.get("Ticket");
                    if (eventKey != null && ticket != null) {
                        QRCodeEvent qrCodeEvent = new QRCodeEvent();
                        qrCodeEvent.setFromUserName(fromUserName);
                        qrCodeEvent.setToUserName(toUserName);
                        qrCodeEvent.setCreateTime(Long.parseLong(createTime));
                        qrCodeEvent.setMsgType(msgType);
                        qrCodeEvent.setEvent(eventType);
                        qrCodeEvent.setEventKey(eventKey);
                        qrCodeEvent.setTicket(ticket);
                        logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(qrCodeEvent));
                        //TODO 处理用户扫描带参数二维码事件

                    }

                } else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    UnSubscribeEvent unSubscribeEvent = new UnSubscribeEvent();
                    unSubscribeEvent.setFromUserName(fromUserName);
                    unSubscribeEvent.setToUserName(toUserName);
                    unSubscribeEvent.setCreateTime(Long.parseLong(createTime));
                    unSubscribeEvent.setMsgType(msgType);
                    unSubscribeEvent.setEvent(eventType);
                    logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(unSubscribeEvent));
                    //TODO 处理用户取消关注事件
                    //取消关注后，用户收不到公众号消息
                    respXml = "";
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    String eventKey = requestMap.get("EventKey");
                    String ticket = requestMap.get("Ticket");
                    if (eventKey != null && ticket != null) {
                        QRCodeEvent qrCodeEvent = new QRCodeEvent();
                        qrCodeEvent.setFromUserName(fromUserName);
                        qrCodeEvent.setToUserName(toUserName);
                        qrCodeEvent.setCreateTime(Long.parseLong(createTime));
                        qrCodeEvent.setMsgType(msgType);
                        qrCodeEvent.setEvent(eventType);
                        qrCodeEvent.setEventKey(eventKey);
                        qrCodeEvent.setTicket(ticket);
                        logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(qrCodeEvent));
                        //TODO 处理用户扫描带参数二维码事件（已关注）
                        respXml = "";
                    }
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    String latitude = requestMap.get("Latitude");
                    String longitude = requestMap.get("longitude");
                    String precision = requestMap.get("precision");
                    LocationEvent locationEvent = new LocationEvent();
                    locationEvent.setFromUserName(fromUserName);
                    locationEvent.setToUserName(toUserName);
                    locationEvent.setCreateTime(Long.parseLong(createTime));
                    locationEvent.setMsgType(msgType);
                    locationEvent.setEvent(eventType);
                    locationEvent.setLatitude(latitude);
                    locationEvent.setLongitude(longitude);
                    locationEvent.setPrecision(precision);
                    logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(locationEvent));
                    //TODO 处理用户上报地理位置信息事件
                    respXml = "";
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    String eventKey = requestMap.get("EventKey");
                    ClickEvent clickEvent = new ClickEvent();
                    clickEvent.setFromUserName(fromUserName);
                    clickEvent.setToUserName(toUserName);
                    clickEvent.setCreateTime(Long.parseLong(createTime));
                    clickEvent.setMsgType(msgType);
                    clickEvent.setEvent(eventType);
                    clickEvent.setEventKey(eventKey);
                    logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(clickEvent));
                    //TODO 处理点击菜单拉取信息事件
                    respXml = "";
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {
                    String eventKey = requestMap.get("EventKey");
                    ViewEvent viewEvent = new ViewEvent();
                    viewEvent.setFromUserName(fromUserName);
                    viewEvent.setToUserName(toUserName);
                    viewEvent.setCreateTime(Long.parseLong(createTime));
                    viewEvent.setMsgType(msgType);
                    viewEvent.setEvent(eventType);
                    viewEvent.setEventKey(eventKey);
                    logger.info("["+new Date()+"]receive message:"+JSONObject.toJSON(viewEvent));
                    //TODO 处理点击菜单跳转链接事件
                    respXml = "";
                }
            }
        } catch (Exception e) {
            logger.error("["+new Date()+"]消息处理异常:"+e.getStackTrace());
            logger.info("["+new Date()+"]response message:"+respXml);
            return respXml;
        }
        logger.info("["+new Date()+"]response message:"+respXml);
        return respXml;
    }
}
