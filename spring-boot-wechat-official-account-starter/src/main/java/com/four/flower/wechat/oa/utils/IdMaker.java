package com.four.flower.wechat.oa.utils;


/**
 * @author xiejing
 * @date 2019-12-27 12:17
 **/
public class IdMaker {

    private static Snowflake snowflake = new Snowflake(0, 1);

    public static String getStringId() {
        return String.valueOf(snowflake.nextId());
    }

    public static Long getLongId() {
        return snowflake.nextId();
    }
}