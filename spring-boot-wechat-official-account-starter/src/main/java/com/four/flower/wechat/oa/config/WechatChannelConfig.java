package com.four.flower.wechat.oa.config;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiejing
 * @date 2020-01-09 15:17
 **/

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "wechat.config")
public class WechatChannelConfig{

    /**
     * 渠道地址
     */
    protected String              url;

    /**
     *
     */
    protected String              appId;
    protected String              secretKey;
    protected String              token;
    protected String              aesKey;
}