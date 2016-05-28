package cn.itcast.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

//使用DOM解析器解析XML文件
public class Demo1 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder domParser = factory.newDocumentBuilder();
		Document document = domParser.parse(new File("src/cn/itcast/xml/dom/car.xml"));
		Element rootElement  = document.getDocumentElement();
		System.out.println("根元素为："+rootElement.getNodeName());
		NodeList nodeList = rootElement.getElementsByTagName("汽车");
		System.out.println("共有：" + nodeList.getLength()+"辆汽车");
		System.out.println("++++++++++++++++++++++++++");
		for(int i=0;i<nodeList.getLength();i++){
			Element element = (Element) nodeList.item(i);
			String band = element.getElementsByTagName("车牌").item(0).getTextContent();
			String place = element.getElementsByTagName("产地").item(0).getTextContent();
			String price = element.getElementsByTagName("单价").item(0).getTextContent();
			String time = element.getElementsByTagName("车牌").item(0).getAttributes().getNamedItem("出产时间").getTextContent();		
			
			System.out.println("车牌：" + band);
			System.out.println("产地：" + place);
			System.out.println("单价：" + price);
			System.out.println("出产时间：" + time);
			System.out.println("-------------------------");
		}
	}
}




