package ua.en.kosse.oksana.hillel.hw12.occurrence;

import java.util.List;

public class Occurrence {

    public static int countOccurrence(List<String> myStringList, String myCity){
        int count = 0;
        for ( String stringList: myStringList) {
            if (myCity.equals(stringList)) count++;
        }
        return count;

    }



}
