package jaxrs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


// запись XML в файл и чтение из файла, класс Students должен быть помечен @XmlRootElement и его методы @XmlElement


public class Jaxb {
    public static void main(String[] args) throws JAXBException {

       Students students=new Students("SAI RAM","777");
       File file=new File("G:/file.xml");
        JAXBContext context=JAXBContext.newInstance(Students.class);

           // запись XML в файл
        Marshaller marshaller=context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  // сохраняют структуру Xml, без него в одну строку
        marshaller.marshal(students, file);
        marshaller.marshal(students,System.out);  // вывод в консоль

/*         // чтение из XML файла
        Unmarshaller unmarshaller=context.createUnmarshaller();
        students= (Students) unmarshaller.unmarshal(file);
        System.out.println(students.id);
        System.out.println(students.age);
        System.out.println(students.name);;
*/

    }
}
