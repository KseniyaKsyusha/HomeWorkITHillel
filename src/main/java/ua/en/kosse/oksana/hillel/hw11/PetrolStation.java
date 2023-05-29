package ua.en.kosse.oksana.hillel.hw11;

import java.util.concurrent.Semaphore;

public class PetrolStation {
    private final Semaphore semaphore = new Semaphore(3);
    double amount;

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public void doRefuel(double amount) {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " refueling started (amount = " + this.amount + ")");
            ThreadSleep.beASleep(3000, 10000);
            this.amount = this.amount - amount;
            if (this.amount < 0) {
                throw new RuntimeException("Sorry, but there is not enough gas at the gas station.");
            } else {
                System.out.println(Thread.currentThread().getName() + " refueling is over (amount = " + this.amount + ")");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}