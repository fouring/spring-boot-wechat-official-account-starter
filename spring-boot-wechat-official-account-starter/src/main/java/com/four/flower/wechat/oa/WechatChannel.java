package com.four.flower.wechat.oa;

import com.four.flower.wechat.oa.config.WechatProperties;
import com.four.flower.wechat.oa.directive.DefaultDirective;
import com.four.flower.wechat.oa.directive.TokenDirective;
import com.four.flower.wechat.oa.lock.TokenExpireFreshLock;
import com.four.flower.wechat.oa.response.TokenResult;
import com.four.flower.wechat.oa.store.TokenStore;
import com.four.flower.wechat.oa.utils.SignUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author xiejing
 * @date 2020-01-09 15:24
 **/
@Setter
@Getter
@Component
public class WechatChannel extends DefaultChannel<DefaultDirective>{

    @Autowired
    private TokenExpireFreshLock lock;
    @Autowired
    private WechatProperties     config;
    @Autowired
    private TokenStore       tokenStore;


    /**
     * 验证消息自微信服务器
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public Boolean verifySignature(String signature,String timestamp,String nonce){
        return Objects.equals(SignUtils.sign(getConfig().getToken(),timestamp,nonce),signature);
    }

    /**
     * 获取token，如果缓存没有，刷新
     * @return
     */
    public String getToken(){
       String token = tokenStore.getToken();
       if(Objects.nonNull(token)){
           return token;
       }
       return freshToken();
    }

    /**
     * 缓存穿透，刷新上锁
     * @return
     */
    private String freshToken(){
       return lock.lockAndRelease(this::obtainToken);
    }

    /**
     * 访问微信接口获取token
     * @return
     */
    private String obtainToken(){
        String token = tokenStore.getToken();
        if(Objects.nonNull(token)){
            return token;
        }
        TokenDirective tokenDirective = new TokenDirective(this);
        sendDirective(tokenDirective);
        TokenResult result = tokenDirective.getResponse();
        tokenStore.store(result.getAccessToken(),result.getExpiresIn());
        return result.getAccessToken();
    }

}