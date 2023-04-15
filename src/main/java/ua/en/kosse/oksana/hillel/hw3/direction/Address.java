package ua.en.kosse.oksana.hillel.hw3.direction;

import ua.en.kosse.oksana.hillel.hw3.Employee;

public class Address extends Employee {
    private String nameComp;
    private String url;


    public Address(String name, String post, String email, String phone, Integer age, String nameComp, String url) {
        super(name, post, email, phone, age);
        this.nameComp = nameComp;
        this.url = url;
    }

    @Override
    public String getName() {
        return nameComp;
    }

    @Override
    public void setName(String nameComp) {
        this.nameComp = nameComp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "nameComp='" + nameComp + '\'' +
                ", url='" + url + '\'' +
                '}' +" \n "+ super.toString();
    }
}



