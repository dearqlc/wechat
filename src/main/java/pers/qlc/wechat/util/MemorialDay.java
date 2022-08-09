package pers.qlc.wechat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MemorialDay {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // 恋爱
    static String lianAi = "2022-07-30";

    // 已经过去date多少天
    public static int time(String date) {
        int day = 0;
        try {
            long time = Math.abs(System.currentTimeMillis() - simpleDateFormat.parse(date).getTime());
            day = (int) (time / 1000L / 60L / 60L / 24L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    public static int getLianAi() {
        return time(lianAi);
    }

    public static void main(String[] args) {
        System.out.println(time(lianAi));
    }

}
