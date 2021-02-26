package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup  // + @Singleton запустит бин первым при запуске контейнера
@DependsOn("SecondBean")  // запустится самым первым- SecondBean, а FirstBean после него
public class FirstBean {

    @PostConstruct
    public void postConstruct()
    {
        System.out.println("FirstBean");
    }
}
