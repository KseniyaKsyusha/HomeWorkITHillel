package ua.en.kosse.oksana.hillel.hw11;

public class ThreadSafeListRunner {

    static Runnable getThreadSafeListRunner(ThreadSafeList threadSafeList) {
        return new Runnable() {
            @Override
            public void run() {
                threadSafeList.add("myFirst");
                threadSafeList.add("mySecond");
                threadSafeList.add("The End");
                System.out.println(threadSafeList.get(1));
                threadSafeList.remove(1);
                System.out.println(threadSafeList.get());
            }
        };
    }

    static Runnable getRefuelingRunner(PetrolStation petrolStation, double amount) {
        return new Runnable() {
            @Override
            public void run() {
                petrolStation.doRefuel(amount);
            }
        };
    }
}
