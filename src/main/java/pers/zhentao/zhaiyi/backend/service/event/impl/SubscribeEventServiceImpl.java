package pers.zhentao.zhaiyi.backend.service.event.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.zhentao.zhaiyi.backend.dto.event.SubscribeEvent;
import pers.zhentao.zhaiyi.backend.dto.response.TextMessage;
import pers.zhentao.zhaiyi.backend.service.event.ISubscribeEventService;
import pers.zhentao.zhaiyi.backend.util.MessageUtil;

import java.util.Date;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-24
 */
@Service
@Transactional
public class SubscribeEventServiceImpl implements ISubscribeEventService {
    @Override
    public String produceSubscribeEvent(SubscribeEvent subscribeEvent) {
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(subscribeEvent.getToUserName());
        textMessage.setToUserName(subscribeEvent.getFromUserName());
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setContent("关注事件反馈abc");
        return MessageUtil.messageToXml(textMessage);
    }
}
