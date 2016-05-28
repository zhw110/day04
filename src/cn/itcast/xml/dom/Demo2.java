package cn.itcast.xml.dom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Demo2 {
	//dom�Ƿ񽫿հ��ַ�����һ����Ч��Ԫ�ضԴ�
	public static void main(String[] args) throws Exception{
		Document document = getDocument();
		Element rootElement = document.getDocumentElement();
		NodeList nodeList = rootElement.getChildNodes();
		System.out.println("����" + nodeList.getLength()+"��ֱ��Ԫ��");
	}
	@Test
	public void create() throws Exception{
		Document document = getDocument();
		Element newCarElement = document.createElement("����");
		newCarElement.setTextContent("�ҵ�����");
		Element rootElement = document.getDocumentElement();
		//rootElement.appendChild(newCarElement);
		rootElement.insertBefore(
				newCarElement,
				rootElement.getElementsByTagName("����").item(1));
		write2xml(document);
	}
	@Test
	public void update() throws Exception{
		Document document = getDocument();
		Element secondCarElement = (Element) document.getElementsByTagName("����").item(1);
		secondCarElement.getElementsByTagName("����").item(0).setTextContent("����");
		secondCarElement.getElementsByTagName("����").item(0).getAttributes().getNamedItem("����ʱ��").setTextContent("2012��");
		write2xml(document);
	}
	@Test
	public void delete() throws Exception{
		Document document = getDocument();
		Element rootElement = document.getDocumentElement();
		Element secondCarElement = (Element) rootElement.getElementsByTagName("����").item(1);
		rootElement.removeChild(secondCarElement);
		write2xml(document);
	}
	private void write2xml(Document document)throws Exception {
		//���ڴ��е�document����д������xml�ļ�
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		//Դ
		Source source = new DOMSource(document);
		//Ŀ
		Result result = new StreamResult(new File("src/cn/itcast/xml/dom/car.xml"));
		transformer.transform(source,result);
	}
	private static Document getDocument() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//����dom���������հ��ַ�����
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder domParser = factory.newDocumentBuilder();
		Document document = domParser.parse(new File("src/cn/itcast/xml/dom/car.xml"));
		return document;
	}
}






