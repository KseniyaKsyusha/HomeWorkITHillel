package ua.en.kosse.oksana.hillel.hw12.phonebook;

public class RecordPhoneBook {
    String nameContact;
    String numberPhone;

    public RecordPhoneBook(String nameContact, String numberPhone) {
        this.nameContact = nameContact;
        this.numberPhone = numberPhone;
    }

    public String getNameContact() {
        return nameContact;
    }

    public String getNumberPhone() {
        return numberPhone;
    }


    @Override
    public String toString() {
        return "\n\t{" +
                "nameContact='" + nameContact + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                '}';
    }
}