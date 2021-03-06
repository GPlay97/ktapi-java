package de._125m125.kt.ktapi.websocket.events;

import de._125m125.kt.ktapi.websocket.requests.RequestMessage;

public class AfterMessageSendEvent extends WebsocketEvent {

    private final RequestMessage requestMessage;

    public AfterMessageSendEvent(final WebsocketStatus websocketStatus, final RequestMessage requestMessage) {
        super(websocketStatus);
        this.requestMessage = requestMessage;
    }

    public RequestMessage getRequestMessage() {
        return requestMessage;
    }

}
