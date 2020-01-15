package com.four.flower.wechat.oa.message;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiejing
 * @date 2020-01-15 15:42
 **/
@Setter
@Getter
public class Link extends Message {

    private String url;
    private String title;
    private String description;


}