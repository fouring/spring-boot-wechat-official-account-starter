package com.four.flower.wechat.oa.response;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiejing
 * @date 2020-01-09 17:30
 **/
@Setter
@Getter
@JSONType(naming = PropertyNamingStrategy.SnakeCase)
public class TokenResult {

    private Integer expiresIn;
    private String accessToken;

}