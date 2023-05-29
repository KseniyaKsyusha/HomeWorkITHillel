package ua.en.kosse.oksana.hillel.hw11;

public class HomeWorkThread {
    public static void main(String[] args) {

        PetrolStation petrolStation1 = new PetrolStation(1000);

        for (int i = 5; i <=100 ; i+=10) {
            new Thread(ThreadSafeListRunner.getRefuelingRunner(petrolStation1, i)).start();
        }

        ThreadSafeList threadSafeList = new ThreadSafeList();
        new Thread(ThreadSafeListRunner.getThreadSafeListRunner(threadSafeList)).start();
        new Thread(ThreadSafeListRunner.getThreadSafeListRunner(threadSafeList)).start();
        new Thread(ThreadSafeListRunner.getThreadSafeListRunner(threadSafeList)).start();
    }

}

