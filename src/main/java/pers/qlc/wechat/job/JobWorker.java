package pers.qlc.wechat.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pers.qlc.wechat.util.Pusher;

/**
 * @author QLC
 */
@Component
public class JobWorker {

    /**
     * 要推送的用户openid
     */
    private static final String OPEN_ID = "oOOdQ5waS5bVDdgrwb6KlZMiYNkQ";

    @Scheduled(cron = "0 30 7 * * ?")
    public void goodMorning(){
        Pusher.push(OPEN_ID);
    }

}
