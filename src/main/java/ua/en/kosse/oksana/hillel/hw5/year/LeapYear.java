package ua.en.kosse.oksana.hillel.hw5.year;

import ua.en.kosse.oksana.hillel.hw5.color.RandomNumber;

public class LeapYear {

    public void leapYear() {
        int year = new RandomNumber().getRandomNumberInt(1979, 2023);
        //int year = 2024;
        System.out.printf("10. Рік %s є високосний ? %s \n", year,
                (year % 4 == 0 && year % 100 != 0 || year % 400 == 0));
        return;
    }
}
