package ua.en.kosse.oksana.hillel.hw12.occurrence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MyCounter {

    public static Map<Integer, Integer> of(List<Integer> tokens) {
        Map<Integer, Integer> innerCounter = new HashMap<>();
        for (Integer token : tokens) {
            innerCounter.put(token, innerCounter.containsKey(token) ? innerCounter.get(token)+1 : 1);
        }
        return innerCounter;
    }


}

