package com.four.flower.wechat.oa.controller;

import com.four.flower.wechat.oa.WechatChannel;
import com.four.flower.wechat.oa.message.Message;
import com.four.flower.wechat.oa.message.Text;
import com.four.flower.wechat.oa.message.reader.MsgReader;
import com.four.flower.wechat.oa.type.MsgType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiejing
 * @date 2020-01-09 18:22
 **/
@Slf4j
public abstract class WechatController {

    @Autowired
    protected WechatChannel channel;

    /**
     * url 配置认证接口
     *
     * @param nonce
     * @param echostr
     * @param signature
     * @param timestamp
     * @return
     */
    @GetMapping("/wechat")
    public String wechatVerify(@RequestParam(name = "nonce") String nonce,
                               @RequestParam(name = "echostr") String echostr,
                               @RequestParam(name = "signature") String signature,
                               @RequestParam(name = "timestamp") String timestamp) {
        if (channel.verifySignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }

    /**
     * 消息推送接口
     *
     * @param xml
     * @param nonce
     * @param signature
     * @param timestamp
     * @param encType
     * @param msgSignature
     * @return
     */
    @PostMapping("/wechat")
    public String post(@RequestBody String xml,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature) {

        Message message = MsgReader.reader(xml, MsgType.getMsgClass(xml));
        if (!channel.verifySignature(signature, timestamp, nonce)) {
            return verifySignatureFailure(message);
        }
        return msgHandler(message);
    }

    /**
     * recommend override the method
     *
     * @return
     */
    public String verifySignatureFailure(Message message) {
        return Text.makeFailure(message);
    }

    public abstract String msgHandler(Message message);


}