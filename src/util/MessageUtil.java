package util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import pojo.TextMessage;


public class MessageUtil {
	
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "click";
	public static final String MESSAGE_VIEW = "view";
	
	/**
	 * xmlת��map����
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		ServletInputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	/**
	 * ���ı���Ϣת��Ϊxml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
	}
	
	
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return MessageUtil.textMessageToXml(text);
	}
	
	
	/**
	 * ���˵�
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("��ӭ��ע Little Lovely Turtle,�밴����ʾ���в���:\n\n");
		sb.append("1�����ĺŽ���\n");
		sb.append("2��С�ڹ�\n");
		sb.append("�ظ� ? �����˲˵�");
		return sb.toString();
	}
	
	/**
	 * firstMenu
	 * @return
	 */
	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("΢�Ŷ��ĺ� Little Lovely Turtle(С�ȹ�)\n");
		sb.append("author:wangwenjie666\n");
		return sb.toString();
	}
	
	/**
	 * secondMenu
	 * @return
	 */
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("С�ڹ�����");
		return sb.toString();
	}
	
}



































