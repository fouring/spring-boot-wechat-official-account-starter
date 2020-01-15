package com.four.flower.wechat.oa.lock;

import com.four.flower.wechat.oa.config.WechatProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Supplier;

/**
 * 如果是分布式请实现分布式等待锁
 *
 * @author xiejing
 * @date 2020-01-09 15:41
 **/
public abstract class TokenExpireFreshLock {

    @Autowired
    protected WechatProperties properties;

    public <T> T lockAndRelease(Supplier<T> supplier) {
        try {
            if (lock()) {
                return supplier.get();
            }
        } finally {
            unlock();
        }
        return failurePolicy();
    }

    /**
     * 实现等待锁
     *
     * @return
     */
    public abstract Boolean lock();

    public abstract void unlock();

    public <T> T failurePolicy() {
        throw new RuntimeException(" get token fail");
    }

}