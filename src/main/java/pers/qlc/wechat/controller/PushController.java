package pers.qlc.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.qlc.wechat.util.Pusher;

@RestController
public class PushController {

    //要推送的用户openid
    private static final String qlc = "oOOdQ54bKBRnt4Xz3TiNHiFOARns";
    private static final String jyc = "oOOdQ5waS5bVDdgrwb6KlZMiYNkQ";

    // 推送
    @GetMapping("/push1")
    public void qlc() {
        Pusher.push(qlc);
    }

    // 推送
    @GetMapping("/push2")
    public void jyc() {
        Pusher.push(jyc);
    }

}
