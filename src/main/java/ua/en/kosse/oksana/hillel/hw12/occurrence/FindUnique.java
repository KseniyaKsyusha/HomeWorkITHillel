package ua.en.kosse.oksana.hillel.hw12.occurrence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUnique {

    public static void findUnique(List <Integer> myIntegerList) {
        Set<Integer> myHashSet = new HashSet<>(myIntegerList);
        printSet(myHashSet);
    }

    public static void printSet(Set<Integer> myHashSet){
        try {
            StringBuilder myStringBuilder = new StringBuilder();
            for (Integer mySet : myHashSet) {
                myStringBuilder.append(mySet);
                myStringBuilder.append(",");
            }
            myStringBuilder.deleteCharAt(myStringBuilder.length()-1); // remove trailing comma
            System.out.println(myStringBuilder);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("An empty array!!!");
        }
    }
}
