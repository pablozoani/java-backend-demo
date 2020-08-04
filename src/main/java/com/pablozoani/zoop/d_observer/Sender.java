package com.pablozoani.zoop.d_observer;

public interface Sender {

    void registerReceiver(Receiver receiver);

    void unregisterReceiver(Receiver receiver);

    void sendMessage(Message message);
}