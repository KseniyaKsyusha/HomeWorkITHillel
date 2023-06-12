package ua.en.kosse.oksana.hillel.hw15;

import java.util.Collections;
import java.util.List;

public class Shaiker<T> {

    public <T extends Comparable<T>> void shaiker(List<T> myArrayList, int low, int high) {
        int left = low;
        int right = high;
        while (left <= right) {

            for (int i = left; i < right; i++) {
                if (myArrayList.get(i).compareTo(myArrayList.get(i + 1)) > 0) {
                    Collections.swap(myArrayList, i, i + 1);
                    
                }
            }

            for (int i = right; i > left; i--) {
                if (myArrayList.get(i).compareTo(myArrayList.get(i - 1)) < 0) {
                    Collections.swap(myArrayList, i, i - 1);
                }
            }

            left++;
            right--;
        }
    }
}

