package com.four.flower.wechat.oa.message;

import com.four.flower.wechat.oa.message.reader.MsgReader;
import com.four.flower.wechat.oa.type.MsgType;
import com.four.flower.wechat.oa.utils.IdMaker;
import lombok.Getter;
import lombok.Setter;


/**
 * @author xiejing
 * @date 2020-01-15 15:28
 **/
@Setter
@Getter
public class Text extends Message {

    protected String content;

    public static String makeFailure(Message message) {
        Text text = new Text();
        text.setContent("不合法的消息来源");
        text.setCreateTime(message.getCreateTime());
        text.setFromUserName(message.getToUserName());
        text.setToUserName(message.getFromUserName());
        text.setMsgId(IdMaker.getStringId());
        text.setMsgType(MsgType.text);
        return MsgReader.writer(text);
    }
}