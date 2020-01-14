package com.four.flower.wechat.oa.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author xiejing
 * @date 2020-01-09 15:28
 **/
public class RedisTokenStore implements TokenStore{

    private static final String WECHAT_ACCESS_TOKEN = "wechat:token:cache:key";

    @Autowired
    protected StringRedisTemplate redisTemplate;

    @Override
    public void store(String token, Integer expireTime) {
        redisTemplate.opsForValue().set(WECHAT_ACCESS_TOKEN,token,expireTime, TimeUnit.SECONDS);
    }

    @Override
    public String getToken() {
        return redisTemplate.opsForValue().get(WECHAT_ACCESS_TOKEN);
    }
}