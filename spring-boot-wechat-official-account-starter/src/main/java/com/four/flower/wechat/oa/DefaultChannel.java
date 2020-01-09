package com.four.flower.wechat.oa;

import com.four.flower.wechat.oa.directive.Directive;
import com.four.flower.wechat.oa.http.HttpClient;
import lombok.extern.slf4j.Slf4j;


/**
 * @author xiejing
 * @date 2020-01-09 16:30
 **/
@Slf4j
public abstract class DefaultChannel<DIRECTIVE extends Directive> {

    public void sendDirective(DIRECTIVE directive) {
        try {
            directive.prepare();
            String response = HttpClient.execute(directive);
            directive.receive(response);
        }  catch (Exception e) {
            log.info("======> sendDirective error", e);
            throw new RuntimeException(e);
        }
    }

}