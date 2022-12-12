package pers.qlc.wechat.util;

import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

/**
 * @author QLC
 */
public class Pusher {

    /**
     * appID
    */
    private static final String APP_ID = "wx0dafcd6fa89e29a8";

    /**
     * appSecret
     */
    private static final String SECRET = "996d22027ee1adf6e772c53001dbbeab";

    /**
     * 模板ID
     */
    private static final String TEMPLATE_ID = "ij-21g5KI28Ul3N27cQYiFe86Ez0N_WKwZC9DG-oP_U";

    public static void push(String openId){
        // 1.配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(APP_ID);
        wxStorage.setSecret(SECRET);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        // 2.创建实例
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(TEMPLATE_ID)
                .build();

        // 3.填写变量信息，比如天气之类的
        JSONObject todayWeather = TianApi.getWeather();
        templateMessage.addData(new WxMpTemplateData("riqi",todayWeather.getString("date") + "  "+ todayWeather.getString("week")));
        templateMessage.addData(new WxMpTemplateData("tianqi",todayWeather.getString("weather")));
        templateMessage.addData(new WxMpTemplateData("city",todayWeather.getString("area")));
        templateMessage.addData(new WxMpTemplateData("low",todayWeather.getString("lowest")));
        templateMessage.addData(new WxMpTemplateData("high",todayWeather.getString("highest")));
        templateMessage.addData(new WxMpTemplateData("caihongpi", TianApi.getCaiHongPi(),"#FF69B4"));
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
