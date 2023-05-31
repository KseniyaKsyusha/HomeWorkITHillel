package ua.en.kosse.oksana.hillel.hw12.occurrence;

import java.util.*;

public class CalcOccurrence {

    public static void calcOccurrence(List<String> myArrayList) {
        HashSet<String> setString = new HashSet<>(myArrayList);
        for (String a : setString) {
            System.out.println(a + " :  " + Collections.frequency(myArrayList, a));
        }
    }
}
