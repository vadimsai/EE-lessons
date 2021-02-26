package ejb;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletEjb" )
public class ServletEjb extends HttpServlet {
  /*  @EJB
    Ejb ejb;

    @EJB
    LocalRemouteInterface localRemouteInterface;

    @EJB
    LcalRemouteBean lcalRemouteBean;*/

  //  @EJB
  //  Mnogopot mnogopot;

  //  @EJB
  //  AsynchronBean asynchronBean;


//    @EJB
//    Jndi jndi;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       /* response.getWriter().write(ejb.getI() + 1 + " ");
        ejb.setI(ejb.getI() + 1);*/


                                   // @LocalBean + @Local(LocalRemouteInterface.class)+ @Remote
      /*
        response.getWriter().write(localRemouteInterface.getName());
       // response.getWriter().write(lcalRemouteBean.getName()+" "+lcalRemouteBean.getSurname()); // на бине не сможем вызвать без @LocalBean
        response.getWriter().write(localRemouteInterface.getName()+"----"+lcalRemouteBean.getNane()+" "+lcalRemouteBean.getSurname());  // @LocalBean + @Local(LocalRemouteInterface.class)

       */




                            // Цепочки бинов (@Startup, @DependsOn("SecondBean") даже без создания бина)



                            // Многопоточность ( EJB потокобезопасный класс(поместить в него код), но можно вручную, регулировать это )
                           // нет соединения в main?

        //response.getWriter().write(mnogopot.setI(mnogopot.getI() + 1) + " ");
       // response.getWriter().write(mnogopot.create() + " ");


                           // В EJB бины можно внедрять обычные бины, сервисы, JPA



                         // Асинхронные бины (без синхронизации, бывает она не нужна, 1сразу, 2позже)


/*
        //    asynchronBean.getName(); // выполнится через время
        //   response.getWriter().write("SAI"); // выполнится сразу, независимо

        Future<String> myname=asynchronBean.getMyName();// получаем возвращаемое значение
        try {
            response.getWriter().write(myname.get()); // response-выполнится сразу, а myname.get()-через время
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
*/

                                //JNDI ( интерфейс который позволяет ставить соответствие объектам-именам)
                                // в памяти- есть объект и есть имя, JNDI связывает их

        // java: [scope(global,app(EEejb),module(ejb))]  app-name / module-name / bean-name

/*
        //получаем бин из области видимости
        try {
            InitialContext initialContext=new InitialContext(); // JNDI
            Jndi jndi= (Jndi) initialContext.lookup("java:module/Jndi");
            response.getWriter().write(jndi.getName());

        } catch (NamingException e) {
            e.printStackTrace();
        }
*/



                                     // Жизненный цикл EJB бинов (для @Stateless и @Singleton--@PostConstruct и @PreDestroy
                                                                 // для @Stateful-- @PrePassivate и @PostActivate)


       // jndi.getName();


                                    // TIME Service (@Schedule устанавливаем время вызова метода (в Jndi классе) + TimerService и ScheduleExpression и Timer )

//        response.getWriter().write(jndi.getAum()); // при вызове метода- начнет работу Timer + @AroundTimeout



                                   // Аутентификация ( вернуться XML + Tomcat)

    }



/*
//запуск в майн методе EJB бинов (не видит сервлет ServletEjb)

public static void main(String[] args) throws NamingException
{
    EJBContainer ejbContainer=EJBContainer.createEJBContainer();
    Jndi jndi= (Jndi) ejbContainer.getContext().lookup("java:module/Jndi");
    System.out.println(jndi.getName());

}
*/





/*
    public static void main(String[] args) {

            for (int i = 0; i <= 1000; i++) {
                new Thread() {
                    @Override
                    public void run() {

                        URLConnection connection = null;
                        try {
                            connection = new URL("http://localhost:8080/EEejb_war_exploded/ServletEjb").openConnection();


                           Scanner scanner=new Scanner(connection.getInputStream());
                            while (scanner.hasNext())
                            {
                                System.out.println(scanner.next());
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        }*/
}

