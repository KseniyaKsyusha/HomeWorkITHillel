package ua.en.kosse.oksana.hillel.hw11;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class ThreadSafeList {
    CopyOnWriteArrayList<String> worlds = new CopyOnWriteArrayList<>();

    public synchronized void add(String newWorld) {
        ThreadSleep.beASleep(1000, 2000);
        worlds.add(newWorld);
    }

    public synchronized void remove(int index) {
        ThreadSleep.beASleep(1000, 2000);
        worlds.remove(index);
    }

    public synchronized List<String> get(){
        ThreadSleep.beASleep(1000, 2000);
        return this.worlds;
    }

    public synchronized String get(int index){
        ThreadSleep.beASleep(1000, 2000);
        return this.worlds.get(index);
    }
}
