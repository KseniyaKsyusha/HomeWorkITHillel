package ua.en.kosse.oksana.hillel.hw11;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadSleep {
    public static void beASleep(int start, int end) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(start, end));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
