package pers.zhentao.zhaiyi.backend.service.event;

import pers.zhentao.zhaiyi.backend.dto.event.SubscribeEvent;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-24
 */
public interface ISubscribeEventService {

    /**
     * 处理关注事件
     *
     * @param subscribeEvent
     * @return
     */
    String produceSubscribeEvent(SubscribeEvent subscribeEvent);
}
