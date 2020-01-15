package com.four.flower.wechat.oa.type;

import com.four.flower.wechat.oa.message.Image;
import com.four.flower.wechat.oa.message.Link;
import com.four.flower.wechat.oa.message.Location;
import com.four.flower.wechat.oa.message.SmallVideo;
import com.four.flower.wechat.oa.message.Text;
import com.four.flower.wechat.oa.message.Video;
import com.four.flower.wechat.oa.message.Voice;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author xiejing
 * @date 2020-01-15 15:38
 **/
public enum MsgType {

    LINK(Link.class),
    LOCATION(Location.class),
    SHORTVIDEO(SmallVideo.class),
    VIDEO(Video.class),
    VOICE(Voice.class),
    IMAGE(Image.class),
    TEXT(Text.class);

    @Getter
    private Class tClass;

    <T> MsgType(Class<T> tClass) {
        this.tClass = tClass;
    }

    public static <T> Class<T> getMsgClass(String xml) {
        String typeXml = "<MsgType><![CDATA[%s]]></MsgType>";
        Optional<MsgType> optional = Arrays.stream(values()).filter(type -> {
            String s = String.format(typeXml, type.name().toLowerCase());
            return xml.contains(s);
        }).findAny();
        if (optional.isPresent()) {
            return optional.get().getTClass();
        }
        throw new RuntimeException("can't find msg type");
    }


}