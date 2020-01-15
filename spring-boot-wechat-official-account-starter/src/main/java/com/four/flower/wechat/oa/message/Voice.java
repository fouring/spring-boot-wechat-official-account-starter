package com.four.flower.wechat.oa.message;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiejing
 * @date 2020-01-15 15:31
 **/
@Setter
@Getter
public class Voice extends Media {

    private String format;
    private String recognition;

}