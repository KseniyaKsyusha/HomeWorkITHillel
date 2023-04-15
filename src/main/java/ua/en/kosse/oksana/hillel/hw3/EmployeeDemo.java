package ua.en.kosse.oksana.hillel.hw3;

import com.github.javafaker.Faker;
import ua.en.kosse.oksana.hillel.hw3.avto.Car;
import ua.en.kosse.oksana.hillel.hw3.direction.Address;

import java.util.Locale;
import java.util.Random;

public class EmployeeDemo {
    public static void main(String[] args) {

        /*Створити клас "Співробітник" з полями: ПІБ, посада, email, телефон, вік.
        Конструктор класу повинен заповнювати ці поля під час створення об'єкта.
        Забезпечити інкапсуляцію внутрішніх властивостей класу.*/
        System.out.println("1. Створити клас \"Співробітник\" з полями: ПІБ, посада, email, телефон, вік.");
        // 1 способ
        Employee person = new Employee();
        person.setName("Сидоров С.С .");
        person.setPost("manager");
        person.setEmail("bb@online.ua");
        person.setPhone("37658");
        person.setAge(new Random().nextInt(60));

        System.out.println(person);
        System.out.println();

        // 2 способ
        Employee person2 = new Employee("Иванов В.В.", "driver", "aa@online.ua", "789799", 18);
        System.out.println(person2);
        System.out.println();

        // 3 способ с библиотекой Faker (генерирует данные)
        Faker faker = new Faker(new Locale("ua"));
        //Faker faker = Faker.instance();
        Employee person3 = new Employee(faker.name().name(), faker.company().profession(), faker.internet().emailAddress(),
                faker.phoneNumber().phoneNumber(), new Random().nextInt(60));
        System.out.println(person3);
        System.out.println();

        // 4
        System.out.println(new Employee(faker.name().name(), faker.company().profession(), faker.internet().emailAddress(),
                faker.phoneNumber().phoneNumber(), faker.number().numberBetween(18, 60)));
        System.out.println();

        // Створити два класи з однаковим ім'ям SameName. (Використовувати пакети)
        // 1 класс Direction\Address
        System.out.println("2. Створити два класи з однаковим ім'ям SameName. (Використовувати пакети)");
        Faker fakerAddress = new Faker();
        Address adr = new Address(fakerAddress.name().name(), fakerAddress.company().profession(),
                fakerAddress.internet().emailAddress(), fakerAddress.phoneNumber().phoneNumber(),
                fakerAddress.number().numberBetween(18, 40), fakerAddress.company().name(),
                fakerAddress.company().url());

        System.out.println(adr);
        System.out.println();

        // 2 класс Adds\Address
        Faker fakerAddressPerson = new Faker();
        Employee emp1 = new Employee(fakerAddressPerson.name().name(), fakerAddressPerson.company().profession(),
                fakerAddressPerson.internet().emailAddress(), fakerAddressPerson.phoneNumber().phoneNumber(),
                fakerAddressPerson.number().numberBetween(18, 60));
        ua.en.kosse.oksana.hillel.hw3.adds.Address addressPerson = new ua.en.kosse.oksana.hillel.hw3.adds.Address();
        addressPerson.setAdr(fakerAddressPerson.address().fullAddress());
        addressPerson.setEmployee(emp1);
        System.out.println(addressPerson);
        System.out.println();


        /* Створити клас Car з публічним методом start. Метод start викликає у собі методи:
        - startElectricity()
        - startCommand()
        - startFuelSystem()
        Перелічені методи, є внутрішньою (прихованою) частиною комплексного методу start.
        Вони по суті відображають внутрішню поведінку класу Car і не повинні використовуватися за межами даного класу.*/
        System.out.println("3. Створити клас Car");
        Car car = new Car("Land Cruiser", "Люкс", 2990, person);
        System.out.println();
        car.CarStr();
        car.start();

    }
}
