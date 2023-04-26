package ua.en.kosse.oksana.hillel.hw8;

import ua.en.kosse.oksana.hillel.hw5.color.RandomNumber;
import ua.en.kosse.oksana.hillel.hw7.randomFloat.RandomFloat;
import ua.en.kosse.oksana.hillel.hw8.competitions.model.*;
import ua.en.kosse.oksana.hillel.hw8.competitions.obstacle.Obstacle;
import ua.en.kosse.oksana.hillel.hw8.competitions.obstacle.ObstacleArray;
import ua.en.kosse.oksana.hillel.hw8.competitions.obstacle.RunningTrack;
import ua.en.kosse.oksana.hillel.hw8.competitions.obstacle.Wall;
import ua.en.kosse.oksana.hillel.hw8.figure.*;

public class HomeWorkPolymorphism {
    public static void main(String[] args) {
        AreaFigure[] figure = new AreaFigure[3];

        //Створити базовий інтерфейс для геометричної фігури, в якому є метод, який повертає площу фігури.
        //Створити 3 класи, які реалізують цей інтерфейс: коло, трикутник, квадрат.
        //Створити масив фігур, і написати метод який виведе сумарну площу всіх фігур у цьому масиві
        try {
            figure[0] = new Triangle(new RandomNumber().getRandomNumberInt(-3, 20),
                    new RandomNumber().getRandomNumberInt(-3, 20), new RandomNumber().getRandomNumberInt(-3, 20));
        } catch (IllegalArgumentException e) {
            System.err.println("Unable to create Triangle instance: " + e.getMessage());
        }
        try {
            figure[1] = new Square(new RandomNumber().getRandomNumberInt(-3, 20));
        } catch (IllegalArgumentException e) {
            System.err.println("Unable to create Square instance: " + e.getMessage());
        }
        try {
            figure[2] = new Circle(new RandomNumber().getRandomNumberInt(-3, 20));
        } catch (IllegalArgumentException e) {
            System.err.println("Unable to create Circle instance: " + e.getMessage());
        }
        System.out.println("Total area of all shapes summaArea = " + String.format("%.5f", new Area().area(figure)));
        System.out.println();
        System.out.println("Веселі старти!");
        //Створіть тип даних Учасник та кілька його реалізацій: Людина, Кіт, Робот.
        SportsmanArray athlete = new SportsmanArray();
        athlete.addSportsman(new Human("Superman", "man", new RandomNumber().getRandomNumberInt(100, 200),
                new RandomFloat().getRandomNumberFloat(0.1f, 2.0f)));
        athlete.addSportsman(new Cat("Leopold","cat",new RandomNumber().getRandomNumberInt(90, 125),
                new RandomFloat().getRandomNumberFloat(0.1f, 2.0f)));
        athlete.addSportsman(new Robot("Verter ","robot", new RandomNumber().getRandomNumberInt(100, 1000),
                new RandomFloat().getRandomNumberFloat(0.1f, 2.0f)));

        ObstacleArray overcome = new ObstacleArray();
        overcome.obstacleAdd(new Obstacle(new Wall(0.2f), new RunningTrack(100)));
        //overcome.obstacleAdd(new Obstacle(new Wall(0.8f), new RunningTrack(300)));
        //overcome.obstacleAdd(new Obstacle(new Wall(1.5f), new RunningTrack(1500)));

        athlete.Overcome(overcome.getObstacleArray());
    }
}
