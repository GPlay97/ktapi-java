package de._125m125.kt.ktapi.websocket.events;

public class WebsocketDisconnectedEvent extends WebsocketEvent {

    public WebsocketDisconnectedEvent(final WebsocketStatus websocketStatus) {
        super(websocketStatus);
    }

}
