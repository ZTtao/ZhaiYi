package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangZhentao
 *         2017-08-13
 */
@Component("BeanDefineConfigue")
public class RunThread implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = Logger.getLogger(RunThread.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            if (event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")) {
                logger.info("初始化");
                Runnable runnable = AccessTokenUtil.getInstance().getRunnable();
                ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
                service.scheduleAtFixedRate(runnable, 0, 30, TimeUnit.MINUTES);
            }
        }
    }
}
