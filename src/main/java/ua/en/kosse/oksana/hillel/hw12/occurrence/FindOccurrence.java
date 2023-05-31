package ua.en.kosse.oksana.hillel.hw12.occurrence;

import java.util.ArrayList;
import java.util.List;

public class FindOccurrence {

    public static List<FindOccurrenceStructure> findOccurrence(List<String> strList) {
        List<FindOccurrenceStructure> result = new ArrayList<>();
        List<String> bufferList = new ArrayList<>();

        for (int i = 0; i < strList.size(); i++) {
            if (!bufferList.contains(strList.get(i))) {
                bufferList.add(strList.get(i));
                int count = 0;

                for (String s : strList) {
                    if (strList.get(i).equals(s)) {
                        count++;
                    }
                }

                result.add(new FindOccurrenceStructure(strList.get(i), count));
            }
        }

        return result;
    }

}

