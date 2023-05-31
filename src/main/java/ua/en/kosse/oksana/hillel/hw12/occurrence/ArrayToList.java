package ua.en.kosse.oksana.hillel.hw12.occurrence;

import java.util.ArrayList;
import java.util.List;

public class ArrayToList {

    public static List<Integer> toList(int[] myArray){
        List <Integer> myIntegerList = new ArrayList<>();
        for (Integer myInteger: myArray) {
            myIntegerList.add(myInteger);
        }
        return myIntegerList;
        //return Arrays.asList(myArray);
    }

    public static void printList(List<Integer> myIntegerList) {
        try {
            StringBuilder myStringBuilder = new StringBuilder();
            for (Integer myInteger : myIntegerList) {
                myStringBuilder.append(myInteger);
                myStringBuilder.append(", ");
            }
            myStringBuilder.deleteCharAt(myStringBuilder.length()-1); // remove trailing comma
            System.out.println(myStringBuilder);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("An empty array!!!");
        }
    }
}
