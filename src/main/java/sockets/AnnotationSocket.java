package sockets;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;


//@ServerEndpoint("/MySocketServer")  // класс является конечной точкой веб-сокета
public class AnnotationSocket {

   /* @OnMessage   // " This is my AnnotationSocket "
    public void message(Session session, String msg) throws IOException  // через websocket.html
    {
        session.getBasicRemote().sendText(" This is my AnnotationSocket " + msg);  // msg = WebSocket rocks в websocket.html
    }*/
}
