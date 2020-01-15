package com.four.flower.wechat.oa.message.reader;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * @author xiejing
 * @date 2020-01-15 15:59
 **/
public class MsgReader {

    private static XStream xstream;

    static {
        xstream = new XStream(new DomDriver("UTF-8", new CaseNameCoder()));
    }

    public static String writer(Object object) {
        xstream.alias("xml", object.getClass());
        return xstream.toXML(object);
    }

    @SuppressWarnings("unchecked")
    public static <T> T reader(String xml, Class<T> tClass) {
        xstream.alias("xml", tClass);
        return (T) xstream.fromXML(xml);
    }

    public static class CaseNameCoder implements NameCoder {

        @Override
        public String encodeNode(String name) {
            return name.equalsIgnoreCase("xml") ? "xml" : upperFirstChar(name);
        }

        @Override
        public String encodeAttribute(String name) {
            return encodeNode(name);
        }

        @Override
        public String decodeNode(String nodeName) {
            return lowerFirstChar(nodeName);
        }

        @Override
        public String decodeAttribute(String attributeName) {
            return lowerFirstChar(attributeName);
        }

        private String upperFirstChar(String str) {
            char[] ch = str.toCharArray();
            if (ch[0] >= 'a' && ch[0] <= 'z') {
                ch[0] = (char) (ch[0] - 32);
            }
            return new String(ch);
        }

        private String lowerFirstChar(String str) {
            char[] ch = str.toCharArray();
            if (ch[0] >= 'A' && ch[0] <= 'Z') {
                ch[0] = (char) (ch[0] + 32);
            }
            return new String(ch);
        }
    }
}