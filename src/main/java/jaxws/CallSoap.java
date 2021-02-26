package jaxws;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

// КЛИЕНТ SOAP получаем сообщение параметры берем из wsdl

// чтобы получить классы для java с помщью CMD и wsimport из CMD - C:\Program Files\Java\jdk1.8.0_261\bin wsimport.exe -d "C:\Users\it\IdeaProjects\Wsimport\src\main\java"
// -keep http://localhost:8080/EEjms_war_exploded/Soap?wsdl
//где место выгрузки классов C:\Users\it\IdeaProjects\Wsimport\src\main\java

public class CallSoap {
    public static void main(String[] args) throws MalformedURLException, SOAPException {

        URL url=new URL("http://localhost:8080/EE3_war_exploded/SoapService"); // host запроса
        QName qName=new QName("http://jaxws/","SoapService"); // service name="SoapinServ и targetNamespace="http://jaxws/" в wsdl
        Service service=Service.create(url,qName);
        InterSoapSAI interSoapSAI=service.getPort(InterSoapSAI.class);

        System.out.println(interSoapSAI.saiRam());




    }
}
