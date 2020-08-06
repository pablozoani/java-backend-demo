package com.pablozoani.z_other_oop.d_observer;

import com.pablozoani.z_other_oop.reusable_entities.Person;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static com.pablozoani.utils.ConsoleColors.*;

public class User extends Person implements Sender, Receiver {

    private Set<Receiver> contacts = new HashSet<>();

    private Deque<Message> inbox = new LinkedList<>();

    private Deque<Message> loadedMessages = new LinkedList<>();

    public User(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    @Override
    public void receive(Message message) {

        System.out.println();

        System.out.println(GREEN + getFirstName() + " " + getLastName() + " has received a message" + RESET);

        inbox.addLast(message);
    }

    @Override
    public void registerReceiver(Receiver receiver) {
        contacts.add(receiver);
    }

    @Override
    public void unregisterReceiver(Receiver receiver) {
        contacts.remove(receiver);
    }

    @Override
    public void sendMessage(Message message) {

        if (contacts.contains(message.getReceiver())) {

            System.out.println();

            System.out.println(BLUE + getFirstName() + " " + getLastName() + " has sent a message" + RESET);

            message.getReceiver().receive(message);

            loadedMessages.remove(message);

        } else {
            // todo
            throw new RuntimeException("Register the receiver before sending the message");
        }
    }

    public Message createMessage(String text, User receiver) {

        Message message = new Message(text, this, receiver);

        loadedMessages.addLast(message);

        System.out.println();

        System.out.println(BLUE_UNDERLINED + getFirstName() + " " + getLastName() + " has written a new message" + RESET);

        return message;
    }

    public Message readMessage(Message message) {

        System.out.println();

        System.out.println(GREEN_UNDERLINED + getFirstName() + " " + getLastName() + " is reading a new message" + RESET);

        if (!inbox.remove(message)) {
            // todo
            throw new RuntimeException("That message isn't in the inbox");
        }
        return message;
    }

    public Deque<Message> getLoadedMessages() {
        return loadedMessages;
    }

    public Deque<Message> getInbox() {
        return inbox;
    }
}
