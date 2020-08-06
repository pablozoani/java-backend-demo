package com.pablozoani.z_other_oop.d_observer;

import java.time.LocalDateTime;

public class Message {

    private static long messageCounter = 0;

    private final long MESSAGE_ID = ++messageCounter;

    private final LocalDateTime creationTime = LocalDateTime.now();

    private final String text;

    private final User sender;

    private final User receiver;

    public Message(String text, User sender, User receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }

    public static long getMessageCounter() {
        return messageCounter;
    }

    public long getMESSAGE_ID() {
        return MESSAGE_ID;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return "Message = {" +
                "\n\tMESSAGE_ID = " + MESSAGE_ID +
                ",\n\tCreation Time = " + creationTime +
                ",\n\tFrom = " + sender.getFirstName() + " " + sender.getLastName() +
                ",\n\tTo = " + receiver.getFirstName() + " " + receiver.getLastName() +
                ",\n\tText = " + text +
                "\n}";
    }
}
