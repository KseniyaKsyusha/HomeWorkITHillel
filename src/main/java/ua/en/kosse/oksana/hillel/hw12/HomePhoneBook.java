package ua.en.kosse.oksana.hillel.hw12;

import com.github.javafaker.Faker;
import ua.en.kosse.oksana.hillel.hw12.phonebook.PhoneBook;

public class HomePhoneBook {
    public static void main(String[] args) {
        Faker fakerPhone = new Faker();
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Igor", "0501234567");
        for (int i = 0; i < 5; i++) {
            myPhoneBook.add(fakerPhone.name().name(), fakerPhone.phoneNumber().phoneNumber());
        }
        myPhoneBook.add("Igor", "0981234567");
        myPhoneBook.add("Svetlana", "0507654321");
        System.out.println(myPhoneBook);

        System.out.println();
        Object findContact = myPhoneBook.find("Igor");
        System.out.println("Find contact: " + findContact);

        System.out.println();
        Object findContactNull = myPhoneBook.find("Oksana");
        System.out.println("Find  contact null: " + findContactNull);

        System.out.println();
        Object findContactAll = myPhoneBook.findAll("Igor");
        System.out.println("Find all contact: " + findContactAll);

        System.out.println();
        Object findContactAllNull = myPhoneBook.findAll("Oksana");
        System.out.println("Find all contact null: " + findContactAllNull);
    }
}
