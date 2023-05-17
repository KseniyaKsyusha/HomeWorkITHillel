package ua.en.kosse.oksana.hillel.hw10;

public class ValueCalculator {

    private final int sizeArray = 1000000;
    private int halfSizeArray;
    private float[] arrayFloat;
    private float[] halfArrayFloat1;
    private float[] halfArrayFloat2;
    private long start;

    public float[] getHalfArrayFloat1() {
        return halfArrayFloat1;
    }

    public float[] getHalfArrayFloat2() {
        return halfArrayFloat2;
    }

    public long getStart() {
        return start;
    }

    public void startValueCalculator() {

        start = System.currentTimeMillis();
        halfSizeArray = sizeArray / 2;

        arrayFloat = getArray();

        splitArray(arrayFloat, halfSizeArray);

        //mergeTwoArrays(arrayFloat, halfSizeArray);

    }

    private float[] getArray() {
        arrayFloat = new float[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            arrayFloat[i] = 1;
        }
        return arrayFloat;
    }

    private void splitArray(float[] arrayFloat, int halfSizeArray) {
        halfArrayFloat1= new float[halfSizeArray];
        halfArrayFloat2 = new float[halfSizeArray];

        System.arraycopy(arrayFloat, 0, halfArrayFloat1, 0, halfSizeArray);
        System.arraycopy(arrayFloat, halfSizeArray, halfArrayFloat2, 0, halfSizeArray);
    }

    public void mergeTwoArrays() {
        System.arraycopy(halfArrayFloat1, 0, arrayFloat, 0, halfSizeArray);
        System.arraycopy(halfArrayFloat2, 0, arrayFloat, halfSizeArray, halfSizeArray);
    }


}
