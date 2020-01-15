package com.four.flower.evalution.ctrl;

import com.alibaba.fastjson.JSON;
import com.four.flower.wechat.oa.controller.WechatController;
import com.four.flower.wechat.oa.message.Message;
import com.four.flower.wechat.oa.message.Text;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiejing
 * @date 2020-01-15 18:12
 **/
@RestController
public class TestCtrl extends WechatController {

    @Override
    public String msgHandler(Message message) {
        System.out.println(JSON.toJSONString(message));
        return Text.makeFailure(message);
    }
}