package ua.en.kosse.oksana.hillel.hw17;

import java.util.Arrays;
import java.util.List;

public class ToList<T>{
    List<T> obj;
    public void toList(T[] obj){
        this.obj= Arrays.asList(obj);
    }

    public List<T> getObj() {
        return obj;
    }
}
