package pers.qlc.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.qlc.wechat.util.Pusher;

/**
 * @author QLC
 */
@RestController
public class PushController {

    /**
     * OPENID
     */
    private static final String QLC_OPENID = "oOOdQ54bKBRnt4Xz3TiNHiFOARns";

    /**
     * OPENID
     */
    private static final String LY_OPENID = "oOOdQ5wHqj9RL1z9LBreT91_MW20";

    /**
     * 推送
     */
    @GetMapping("/push1")
    public void qlc() {
                Pusher.push(QLC_OPENID);
    }

    /**
     * 推送
     */
    @GetMapping("/push2")
    public void ly() {
        Pusher.push(LY_OPENID);
    }
}
