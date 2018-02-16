



import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SAXXMLTest {
    /**
     * sax解析XML文档
     */
    public static void main(String[] args) throws Exception {
        // 1. 创建解析工厂CHCP 65001
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2. 得到解析器
        SAXParser saxParser = factory.newSAXParser();
        // 3. 得到读取器
        XMLReader reader = saxParser.getXMLReader();
        // 4. 设置内容处理器
        reader.setContentHandler(new TagValueHandler());
        // 5. 读取XML文档内容
        reader.parse("city.xml");
    }
}

// 得到XML文档所有的东西
class ListHandler implements ContentHandler {
    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes atts)
            throws org.xml.sax.SAXException {
        // System.out.println("<" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        System.out.println(new String(ch, start, length));

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        System.out.println("</" + qName + ">");
    }
    @Override
    public void skippedEntity(String name) throws SAXException {
        
    }
    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        
    }
    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        
    }
    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        
    }
    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        
    }
    @Override
    public void endDocument() throws SAXException {
        
    }
    @Override
    public void startDocument() throws SAXException {
        
    }
    @Override
    public void setDocumentLocator(Locator locator) {
        
    }
}

class TagValueHandler extends DefaultHandler {
    private String current; // 记住当前解析的标签
    private int needNumber = 1; // 想获取第几个标签得值
    private int currentNumber = 0;  // 当前是第几个标签
    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes atts)
            throws org.xml.sax.SAXException {
        // System.out.println("<" + qName + ">");
        current = qName;
        if (qName.equals("描述")) {
            currentNumber++;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        // System.out.println(new String(ch, start, length));
        if ("描述".equals(current) && currentNumber == needNumber) {
            System.out.println(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        // System.out.println("</" + qName + ">");
        current = null;
    }

}