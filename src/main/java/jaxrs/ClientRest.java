package jaxrs;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;


public class ClientRest {
    public static void main(String[] args) throws URISyntaxException {
        Client client= ClientBuilder.newClient();
        URI uri=new URI("http://localhost:8080/EEjms_war_exploded/Rest");
        WebTarget target=client.target(uri);
        Invocation invocation=target.request().buildPost(Entity.text("AUM"));  // buildGet();
        // меняем и добавляем параметры в браузерной строке  http://localhost:8080/EEjms_war_exploded/Rest/777?one=two;three=four  и в request(MediaType.APPLICATION_ATOM_XML_TYPE) maim тип
        // Invocation invocation=target.path("SHRI").resolveTemplate("SHRI",777).queryParam("one","two").matrixParam("three","four")request(MediaType.APPLICATION_ATOM_XML_TYPE).buildPost(Entity.text("AUM"));
        Response response=invocation.invoke();
        if(response.getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode())
        {
            System.out.println(response.readEntity(String.class));
        }

        System.out.println(client.target(uri).request().get(String.class));  // получаем в одну строчку

        client.close();

    }
}
