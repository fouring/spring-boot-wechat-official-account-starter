package com.four.flower.wechat.oa.controller;

import com.four.flower.wechat.oa.WechatChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiejing
 * @date 2020-01-09 18:22
 **/
@RestController
@Slf4j
public class WechatController {

    @Autowired
    WechatChannel channel;

    @GetMapping("/wechat")
    public String wechatVerify(@RequestParam(name = "nonce") String nonce,
                               @RequestParam(name = "echostr") String echostr,
                               @RequestParam(name = "signature") String signature,
                               @RequestParam(name = "timestamp") String timestamp){
        if(channel.verifySignature(signature,timestamp,nonce)){
            return echostr;
        }
        return "IllegalAccessError";
    }

    @PostMapping("/wechat")
    public String post(@RequestBody String requestBody,
                       @RequestParam("openid") String openid,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        if(!channel.verifySignature(signature,timestamp,nonce)){
            return "IllegalAccessError";
        }
        return "out";
    }



}