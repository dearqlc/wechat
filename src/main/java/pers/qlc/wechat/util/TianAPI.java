package pers.qlc.wechat.util;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Objects;

public class TianAPI {

    private static final String key = "e69416cebeca8b36be6a720082ab17f2";

    // 彩虹皮请求地址
    private static final String caihongpi_url = "https://api.tianapi.com/caihongpi/index?key=";

    // 天气请求地址
    private static final String tianqi_url = "https://api.tianapi.com/tianqi/index?key=";

    // 查询天气的城市名
    public static final String city = "上虞";

    private static final String name = "景艳铖";

    // 获取天气信息
    public static JSONObject getWeather() {
        JSONObject today = new JSONObject();
        try {
            JSONObject jsonObject = JSONObject.parseObject(Objects.requireNonNull(HttpUtil.getUrl(tianqi_url + key + "&city=" + city)));
            if (jsonObject.getIntValue("code") == 200) {
                today = jsonObject.getJSONArray("newslist").getJSONObject(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return today;
    }

    // 获取彩虹屁
    public static String getCaiHongPi() {
        String str = "";
        try {
            JSONObject jsonObject = JSONObject.parseObject(Objects.requireNonNull(HttpUtil.getUrl(caihongpi_url + key)));
            if (jsonObject.getIntValue("code") == 200) {
                str = jsonObject.getJSONArray("newslist").getJSONObject(0).getString("content").replace("XXX", name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("\n" + getCaiHongPi() + "\n");
        System.out.println(getWeather());
    }

}
