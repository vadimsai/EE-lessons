package jaxrs;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


// создаем в своем формате  class ReaderMyFormat(отдаем)  и  class WriterMyFormat implements(получаем)

@Path("/Format")
public class MyFormatRest {

    @GET                      // http://localhost:8080/EEjms_war_exploded/Format    получаем   my/format(SAI/777)
    @Produces("my/format")   // отдаем клиенту в своем формате, через "/"
    public Students sai()
    {
        return new Students("SAI","777");
    }

    @POST
    @Consumes("my/format")
    @Path("/getName")          // http://localhost:8080/EEjms_war_exploded/Format/getName   +  my/format(SAI/777) отправляет клиент
    @Produces(MediaType.TEXT_PLAIN)
    public String saiAum(Students students)  // получаем из текста клиента
    {
        return students.getName();
    }
}
