package ua.en.kosse.oksana.hillel.hw8.competitions.obstacle;

import java.util.ArrayList;
// 6. Створіть  масив з перешкодами.
public class ObstacleArray {

    private ArrayList<Obstacle> obstacleArray;

    public ObstacleArray() {
        obstacleArray=new ArrayList<Obstacle>();
    }

    public ArrayList<Obstacle> getObstacleArray() {
        return obstacleArray;
    }

    public void obstacleAdd(Obstacle obstacle){
        obstacleArray.add(obstacle);
    }


}
