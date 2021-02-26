package sockets;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;


// через  websocket.html


public class ProgrammaticSocket{ //extends Endpoint {    // через  websocket.html
  /*  @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String sa) {
                try {
                    session.getBasicRemote().sendText("This is my ProgrammaticSocket "+sa);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
}
