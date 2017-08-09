package ch17;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class EchoHandler extends TextWebSocketHandler {
    public void handlerTextMessage(WebSocketSession session, TextMessage textMessage)
        throws IOException {session.sendMessage(new TextMessage(textMessage.getPayload()));
    }
}
