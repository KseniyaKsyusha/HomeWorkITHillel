package ua.en.kosse.oksana.hillel.hw8.competitions.obstacle;

// 3. Створіть тип даних Перешкода та кілька її реалізацій: Бігова доріжка та Стіна.
public class Obstacle {
    private Wall wall; //Стіна
    private RunningTrack runningTrack; // Бігова доріжка

    public Obstacle(Wall wall, RunningTrack runningTrack) {
        this.wall = wall;
        this.runningTrack = runningTrack;
    }

    public float getWall() {
        return wall.getHeight();
    }

    public int getRunningTrack() {
        return runningTrack.getLength();
    }
}
