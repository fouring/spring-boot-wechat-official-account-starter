package com.four.flower.wechat.oa.lock;

import java.util.function.Supplier;

/**
 * 如果是分布式请实现分布式等待锁
 * @author xiejing
 * @date 2020-01-09 15:41
 **/
public abstract class TokenExpireLock {

   public <T> T lockAndRelease(Supplier<T> supplier){
       try {
           if(lock()){
               return supplier.get();
           }
       }finally {
           unlock();
       }
       return failurePolicy();
   }

    /**
     * 实现等待锁
     * @return
     */
   public abstract Boolean lock();
   public abstract void unlock();
   public abstract <T> T failurePolicy();

}