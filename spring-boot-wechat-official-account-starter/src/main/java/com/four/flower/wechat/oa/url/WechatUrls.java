package com.four.flower.wechat.oa.url;

import com.four.flower.wechat.oa.WechatChannel;

/**
 * @author xiejing
 * @date 2020-01-09 16:36
 **/
public class WechatUrls {

    public static String getTokenUrl(WechatChannel wechatChannel) {
        return getBaseUrl(wechatChannel) + "token";
    }

    private static String getBaseUrl(WechatChannel channel){
        return channel.getConfig().getUrl();
    }
}