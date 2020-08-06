package com.pablozoani.z_other_oop.d_observer;

public interface Sender {

    void registerReceiver(Receiver receiver);

    void unregisterReceiver(Receiver receiver);

    void sendMessage(Message message);
}
