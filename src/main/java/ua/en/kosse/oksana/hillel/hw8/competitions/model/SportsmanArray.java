package ua.en.kosse.oksana.hillel.hw8.competitions.model;

import ua.en.kosse.oksana.hillel.hw8.competitions.obstacle.Obstacle;

import java.util.ArrayList;

public class SportsmanArray {
    private String[] arr;
    private ArrayList<Sportsman> sportsmenArray;

    public SportsmanArray() {
        this.sportsmenArray = new ArrayList<>();
    }

    public void addSportsman(Sportsman sportsman) {
        sportsmenArray.add(sportsman);
    }

    // Запуск прохождения командой полосы препятствий
    public void Overcome(ArrayList<Obstacle> overcome) {
        arr = new String[sportsmenArray.size()];
        for (int i=0;i<arr.length;i++){
            arr[i]=sportsmenArray.get(i).getName();
        }
        //System.out.println("Start!");

        for (Obstacle obstacle : overcome) {
            for (int i = 0; i < arr.length; i++) {
                //if (sportsmenArray.get(i).f)
                System.out.println(sportsmenArray.get(i).run(obstacle.getRunningTrack()));
                System.out.println(sportsmenArray.get(i).jump(obstacle.getWall()));
            }
        }

    }
}
