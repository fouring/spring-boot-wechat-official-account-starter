package com.four.flower.evalution.lock;

import com.four.flower.wechat.oa.lock.TokenExpireLock;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiejing
 * @date 2020-01-09 16:11
 **/
@Component
public class SingleInstanceLock extends TokenExpireLock {

    private Lock lock = new ReentrantLock();

    @Override
    public Boolean lock() {
        try {
            return lock.tryLock(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void unlock() {
        lock.unlock();
    }

    @Override
    public <T> T failurePolicy() {
        throw new RuntimeException(" get token fail");
    }
}