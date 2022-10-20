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
     * 要推送的用户openid
     */
    private static final String QLC = "oOOdQ54bKBRnt4Xz3TiNHiFOARns";

    /**
     * 推送
     */
    @GetMapping("/push")
    public void qlc() {
                Pusher.push(QLC);
    }

}
