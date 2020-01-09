package com.four.flower.wechat.oa.utils;

import com.google.common.base.Joiner;
import org.springframework.data.redis.core.script.DigestUtils;

import java.util.Arrays;

/**
 * @author xiejing
 * @date 2020-01-09 17:04
 **/
public class SignUtils {

    public static String sign(String... arr) {
        Arrays.sort(arr);
        return DigestUtils.sha1DigestAsHex(Joiner.on("").join(arr));
    }
}