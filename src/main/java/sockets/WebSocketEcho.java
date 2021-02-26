package sockets;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;


// через  websocket.html


public class WebSocketEcho{ //extends Endpoint {    // через  websocket.html
 /*   @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String s) {
                System.out.println(s);       //  WebSocket rocks
                try {
                    session.getBasicRemote().sendText("This is my WebSocketEcho "+s );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
}
