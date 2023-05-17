package ua.en.kosse.oksana.hillel.hw10;

public class HomeWorkThread  {
    public static void main (String[] args) throws InterruptedException{

        ValueCalculator valueCalculator = new ValueCalculator();
        valueCalculator.startValueCalculator();

        CreateThreads myTread1 =new CreateThreads(valueCalculator.getHalfArrayFloat1() );
        CreateThreads myTread2 =new CreateThreads(valueCalculator.getHalfArrayFloat2() );

        long start = valueCalculator.getStart();
        System.out.printf("Time start: %s \n", start);
        myTread1.start();
        myTread2.start();

        try {
            myTread1.join();
            myTread2.join();
        } catch (InterruptedException e) {
            myTread1.interrupt();
            myTread2.interrupt();
        }
        finally {
            valueCalculator.mergeTwoArrays();
            long end =System.currentTimeMillis()-start;
            System.out.printf("Time end: %s \n", end);
        }

    }
}
