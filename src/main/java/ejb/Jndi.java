package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.interceptor.AroundTimeout;
import javax.interceptor.InvocationContext;


@Singleton //и @Stateless есть методы @PostConstruct и @PreDestroy
//@Stateful // есть+ методы @PrePassivate(сохранит) и @PostActivate(востановит) и @Remove, т.к. хранит состояние сессии между запусками в контейнере
         // если контейнер почувствует, что память для хранения заканчивается, то вызовет @PrePassivate(сохранит) и @PostActivate(востановит)
public class Jndi {

    public String getName()
    {
        return "SAI";
    }

    @PostConstruct
    public void postCon()
    {
        System.out.println("POST CONSTRUCT");
    }

    @PreDestroy
    public void preDestroy()
    {
        System.out.println("DESTROY");
    }


    @PrePassivate
    public void prePassiv()
    {
        System.out.println("PrePassivate");
    }

    @PostActivate
    public void postActivate()
    {
        System.out.println("PostActivate");
    }

    @Remove
    public void remove()
    {
        System.out.println("Remove");
    }

    @Schedule(hour = "*",minute = "*", second = "*",persistent = false) // запускает метод каждую секунду, persistent = false после выключения сервера и включения сохренит запучк в назначенное время
    public void printMesage()
    {
        System.out.println("Hello SAI RAM");
    }

    @Resource
    TimerService timerService;

    public String getAum()  // при вызове этого метода- сработает таймер и выведет в методе getBaba
    {
        ScheduleExpression scheduleExpression= new ScheduleExpression().hour("*").minute("*").second("*"); // создаем таймер
        timerService.createCalendarTimer(scheduleExpression, new TimerConfig("Babadgi AUM",false)); // что делает
        return "AUM";
    }

    @Timeout
    public void getBaba(Timer timer)
    {
        System.out.println(timer.getInfo());
    }


    @AroundTimeout              // Вызывает до работы таймера и после работы таймера
    Object arrTim(InvocationContext context) throws Exception {
        System.out.println( "time befor");
        Object proceed= context.proceed();
        System.out.println("time after");
        return proceed;
    }


}
