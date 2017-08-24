package pers.zhentao.zhaiyi.backend.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import pers.zhentao.zhaiyi.backend.dto.response.*;
import pers.zhentao.zhaiyi.backend.dto.response.model.Article;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangzhentao1995@163.com
 *         2017-08-24
 */
public class MessageUtil {
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    public static final String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    public static final String REQ_MESSAGE_TYPE_LINK = "link";
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    public static final String EVENT_TYPE_SCAN = "SCAN";
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    public static final String EVENT_TYPE_CLICK = "CLICK";
    public static final String EVENT_TYPE_VIEW = "VIEW";

    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";


    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        InputStream inputStream = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        inputStream.close();
        inputStream = null;
        return map;
    }

    private static XStream xStream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                boolean cdata = true;

                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    public static String messageToXml(TextMessage textMessage) {
        xStream.alias("xml", textMessage.getClass());
        return xStream.toXML(textMessage);
    }

    public static String messageToXml(ImageMessage imageMessage) {
        xStream.alias("xml", imageMessage.getClass());
        return xStream.toXML(imageMessage);
    }

    public static String messageToXml(VoiceMessage voiceMessage) {
        xStream.alias("xml", voiceMessage.getClass());
        return xStream.toXML(voiceMessage);
    }

    public static String messageToXml(VideoMessage videoMessage) {
        xStream.alias("xml", videoMessage.getClass());
        return xStream.toXML(videoMessage);
    }

    public static String messageToXml(MusicMessage musicMessage) {
        xStream.alias("xml", musicMessage.getClass());
        return xStream.toXML(musicMessage);
    }

    public static String messageToXml(NewsMessage newsMessage) {
        xStream.alias("xml", newsMessage.getClass());
        xStream.alias("item",new Article().getClass());
        return xStream.toXML(newsMessage);
    }

}
