package com.four.flower.wechat.oa.message;

import com.four.flower.wechat.oa.type.MsgType;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author xiejing
 * @date 2020-01-15 15:27
 **/
@Setter
@Getter
@XmlRootElement
public class Message {

    protected String  msgId;
    protected MsgType msgType;
    protected String  toUserName;
    protected String  fromUserName;
    protected String  createTime;

}