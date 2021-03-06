package com.four.flower.wechat.oa.store;

/**
 * @author xiejing
 * @date 2020-01-09 15:26
 **/
public interface TokenStore {

    /**
     *
     * @param token
     * @param expireTime seconds
     */
    void store(String token, Integer expireTime);

    String getToken();

}