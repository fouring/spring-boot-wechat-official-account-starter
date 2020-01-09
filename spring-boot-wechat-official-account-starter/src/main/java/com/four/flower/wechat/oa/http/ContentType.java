package com.four.flower.wechat.oa.http;

import lombok.Getter;

/**
 * ContentType
 *
 * @author xiejing
 * @date 2019-12-16 12:51
 **/
public enum ContentType {

    JSON("application/json"),

    URLENCODED("application/x-www-form-urlencoded");

    @Getter
    private String value;

    ContentType(String value) {
        this.value = value;
    }
}