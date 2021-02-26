package sockets;

// Класс конфигуратор  через  websocket.html

public class  ConfigEndpointSocret{} /*implements ServerApplicationConfig {   // через  websocket.html
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
        Set<ServerEndpointConfig> result=new HashSet<>();
        for (Class e: set){
            if(e.equals(ProgrammaticSocket.class)){
                ServerEndpointConfig sec = ServerEndpointConfig.Builder.create( e ,"/echo").build();
                result.add(sec);
            }
            if(e.equals(WebSocketEcho.class)){
                ServerEndpointConfig sec = ServerEndpointConfig.Builder.create( e ,"/echoMessage").build();
                result.add(sec);
            }
        }

        return  result;
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
        return null;
    }
 }*/
