package ua.en.kosse.oksana.hillel.hw8.competitions.model;

//1. Створіть тип даних Учасник та кілька його реалізацій: Людина, Кіт, Робот.
//2. Класи з п.1 повинні мати поведінку бігати і стрибати (методи просто виводять інформацію про дію в консоль
public class Human extends Sportsman {

    public Human(String name, String creature, int maxdistance, float maxheight) {
        super(name, creature, maxdistance, maxheight);
    }
}
