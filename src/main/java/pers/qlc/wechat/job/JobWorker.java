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
     * OPENID
     */
    private static final String LY_OPEN_ID = "oOOdQ5wHqj9RL1z9LBreT91_MW20";

    @Scheduled(cron = "0 30 7 * * ?")
    public void goodMorning(){
        Pusher.push(LY_OPEN_ID);
    }

}
