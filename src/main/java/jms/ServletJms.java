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


@JMSConnectionFactoryDefinition(name = "NewMyFactory")   // создаем новый ConnectionFactory без Томката и jmsContext1 и queue1
@JMSDestinationDefinition(interfaceName = "javax.jms.Queue", name = "NewMyQuery")  // создаем новый Destination без Томката jmsContext1 и queue1
@WebServlet(name = "ServletJmsProducer",urlPatterns = "/ServletJmsProducer")
public class ServletJms extends HttpServlet{
    @Inject
    @JMSConnectionFactory("NewMyFactory")  // для нового Connection
    JMSContext jmsContext1;

    @Resource(name ="NewMyQuery" )        // для нового Connection
    Queue queue1;





    @Resource            //(lookup ="openejb:Resource/MyJmsConnectionFactory" ) //+ + в Tomcat
    ConnectionFactory connectionFactory;

    @Resource(name = "someQueue")             //(lookup = "openejb:Resource/FooQueue") //+ + в Tomcat
    Queue queue;

    @Inject
     // @JMSSessionMode(JMSContext.CLIENT_ACKNOWLEDGE) // Отправляет Producer отчет о досавке
    //  @JMSPasswordCredential(userName = "advin",password = "hr")
    JMSContext jmsContext;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        try {
         /*   Context jndicont= new InitialContext();                 // без @Resource вручную + в Tomcat
            ConnectionFactory connectionFactory= (ConnectionFactory) jndicont.lookup("openejb:Resource/MyJmsConnectionFactory");
            Queue queue= (Queue) jndicont.lookup("openejb:Resource/FooQueue");

            Connection connection=connectionFactory.createConnection();
            connection.start();


            Session session= connection.createSession(false,Session.AUTO_ACKNOWLEDGE); // false- No Persistent- не сохраняет сообщение, AUTO_ACKNOWLEDGE - Producer не получает отчет о доставк сообщения Consumer
            MessageProducer producer=session.createProducer(queue);
            Message message=session.createTextMessage("message was sent"+ new Date());
            producer.send(message);


        } catch ( JMSException e) {
            e.printStackTrace();
        }
*/


                                    // Simple Api ( уменьшим код)

      /*  jmsContext.createProducer().send(queue,"message was sent"+ new Date());
        jmsContext.createConsumer(queue).setMessageListener(new MessageListener()  // без Consumer сразу обрабатывает сообщения отправленные Producer, работает Асинхронно(сразу много оброботает смс)
        {
            @Override
            public void onMessage(Message message) {
                try {
                    System.out.println(message.getJMSMessageID());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

                                // передаем объект Student

 /*
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "*");  // для передачи объктов SERIALIZABLE всех классов ("*")

        jmsContext.createProducer().send(queue, new Student("SAI"));
     //   Student student = jmsContext.createConsumer(queue).receiveBody(Student.class);
     //   response.getWriter().write(student.name);

  */


                              // Advansed for future (примеры)

/*
      jmsContext.createProducer().setPriority(2).send(queue,"SAI hello"); // Приоритет вывода, но в Tomcat может не работать, надо проверять
      jmsContext.createProducer().setPriority(3).send(queue,"BBADGI hi");
      jmsContext.createProducer().setPriority(1).send(queue, "AUM");
*/

/*
        jmsContext.createProducer().setTimeToLive(1000).send(queue,"SAI hello"); // Время существования sms
        jmsContext.createProducer().setTimeToLive(1).send(queue,"BABADGI hello");
        jmsContext.createProducer().setTimeToLive(1000).send(queue, "AUM");

     //  JMSConsumer consumer=jmsContext.createConsumer(queue);
     //   System.out.println(consumer.receiveBody(String.class));
     //   System.out.println(consumer.receiveBody(String.class));
     //   System.out.println(consumer.receiveBody(String.class));
*/

/*
        jmsContext.createProducer().setPriority(2).setProperty("Filter", 2).send(queue,"SAI hello"); // Фильтр sms по setProperty или setPriority
        jmsContext.createProducer().setPriority(3).setProperty("Filter", 1).send(queue,"BABADGI hi");
        jmsContext.createProducer().setPriority(1).setProperty("Filter", 3).send(queue, "AUM");

       // JMSConsumer consumer=jmsContext.createConsumer(queue, "JMSPriority >1");
       // JMSConsumer consumer=jmsContext.createConsumer(queue, "Filter >1");
       // System.out.println(consumer.receiveBody(String.class));
       // System.out.println(consumer.receiveBody(String.class));
       // System.out.println(consumer.receiveBody(String.class));

 */

     //   System.out.println(consumer.receive().acknowledge()); // Отправляет Producer отчет о досавке + @JMSSessionMode(JMSContext.CLIENT_ACKNOWLEDGE)
    //  jmsContext.createDurableConsumer(Topic, "durablesms").receiveBody(String.class);  // Только с Topic, если кто не получил sms, то повторно отправит



                                             // @MessageDriven (Бин EJB)

       // jmsContext.createProducer().send(queue, "AUM");



                                        //FactoryDefinition ( создаем новое подключение jms)

     //   jmsContext1.createProducer().send(queue1, "AUM");

    }
}


