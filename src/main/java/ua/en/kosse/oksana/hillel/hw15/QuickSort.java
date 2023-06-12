package ua.en.kosse.oksana.hillel.hw15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort<T> {
    private List<T> myArrayList = new ArrayList<T>();

    public List<T> push(T x) {
        myArrayList.add(x);
        return myArrayList;
    }

    public <T extends Comparable<T>> void partitionSort(List<T> myArrayList, int low, int high) {
        int left = low;
        int right = high;
        T pivot =  myArrayList.get(low + (high - low) / 2);
        while (left <= right) {
            while ((myArrayList.get(left)).compareTo(pivot) < 0) left++;
            while ((myArrayList.get(right)).compareTo(pivot) > 0) right--;
            if (left <= right) {
//                var sw = myArrayList.get(left);
//                myArrayList.set(left, myArrayList.get(right));
//                myArrayList.set(right, sw);
                Collections.swap(myArrayList,left,right);
                left++;
                right--;
            }
        }
        if (low < right) partitionSort(myArrayList, low, right);
        if (high > left) partitionSort(myArrayList, left, high);
    }

    @Override
    public String toString() {
        return "QuickSort{" +
                "myArrayList=" + myArrayList +
                '}';
    }

}
