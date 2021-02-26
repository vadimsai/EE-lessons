package ejb;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class SecondBean {
    @PostConstruct
    public void postConstruct()
    {
        System.out.println("SecondBean");
    }
}
