package jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Scanner;
import java.util.StringTokenizer;


//

@Provider
@Consumes("my/format")    // отдаем в своем формате  (SAI/777)
public class ReaderMyFormat implements MessageBodyReader<Students> {
    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return Students.class.isAssignableFrom(aClass);
    }

    @Override
    public Students readFrom(Class<Students> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
       String str=convertStreamToString(inputStream);
        StringTokenizer s=new StringTokenizer(str,"/");
        Students students=new Students();
        students.setAge(s.nextToken());
        students.setName(s.nextToken());
        return students;

    }


    private String convertStreamToString(InputStream inputStream)
    {
        Scanner s=new Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
