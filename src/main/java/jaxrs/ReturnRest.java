package jaxrs;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


// @Produces(MediaType.TEXT_PLAIN)
@Path("/ReturnRest")
public class ReturnRest {


    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Consumes("text/html")               // Возвращаем объект Students в XML
    public Students getStudentXml()
    {
        return new Students("SAI","777");

       /* <students id="0">
           <age>777</age>
           <name>SAI</name>
          </students>  */
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("text/html")               // Возвращаем объект Students в JSON
    public Response getStudentJson()
    {
        return Response.ok(new  Students("BABADGI", "999"), MediaType.APPLICATION_JSON).build();

        // {"age":0,"id":0,"name":"BABADGI"}   получаем JSON
    }



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes("text/html")      // Возвращаем тип  Long
    public Long sai()
    {
        return 1L; // 1
    }
}
