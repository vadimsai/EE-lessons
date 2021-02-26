package jms;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;


@MessageDriven(mappedName = "someQueue")  // Бин EJB, можно @inject, EntityManager и др.
public class DriverBean implements MessageListener {  // implements MessageListener и переопределяем метод onMessage

    @Inject
    JMSContext jmsContext; // для Producer в onMessage

    @Resource(name = "someQueue")
    Queue queue;    // для Producer в onMessage

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(message.getBody(String.class));  // как Consumer получаем sms

            Thread.sleep(2000);
            jmsContext.createProducer().send(queue, "SAI SAI RAM");   // можно следом положить в очередь Producer и получать sms тут же, но для этого надо @Inject JMSContext и Queue

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


