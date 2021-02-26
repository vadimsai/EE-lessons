package jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletJmsConsumer",urlPatterns = "/ServletJmsConsumer")
public class ServletJmsConsumer extends HttpServlet{
    @Inject
    @JMSConnectionFactory("NewMyFactory")  // для нового Connection
    JMSContext jmsContext1;

    @Resource(name ="NewMyQuery" )        // для нового Connection
    Queue queue1;





    @Resource                        //(lookup ="openejb:Resource/MyJmsConnectionFactory" ) //+ + в Tomcat
    ConnectionFactory connectionFactory;

    @Resource(name = "someQueue")    //(lookup = "openejb:Resource/FooQueue") //+ + в Tomcat
    Queue queue;

    @Inject
    JMSContext jmsContext;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*    try {
        /*    Context jndicont= new InitialContext();                           // без @Resource вручную + в Tomcat

            ConnectionFactory connectionFactory= (ConnectionFactory) jndicont.lookup("openejb:Resource/MyJmsConnectionFactory");
            Queue queue= (Queue) jndicont.lookup("openejb:Resource/FooQueue");

            Connection connection=connectionFactory.createConnection();
            connection.start();


            Session session= connection.createSession(false,Session.AUTO_ACKNOWLEDGE);   // false- No Persistent- не сохраняет сообщение, AUTO_ACKNOWLEDGE - Producer не получает отчет о доставк сообщения Consumer
            MessageConsumer consumer=session.createConsumer(queue);
            TextMessage message= (TextMessage) consumer.receive();
            System.out.println(message.getText());

            response.getWriter().write(message.getText());

        } catch ( JMSException e) {
            e.printStackTrace();
        }
*/


                                // Simple Api ( уменьшим код)

      //  response.getWriter().write(jmsContext.createConsumer(queue).receiveBody(String.class));




                                     // передаем объект Student
/*
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "*");  // для передачи объктов SERIALIZABLE всех классов ("*")


        Student student = jmsContext.createConsumer(queue).receiveBody(Student.class);
        response.getWriter().write(student.name);
*/


                                          // Advansed for future (примеры)


     //   JMSConsumer consumer=jmsContext.createConsumer(queue,"Filter >1");  // Фильтр

     //   response.getWriter().write(consumer.receiveBody(String.class)+"  " +consumer.receiveBody(String.class)+"  " +consumer.receiveBody(String.class));



                                            //FactoryDefinition ( создаем новое подключение jms)

     //   response.getWriter().write(jmsContext1.createConsumer(queue1).receiveBody(String.class));
    }
}
