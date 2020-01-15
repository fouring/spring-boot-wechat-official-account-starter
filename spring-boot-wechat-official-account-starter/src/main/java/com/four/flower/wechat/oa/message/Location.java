package com.four.flower.wechat.oa.message;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiejing
 * @date 2020-01-15 15:40
 **/
@Setter
@Getter
public class Location extends Message{

    private String scale;
    private String label;
    private String location_X;
    private String location_Y;

}