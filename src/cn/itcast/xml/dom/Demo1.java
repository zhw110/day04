package cn.itcast.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

//ʹ��DOM����������XML�ļ�
public class Demo1 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder domParser = factory.newDocumentBuilder();
		Document document = domParser.parse(new File("src/cn/itcast/xml/dom/car.xml"));
		Element rootElement  = document.getDocumentElement();
		System.out.println("��Ԫ��Ϊ��"+rootElement.getNodeName());
		NodeList nodeList = rootElement.getElementsByTagName("����");
		System.out.println("���У�" + nodeList.getLength()+"������");
		System.out.println("++++++++++++++++++++++++++");
		for(int i=0;i<nodeList.getLength();i++){
			Element element = (Element) nodeList.item(i);
			String band = element.getElementsByTagName("����").item(0).getTextContent();
			String place = element.getElementsByTagName("����").item(0).getTextContent();
			String price = element.getElementsByTagName("����").item(0).getTextContent();
			String time = element.getElementsByTagName("����").item(0).getAttributes().getNamedItem("����ʱ��").getTextContent();		
			
			System.out.println("���ƣ�" + band);
			System.out.println("���أ�" + place);
			System.out.println("���ۣ�" + price);
			System.out.println("����ʱ�䣺" + time);
			System.out.println("-------------------------");
		}
	}
}




