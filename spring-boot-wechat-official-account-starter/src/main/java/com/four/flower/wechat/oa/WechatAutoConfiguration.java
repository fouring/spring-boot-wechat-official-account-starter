package com.four.flower.wechat.oa;

import com.four.flower.wechat.oa.config.WechatProperties;
import com.four.flower.wechat.oa.lock.SingleInstanceLock;
import com.four.flower.wechat.oa.lock.TokenExpireLock;
import com.four.flower.wechat.oa.store.LocalTokenStore;
import com.four.flower.wechat.oa.store.RedisTokenStore;
import com.four.flower.wechat.oa.store.TokenStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiejing
 * @date 2020-01-14 15:40
 **/
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(WechatProperties.class)
@EnableConfigurationProperties(WechatProperties.class)
@ComponentScan("com.four.flower.wechat.oa")
public class WechatAutoConfiguration {

    @Bean
    public TokenStore initTokenStore(WechatProperties properties) {
        if (properties.getEnableRedisStore()) {
            return new RedisTokenStore();
        } else {
            return new LocalTokenStore();
        }
    }

    @Bean
    public TokenExpireLock initTokenExpireLock(WechatProperties properties) {
        if (properties.getEnableLocalLock()) {
            return new SingleInstanceLock();
        } else {
            return null;
        }
    }


}