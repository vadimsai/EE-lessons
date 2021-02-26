package jaxrs;


import javax.ws.rs.*;


// Передаем параметры в браузерной строке


@Path("/Parametr")
@Produces("text/plain")
public class ParametresRest {

    @GET
    @Path("/{id}")      // http://localhost:8080/EEjms_war_exploded/Parametr/979 передаем параметры в браузерной строке
    public String id(@PathParam("id") String id)  // @PathParam("id") передает параметр из @Path в метод
    {
        return "id is  "+id;  // 979
    }

    @GET
    @Path("/id/{id}")    // http://localhost:8080/EEjms_war_exploded/Parametr/id/777
    public String idParam(@PathParam("id") String id)
    {
        return "id is  "+id;  // 777
    }

    @GET
    @Path("name/{name: [a-zA-Z]*}")   // http://localhost:8080/EEjms_war_exploded/Parametr/name/SAI  регулярное выражение- имя
    public String name(@PathParam("name") String name)
    {
        return "name is  "+name;  // SAI
    }


    @GET
    @Path("/age")   // http://localhost:8080/EEjms_war_exploded/Parametr/age?userage=11111
    public String user(@QueryParam("userage") String age)  // @QueryParam параметр где ?userage=11111 (ключ=значение)
    {
        return "age is "+age;  // 11111
    }

    @GET
    @Path("/city")   // http://localhost:8080/EEjms_war_exploded/Parametr/city/;usercity=Mayami
    public String city(@DefaultValue("Moscow") @MatrixParam("usercity") String city)  // @MatrixParam параметр где ;usercity=Mayami (ключ=значение)
    {
        return "city is "+city;  // Mayami ,  по дефолту Moscow т.к. @DefaultValue("Moscow")
    }

    @GET
    @Path("/cookie")   // http://localhost:8080/EEjms_war_exploded/Parametr/cookie
    public String cookie(@DefaultValue("null") @CookieParam("cookie") String cookie)  // @CookieParam получаем cookie
    {
        return cookie;  // null
    }

    @GET
    @Path("/headers")   // http://localhost:8080/EEjms_war_exploded/Parametr/headers
    public String headerss( @HeaderParam("headers") String headers)  //
    {
        return headers;  // null ошибка
    }




    @POST     // сначала в http://localhost:8080/EEjms_war_exploded/ServletFormParams  вводим текст
    @Path("/form")   // http://localhost:8080/EEjms_war_exploded/Parametr/form
    public String form(@FormParam("getformp") String formparam)  // @FormParam параметр из формы, которая в ServletFormParams (в нем текст переходит по ссылке в данный метод)
    {
        return "param from form is "+formparam;  // param from form is hello SAI BABADGI AUM
    }

}
