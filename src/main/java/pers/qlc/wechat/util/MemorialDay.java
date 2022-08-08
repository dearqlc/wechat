package pers.qlc.wechat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MemorialDay {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // 恋爱
    static String lianAi = "2022-07-30";

    // 已经过去date多少天
    public static int after(String date) {
        int day = 0;
        try {
            long time = System.currentTimeMillis() - simpleDateFormat.parse(date).getTime();
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    public static int getLianAi() {
        return after(lianAi);
    }

    public static void main(String[] args) {
        System.out.println(getLianAi());
    }

}
