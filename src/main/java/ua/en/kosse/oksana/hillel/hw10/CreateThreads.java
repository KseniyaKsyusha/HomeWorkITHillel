package ua.en.kosse.oksana.hillel.hw10;

public class CreateThreads extends Thread{
    private float[] halfArrayOfFloat;

    public CreateThreads(float[] halfArrayOfFloat) {
        this.halfArrayOfFloat = halfArrayOfFloat;
    }

    @Override
    public void run() {
        for (int i = 0; i < halfArrayOfFloat.length ; i++) {
            halfArrayOfFloat[i] = (float) (halfArrayOfFloat[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.printf("Thread %s: index %s: %s \n",Thread.currentThread().getId(), i, halfArrayOfFloat[i]);
        }

    }


}
