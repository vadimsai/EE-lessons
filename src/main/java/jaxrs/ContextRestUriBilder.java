package jaxrs;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Providers;

@Path("/Context")
public class ContextRestUriBilder {
    public static void main(String[] args) {
        System.out.println(UriBuilder.fromUri("http://localhost:8080/EEjms_war_exploded").path("Context").matrixParam("one","two").queryParam("three","four").toTemplate());
           // получим  http://localhost:8080/EEjms_war_exploded/Context;one=two?three=four
    }

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes("text/html")
    public String sai(@Context HttpHeaders httpHeaders, @Context Request request, @Context Providers providers, @Context SecurityContext securityContext)
    {
        return uriInfo.getAbsolutePath().toString();  // получим   http://localhost:8080/EEjms_war_exploded/Context
    }
}
