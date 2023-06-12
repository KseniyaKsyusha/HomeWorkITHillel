package ua.en.kosse.oksana.hillel.hw15;

import ua.en.kosse.oksana.hillel.hw5.color.RandomNumber;

import java.util.List;

public class HomeWorkSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort<>();
        List array = null;
        for (int i = 0; i < 11; i++) {
            array = quickSort.push(new RandomNumber().getRandomNumberInt(-200, 200));

        }

        System.out.printf("Original ArrayList: %s \n",array);

        quickSort.partitionSort(array, 0, array.size()-1);

        System.out.printf("Quick sort ArrayList: %s \n", array);

        Shaiker shaikerSort = new Shaiker<>();

        shaikerSort.shaiker(array,0, array.size()-1);

        System.out.printf("Shaiker sort ArrayList: %s \n", array);

    }
}
