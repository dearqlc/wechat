package pers.qlc.wechat.util;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Objects;

/**
 * @author QLC
 */
public class TianApi {

    private static final String KEY = "e69416cebeca8b36be6a720082ab17f2";

    /**
     * 彩虹屁请求地址
     */
    private static final String CAIHONGPI_URL = "https://api.tianapi.com/caihongpi/index?key=";

    /**
     * 天气请求地址
     */
    private static final String TIANQI_URL = "https://api.tianapi.com/tianqi/index?key=";

    /**
     * 查询天气的城市名
     */
    public static final String CITY = "杭州";

    private static final String NAME = "裘力成";

    private static final String CODE = "code";

    private static final int STATUS_200 = 200;
    /**
     * 获取天气信息
     */
    public static JSONObject getWeather() {
        JSONObject today = new JSONObject();
        try {
            JSONObject jsonObject = JSONObject.parseObject(Objects.requireNonNull(HttpUtil.getUrl(TIANQI_URL + KEY + "&city=" + CITY)));

            if (jsonObject.getIntValue(CODE) == STATUS_200) {
                today = jsonObject.getJSONArray("newslist").getJSONObject(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return today;
    }

    /**
     * 获取彩虹屁
     */
    public static String getCaiHongPi() {
        String str = "";
        try {
            JSONObject jsonObject = JSONObject.parseObject(Objects.requireNonNull(HttpUtil.getUrl(CAIHONGPI_URL + KEY)));
            if (jsonObject.getIntValue(CODE) == STATUS_200) {
                str = jsonObject.getJSONArray("newslist").getJSONObject(0).getString("content").replace("XXX", NAME);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(getCaiHongPi());
        System.out.println(getWeather());
    }

}
