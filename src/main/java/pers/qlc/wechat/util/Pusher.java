package pers.qlc.wechat.util;

import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

public class Pusher {

    // appID
    private static final String appId = "wx0dafcd6fa89e29a8";

    //appsecret
    private static final String secret = "996d22027ee1adf6e772c53001dbbeab";

    //模版ID
    private static final String templateId = "CqiFyVfHZNKNDiQ66gPLZfyYMo6f63z2lMP9EClBTRQ";

    public static void push(String openId){
        // 1.配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        // 2.创建实例
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                .build();

        // 3.填写变量信息，比如天气之类的
        JSONObject todayWeather = TianAPI.getWeather();
        templateMessage.addData(new WxMpTemplateData("riqi",todayWeather.getString("date") + "  "+ todayWeather.getString("week")));
        templateMessage.addData(new WxMpTemplateData("tianqi",todayWeather.getString("weather")));
        templateMessage.addData(new WxMpTemplateData("city",todayWeather.getString("area")));
        templateMessage.addData(new WxMpTemplateData("low",todayWeather.getString("lowest")));
        templateMessage.addData(new WxMpTemplateData("high",todayWeather.getString("highest")));
        templateMessage.addData(new WxMpTemplateData("caihongpi", TianAPI.getCaiHongPi(),"#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("lianai", MemorialDay.getLianAi()+"","#FF1493"));

        // 4.推送
        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

}
