package ua.en.kosse.oksana.hillel.hw12.phonebook;

import java.util.ArrayList;


public class PhoneBook {

    ArrayList<RecordPhoneBook> myPhoneBook = new ArrayList<>();

    public void add(String nameContact, String numberPhone) {
        myPhoneBook.add(new RecordPhoneBook(nameContact, numberPhone));
    }

    public Object find(String nameContact) {
        for (RecordPhoneBook myNameContact : myPhoneBook) {
            if (myNameContact.getNameContact().equals(nameContact)) {
                int index = myPhoneBook.indexOf(myNameContact);
                return myPhoneBook.get(index);
            }
        }
        return null;
    }

    public ArrayList<RecordPhoneBook> findAll(String nameContact) {
        ArrayList<RecordPhoneBook> findRecord = new ArrayList<>();
        int index;
        for (RecordPhoneBook myNameContact : myPhoneBook) {
            if (myNameContact.getNameContact().equals(nameContact)) {
                index = myPhoneBook.indexOf(myNameContact);
                findRecord.add(myPhoneBook.get(index));

            }
        }
        if (findRecord.size()==0){
            return null;
        }else {
            return findRecord;
        }
    }


    @Override
    public String toString() {
        return "PhoneBook{" +
                "myPhoneBook=" + myPhoneBook +
                '}';
    }
}
