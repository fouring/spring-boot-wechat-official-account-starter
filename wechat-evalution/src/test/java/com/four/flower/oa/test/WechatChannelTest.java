package com.four.flower.oa.test;

import com.four.flower.evalution.WechatApplication;
import com.four.flower.wechat.oa.WechatChannel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xiejing
 * @date 2019-12-23 11:17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WechatApplication.class)
@Slf4j
public class WechatChannelTest {

    @Autowired
    WechatChannel wechatChannel;

    @Test
    public void testGetToken() {
        String token = wechatChannel.getToken();
        System.out.println("================> " + token);
    }

}