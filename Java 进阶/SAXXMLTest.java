



import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SAXXMLTest {
    /**
     * sax����XML�ĵ�
     */
    public static void main(String[] args) throws Exception {
        // 1. ������������CHCP 65001
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2. �õ�������
        SAXParser saxParser = factory.newSAXParser();
        // 3. �õ���ȡ��
        XMLReader reader = saxParser.getXMLReader();
        // 4. �������ݴ�����
        reader.setContentHandler(new TagValueHandler());
        // 5. ��ȡXML�ĵ�����
        reader.parse("city.xml");
    }
}

// �õ�XML�ĵ����еĶ���
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
    private String current; // ��ס��ǰ�����ı�ǩ
    private int needNumber = 1; // ���ȡ�ڼ�����ǩ��ֵ
    private int currentNumber = 0;  // ��ǰ�ǵڼ�����ǩ
    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes atts)
            throws org.xml.sax.SAXException {
        // System.out.println("<" + qName + ">");
        current = qName;
        if (qName.equals("����")) {
            currentNumber++;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        // System.out.println(new String(ch, start, length));
        if ("����".equals(current) && currentNumber == needNumber) {
            System.out.println(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        // System.out.println("</" + qName + ">");
        current = null;
    }

}