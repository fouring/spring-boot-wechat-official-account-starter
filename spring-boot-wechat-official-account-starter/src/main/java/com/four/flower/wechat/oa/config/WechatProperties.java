package com.four.flower.wechat.oa.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xiejing
 * @date 2020-01-09 15:17
 **/

@Setter
@Getter
@ConfigurationProperties(prefix = "wechat.config")
public class WechatProperties {

    protected String  url;
    protected String  appId;
    protected String  secretKey;
    protected String  token;
    protected String  aesKey;
    protected Integer freshTokenLockWaitTime = 15;
    protected Boolean enableLocalLock        = true;
    protected Boolean enableLocalStore       = true;

}