package itdvn.xmlparsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import itdvn.xmlparsing.jaxbxml.Book;
import itdvn.xmlparsing.jaxbxml.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ParsMainXml {


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException, JAXBException, XMLStreamException {


    // STAX parser записываем в консоль (каждой командой)
        XMLOutputFactory outputFactory=XMLOutputFactory.newInstance();
        XMLStreamWriter writer=outputFactory.createXMLStreamWriter(System.out);

        writer.writeStartDocument("1.0");
        writer.writeStartElement("catalog");
        writer.writeStartElement("book");
        writer.writeStartElement("author");
        writer.writeCharacters("SAI");
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();


   // JAXB (из классов создаем xml и считываем с файла)
      // в терминале переходим в пакет со считываемым файлом и прописываем команду: xjc -p jaxbxml book.xsd
      // где xjc это прог в java/jdk/bin, которая создает классы из book.xsd
// JAXB (из классов создаем xml и считываем с файла)
        Catalog catalog=new Catalog();
        catalog.addBooks(new Book("SAI","AUM",777,new Date()));
        catalog.addBooks(new Book("RAM","SHRI",999,new Date()));

        File file2=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\xmlparsing\\jaxbxml\\jaxb.xml");
        JAXBContext jaxbContext=JAXBContext.newInstance(Catalog.class);
        Marshaller marshaller=jaxbContext.createMarshaller();// объект класса Marshaller, чтобы трансформировать
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true); // читабильное форматирование
        marshaller.marshal(catalog,file2); // Записываем в файл
        marshaller.marshal(catalog,System.out);// Записываем в консоль

        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller(); // Читаем из файла
        catalog= (Catalog) unmarshaller.unmarshal(file2);
        System.out.println("JAXB Unmarshaller: "+catalog+"\n");




    // SAX ПАРСЕР(Большие файлы)
        File file1=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\xmlparsing\\book.xml");
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        SAXParser saxParser=saxParserFactory.newSAXParser();
        DefaultHandler defaultHandler=new DefaultHandler() {
            boolean book = false;

            @Override // вызывается когда SAXParser натыкается на начало тега
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("author")) // если имя тега book, то тег начался
                {
                    book=true;
                }
            }

            @Override// вызывается когда SAXParser считывает текст между тегами
            public void characters(char[] ch, int start, int length) throws SAXException {

                if (book) // Если отметили что имя тега book, то считываем текст
                {
                    System.out.println("SAX: "+new String(ch,start,length)+"\n");
                    book=false;
                }
            }
        };
        saxParser.parse(file1,defaultHandler);








     // DOM  Создание xml файла (в памяти создает структуру(Бинарное дерево, Node) и потом пишет )
        // Удобен с маленькими файлами
        DocumentBuilderFactory builderFactory1=DocumentBuilderFactory.newInstance();  //т.к. абстрактный класс и не можем создать объект через new, то newInstance()
        DocumentBuilder documentBuilder1=builderFactory1.newDocumentBuilder();
        Document document1=documentBuilder1.newDocument();// создаем чистый документ
        Element root1=document1.createElement("catalog"); // создаем Корневой элемент
        document1.appendChild(root1); // добавляем в документ
        Element book=document1.createElement("book"); // создали book
        root1.appendChild(book); // добавляем к Корневому тегу-тег дочерний(book)
        Element author=document1.createElement("author");
        author.setTextContent("SAI"); // записываем текст тега
        book.appendChild(author);

        Element book2=document1.createElement("book2"); // создали book2
        root1.appendChild(book2); // добавляем к Корневому тегу-тег дочерний(book2)
        Element author2=document1.createElement("author2");
        author2.setTextContent("AUM");
        book2.appendChild(author2);

        TransformerFactory transformerFactory=TransformerFactory.newInstance(); // берут данные и трансформируют
        Transformer transformer=transformerFactory.newTransformer();
        DOMSource source=new DOMSource(document1); // input - output (записываем в буфер, вроде)
        StreamResult streamResult=new StreamResult(new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\xmlparsing\\createdom.xml"));
        transformer.transform(source,streamResult);





    // DOM ПАРСЕР (Парсит как Бинарное Дерево, где Node-узлы с дочерними элементами )
        File file=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\xmlparsing\\book.xml");
        DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();  //т.к. абстрактный класс и не можем создать объект через new, то newInstance()
        DocumentBuilder documentBuilder=builderFactory.newDocumentBuilder();
        Document document=documentBuilder.parse(file);// парсим Builder и получаем Document
        Element root=document.getDocumentElement(); // получаем КОРНЕВОЙ элемент
        NodeList nodeList=root.getChildNodes(); // получаем все элементы(бинарное дерево)
        for (int i=0;i<nodeList.getLength();i++)
        {
            Node node=nodeList.item(i); // item-получаем элемент, Получаем Узел
            if (node.getNodeType()==Node.ELEMENT_NODE)  // Если Узел является дочерним элементом (book - например)
            {
                Element element= (Element) node;
                System.out.println("DOM: "+element.getElementsByTagName("author").item(0).getChildNodes().item(0).getNodeValue()); // есть ли дочерние элементы и значение получаем
                System.out.println("DOM: "+element.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue()+"\n");
            }
        }





    // Самописный парсер
        SAmopisParsxml sAmopisParsxml=new SAmopisParsxml("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\xmlparsing\\book.xml");
        String value=sAmopisParsxml.getPage("catalog/book/author"); // сначала считали catalog потом book и потом получаем author
        System.out.println("SAMOPIS: "+value); // Bruce Eckel
    }


}
