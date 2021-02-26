package jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


// Ошибки возвращаемые пользователю в REST

@Path("/Exception")
public class ExceptionsRest {


    @GET
    @Produces("text/plain")  // то что производим, отдаем
    //  @Consumes("text/html")  // то что получаем
    public String aum()
    {
      //  new WebApplicationException()    // специально для REST
      //  new ForbiddenException()
      //  new NotFoundException()
      //  new NotAllowedException()
      //  new NotAcceptableException()
        throw new BadRequestException(" Bad error ");  // пустая страница, но статус 400 вернет
    }

    @POST
    @Produces("text/plain")  // то что производим, отдаем
    //  @Consumes("text/html")  // то что получаем
    public String sai()
    {
        throw new RuntimeException(" error ");  // создаем отдельный класс, помечаем его @Provider и там реализуем ошибку
    }                                           //  error 404
}

@Provider
class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException>   // создаем отдельный класс, помечаем его @Provider, передаем <RuntimeException> и там реализуем ошибку
{
    @Override
    public Response toResponse(RuntimeException e) {
        return Response.status(404).entity(e.getMessage()).type(MediaType.TEXT_PLAIN).build();
    }
}