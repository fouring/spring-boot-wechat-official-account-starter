package com.four.flower.wechat.oa.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author xiejing
 * @date 2020-01-15 13:52
 **/
@Slf4j
public class RedisssionLock extends TokenExpireFreshLock {

    private static final String TOKEN_LOCK_KEY = "wechat:token:fresh:lock:key";

    @Autowired
    private RedisProperties prop;

    @Autowired
    private RedissonClient redissonClient;


    @Override
    public Boolean lock() {
        try {
            Lock lock = redissonClient.getLock(TOKEN_LOCK_KEY);
            return lock.tryLock(properties.getFreshTokenLockWaitTime(), TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void unlock() {
        try {
            Lock lock = redissonClient.getLock(TOKEN_LOCK_KEY);
            lock.unlock();
        } catch (Exception e) {
            log.error("unlock error", e);
        }

    }

    @Bean
    RedissonClient redisson() {
        Config config = new Config();
        String url = String.format("redis://%s:%s", prop.getHost(), prop.getPort());
        SingleServerConfig serverConfig = config.useSingleServer().setAddress(url).setDatabase(prop.getDatabase());
        if (StringUtils.isNotBlank(prop.getPassword())) {
            serverConfig.setPassword(prop.getPassword());
        }
        return Redisson.create(config);
    }
}