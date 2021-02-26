package jaxrs;


import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces("my/format")  // получаем в своем формате  (SAI/777)
public class WriterMyFormat implements MessageBodyWriter<Students> {

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return Students.class.isAssignableFrom(aClass);
    }

    @Override
    public void writeTo(Students students, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {

        outputStream.write(students.getName().getBytes());
        outputStream.write('/');           // добавляем "/"
        outputStream.write(students.getAge().getBytes());
    }

    @Override
    public long getSize(Students students, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return students.getName().length()+1+students.getAge().length();
    }
}
