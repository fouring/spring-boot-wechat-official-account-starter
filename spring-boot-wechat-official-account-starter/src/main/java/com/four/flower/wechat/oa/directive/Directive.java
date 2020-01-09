package com.four.flower.wechat.oa.directive;

import com.four.flower.wechat.oa.WechatChannel;
import com.four.flower.wechat.oa.http.HttpMethod;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;


/**
 * description:
 * date: 2018-05-21 14:12
 *
 * @author xiejing
 */
@Setter
@Getter
@Slf4j
public abstract class Directive<REQUEST, RESPONSE> {

    protected REQUEST    request;
    protected RESPONSE   response;
    protected HttpMethod httpMethod;
    protected WechatChannel wechatChannel;

    public abstract String getRequestUrl();

    public abstract Request buildOkHttpRequest();

    public abstract void prepare();

    public abstract void receive(String response);
}