package com.four.flower.wechat.oa.store;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author xiejing
 * @date 2020-01-14 16:08
 **/
public class LocalTokenStore implements TokenStore {

    public final Store STORE = new Store();

    @Override
    public void store(String token, Integer expireTime) {
        STORE.setToken(token);
        STORE.setExpireTime(LocalDateTime.now().plusSeconds(expireTime));
    }

    @Override
    public String getToken() {
        String token = STORE.getToken();
        if (Objects.isNull(token)) {
            return null;
        }
        if (LocalDateTime.now().isAfter(STORE.getExpireTime())) {
            return null;
        }
        return token;
    }

    @Setter
    @Getter
    private static class Store {
        private String        token;
        private LocalDateTime expireTime;
    }
}