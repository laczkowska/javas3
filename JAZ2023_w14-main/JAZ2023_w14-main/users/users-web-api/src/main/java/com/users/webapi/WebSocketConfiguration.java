package com.users.webapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    /**
     * registerStompEndpoints: Określa endpoint /messages, do którego będą się łączyć klienci (frontend).
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/messages");
    }


    /**
     * configureMessageBroker: Ustawia prefixy dla kierowania wiadomości do odpowiednich miejsc.
     * Na przykład, wszystkie wiadomości wysyłane do ścieżek zaczynających się od /app
     * będą traktowane jako wiadomości do aplikacji.
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        /**
         * Ta linia określa prefiks dla destynacji, do których wiadomości są kierowane z klienta (np. przeglądarki) do serwera.
         *
         * Kiedy klient wysyła wiadomość do serwera,
         * używa on destynacji z tym prefiksem.
         * Na przykład, jeśli klient chce wysłać wiadomość do aplikacji,
         * może użyć destynacji takiej jak /app/chat.
         * Ta konfiguracja pozwala serwerowi na rozróżnienie między różnymi rodzajami akcji,
         * takimi jak wysyłanie wiadomości do aplikacji (/app)
         * a subskrybowanie tematów w brokera wiadomości (/topic lub /queue).
         */
        registry.setApplicationDestinationPrefixes("/app");

        /**
         * Ta linia konfiguruje prosty wewnętrzny broker wiadomości, który pozwala na przesyłanie wiadomości od serwera do klienta.
         *
         * Broker wiadomości używa tego prefiksu (/queue) do zarządzania subskrypcjami i przesyłaniem wiadomości do subskrybentów.
         * Na przykład, jeśli kilku użytkowników subskrybuje temat /queue/messages,
         * to każda wiadomość wysłana przez serwer do tego tematu zostanie automatycznie przekazana wszystkim subskrybentom.
         * Jest to szczególnie przydatne w aplikacjach chatu,
         * gdzie serwer musi przesyłać wiadomości do wszystkich klientów,
         * którzy subskrybowali dany temat a raczej kolejkę.
         */
        registry.enableSimpleBroker("/queue");
    }
}
