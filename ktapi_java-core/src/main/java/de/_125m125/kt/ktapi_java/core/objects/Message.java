package de._125m125.kt.ktapi_java.core.objects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    private String                   timestamp;
    private String                   message;

    public Message() {
        super();
    }

    public Message(final String timestamp, final String message) {
        super();
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public LocalDateTime getTime() {
        return LocalDateTime.parse(this.timestamp, Message.FORMATTER);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Message [timestamp=");
        builder.append(this.timestamp);
        builder.append(", message=");
        builder.append(this.message);
        builder.append("]");
        return builder.toString();
    }
}