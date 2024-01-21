package com.users.webapi.controllers.ws;

import com.users.webapi.contract.ws.ChatMessage;
import com.users.webapi.services.security.RandomUserDetails;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {

    /**
     * @MessageMapping("/chat"): Ta adnotacja określa,
     * że metoda receiveMessage będzie obsługiwała wiadomości wysyłane do destynacji STOMP o nazwie /chat.
     * Innymi słowy, kiedy klient (np. przeglądarka internetowa) wysyła wiadomość do endpointu /app/chat
     * (pamiętaj o prefiksie /app skonfigurowanym wcześniej), ta metoda zostanie wywołana.
     */
    //@MessageMapping("/chat")

    /**
     * @SendTo("/queue/messages"): Po przetworzeniu wiadomości przez metodę receiveMessage,
     * wynikowy obiekt ChatMessage zostanie przekazany do wszystkich klientów,
     * którzy subskrybują destynację /queue/messages.
     * Jest to sposób na rozgłaszanie wiadomości do wszystkich użytkowników
     * (lub określonej grupy użytkowników),
     * którzy nasłuchują na tej destynacji.
     */
    //@SendTo("/queue/messages")
    public ChatMessage receiveMessage(Principal principal, ChatMessage message) {
        message.setMessage(principal.getName()+": "+message.getMessage());
        return message;
    }
}

