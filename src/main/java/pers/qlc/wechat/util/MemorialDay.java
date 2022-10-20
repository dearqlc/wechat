package pers.qlc.wechat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author QLC
 */
public class MemorialDay {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private static final String LOVE = "2000-07-17";

    public static int time(String date) {
        int day = 0;
        try {
            long time = Math.abs(System.currentTimeMillis() - SIMPLE_DATE_FORMAT.parse(date).getTime());
            day = (int) (time / 1000L / 60L / 60L / 24L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    public static int getLianAi() {
        return time(LOVE);
    }

    public static void main(String[] args) {
        System.out.println(time(LOVE));
    }

}
