package jaxws;



import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


// ВЕБ СЕРВИС


//@SOAPBinding(style = SOAPBinding.Style.RPC,use = SOAPBinding.Use.LITERAL)  // можем менять RPC и LITERAL формат в wsdl
@WebService(endpointInterface = "jaxws.InterSoapSAI") // "jaxws.InterSoapSAI" указываем интерфейс, "Soap" можем менять имя сервиса по умолчанию SoapService
public class Soap {

    @Resource
    WebServiceContext webServiceContext;

    @WebResult  // можем менять name, targetNamespace и др. в wsdl
    public  String saiRam()
    {
        // Получаем IP и др. клиентской машины
        HttpServletRequest request = (HttpServletRequest)webServiceContext.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        System.out.println( "IP: "+request.getRemoteAddr()+", Port: "+request.getRemotePort()+", Host: "+request.getRemoteHost());

        return "SAI RAM";
    }

    @WebMethod(exclude = true)  // не видно метод в wsdl, soap не сможет его дернуть (exclude = true)
    public  String babadgiRam()
    {
        System.out.println(webServiceContext.getMessageContext());

        return "BABA RAM";
    }



    /*
    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8080/EEjms_war_exploded/Soap",new Soap());
    }
    */

}
