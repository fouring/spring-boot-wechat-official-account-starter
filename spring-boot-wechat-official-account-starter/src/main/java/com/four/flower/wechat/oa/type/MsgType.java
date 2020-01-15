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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author xiejing
 * @date 2020-01-15 15:38
 **/
public enum MsgType {

    link(Link.class),
    location(Location.class),
    shortvideo(SmallVideo.class),
    video(Video.class),
    voice(Voice.class),
    image(Image.class),
    text(Text.class);


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