package com.pablozoani.designpattern.d_observer;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static final Lock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {

        User lois = new User("Lois", "Lane", "lois_lane@domain.net");

        User clark = new User("Clark", "Kent", "super_main@example.ar");

        lois.registerReceiver(clark);

        lois.createMessage("Lex Luthor has found kryptonite...", clark);

        lois.createMessage("We should keep it secret...", clark);

        AtomicBoolean flag = new AtomicBoolean(false);

        new Thread(() -> {

            lock.lock();

            try {

                int i = lois.getLoadedMessages().size();

                while (i-- > 0) {

                    Thread.sleep(2000);

                    lois.sendMessage(lois.getLoadedMessages().getFirst());
                }
            } catch (InterruptedException e) {

                e.printStackTrace();

            } finally {

                flag.set(true);

                condition.signal();

                lock.unlock();
            }
        }).start();

        new Thread(() -> {

            lock.lock();

            try {

                if (!flag.get()) condition.await();

                int i = clark.getInbox().size();

                while (i-- > 0) {

                    Thread.sleep(2000);

                    Message message = clark.readMessage(clark.getInbox().getFirst());

                    for (char c : message.toString().toCharArray()) {

                        Thread.sleep(100);

                        System.out.print(c);
                    }
                    System.out.println();
                }
            } catch (InterruptedException e) {

                e.printStackTrace();

            } finally {

                lock.unlock();
            }
            if (!(clark.getInbox().size() == 0 && lois.getLoadedMessages().size() == 0)) {

                throw new RuntimeException("Inconsistent state of the objects");
            }
        }).start();
    }
}
