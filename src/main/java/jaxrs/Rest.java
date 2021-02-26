package jaxrs;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


// REST ВЕБ сервис

// http://localhost:8080/EEjms_war_exploded/Rest?_wadl&type=xml  получим аналог wsdl

@Path("/Rest") // имя сервиса  http://localhost:8080/EEjms_war_exploded/Rest
public class Rest implements Inter {

    @GET
    @Produces("text/plain")  // то что производим, отдаем
  //  @Consumes("text/html")  // то что получаем
   public String sai()
   {
       return "SAI RAM";
   }

   @POST
 //  @Path("/post")
   @Produces("text/plain")
    public String baba()
    {
        return "BABADGi AUM";
    }



    @GET
    @Path("/inter")
    @Override
    @Produces("text/plain")
    public String del() {
        return "BABADGi AUM";
    }
}
