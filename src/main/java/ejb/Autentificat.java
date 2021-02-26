package ejb;


/*
@Singleton
@RunAs("vadim") //  Jndi будет запускаться для этого пользователя
public class Autentificat {

    @EJB
    Jndi jndi;

    @PermitAll // разрешить всем доступ
    @DenyAll   // запретить всем
    @RolesAllowed({"root","admin"}) // разрешить 2 этим доступ к методу + tomcat + xml
    public void getName()
    {
        System.out.println("SAI");
    }


    @Resource
    SessionContext sessionContext;

    public String getNames()   // еще способ
    {
        if(sessionContext.isCallerInRole("root")) // для этого пользователя вернет AUM
        {return "AUM" ; }

        return "SAI";
    }


}
*/