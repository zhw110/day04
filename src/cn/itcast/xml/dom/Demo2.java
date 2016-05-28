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
	//dom是否将空白字符当作一个有效的元素对待
	public static void main(String[] args) throws Exception{
		Document document = getDocument();
		Element rootElement = document.getDocumentElement();
		NodeList nodeList = rootElement.getChildNodes();
		System.out.println("共有" + nodeList.getLength()+"个直接元素");
	}
	@Test
	public void create() throws Exception{
		Document document = getDocument();
		Element newCarElement = document.createElement("汽车");
		newCarElement.setTextContent("我的汽车");
		Element rootElement = document.getDocumentElement();
		//rootElement.appendChild(newCarElement);
		rootElement.insertBefore(
				newCarElement,
				rootElement.getElementsByTagName("汽车").item(1));
		write2xml(document);
	}
	@Test
	public void update() throws Exception{
		Document document = getDocument();
		Element secondCarElement = (Element) document.getElementsByTagName("汽车").item(1);
		secondCarElement.getElementsByTagName("产地").item(0).setTextContent("深圳");
		secondCarElement.getElementsByTagName("车牌").item(0).getAttributes().getNamedItem("出产时间").setTextContent("2012年");
		write2xml(document);
	}
	@Test
	public void delete() throws Exception{
		Document document = getDocument();
		Element rootElement = document.getDocumentElement();
		Element secondCarElement = (Element) rootElement.getElementsByTagName("汽车").item(1);
		rootElement.removeChild(secondCarElement);
		write2xml(document);
	}
	private void write2xml(Document document)throws Exception {
		//将内存中的document对象写到外存的xml文件
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		//源
		Source source = new DOMSource(document);
		//目
		Result result = new StreamResult(new File("src/cn/itcast/xml/dom/car.xml"));
		transformer.transform(source,result);
	}
	private static Document getDocument() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//设置dom解析器将空白字符过滤
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder domParser = factory.newDocumentBuilder();
		Document document = domParser.parse(new File("src/cn/itcast/xml/dom/car.xml"));
		return document;
	}
}






