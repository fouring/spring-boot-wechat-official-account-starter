package com.four.flower.evalution.config;

import com.four.flower.wechat.oa.store.RedisTokenStore;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xiejing
 * @date 2020-01-09 17:57
 **/
@Configuration
@ComponentScan("com.four.flower")
@Import(RedisTokenStore.class)
public class WebConfig {
}