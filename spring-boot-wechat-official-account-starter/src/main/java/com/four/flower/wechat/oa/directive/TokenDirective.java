package com.four.flower.wechat.oa.directive;

import com.alibaba.fastjson.JSON;
import com.four.flower.wechat.oa.WechatChannel;
import com.four.flower.wechat.oa.response.TokenResult;
import com.four.flower.wechat.oa.url.WechatUrls;
import okhttp3.Request;

/**
 * @author xiejing
 * @date 2020-01-09 16:33
 **/
public class TokenDirective extends DefaultDirective<String,TokenResult>{

    public TokenDirective(WechatChannel channel) {
        super(channel);
    }

    @Override
    public String getRequestUrl() {
        return WechatUrls.getTokenUrl(wechatChannel)
                .concat("?grant_type=client_credential")
                .concat("&appid=").concat(wechatChannel.getConfig().getAppId())
                .concat("&secret=").concat(wechatChannel.getConfig().getSecretKey());
    }

    @Override
    public Request buildOkHttpRequest() {
        return buildGetRequest();
    }

    @Override
    public void prepare() {

    }

    @Override
    public void receive(String json) {
        response = JSON.parseObject(json, TokenResult.class);
    }
}