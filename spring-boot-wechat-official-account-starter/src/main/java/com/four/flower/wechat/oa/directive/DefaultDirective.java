package com.four.flower.wechat.oa.directive;

import com.alibaba.fastjson.JSON;
import com.four.flower.wechat.oa.WechatChannel;
import com.four.flower.wechat.oa.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author: xiejing
 * @date: 2019-11-19 10:43
 **/
@Slf4j
public abstract class DefaultDirective<REQUEST, RESPONSE> extends Directive<REQUEST, RESPONSE> {

    public DefaultDirective(WechatChannel channel) {
        this.wechatChannel = channel;
    }

    @Override
    public Request buildOkHttpRequest() {
        RequestBody body = RequestBody.create(MediaType.get(ContentType.JSON.getValue()), JSON.toJSONString(getRequest()));
        return new Request.Builder()
                .url(getRequestUrl())
                .post(body)
                .build();
    }

    protected Request buildGetRequest() {
        return new Request.Builder()
                .url(getRequestUrl())
                .get()
                .build();
    }
}