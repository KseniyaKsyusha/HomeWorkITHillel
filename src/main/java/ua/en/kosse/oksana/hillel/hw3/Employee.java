package ua.en.kosse.oksana.hillel.hw3;

public class Employee {
    private String name;
    private String post;
    private String email;
    private String phone;
    private Integer age;

    public Employee() {
    }

    public Employee(String name, String post, String email, String phone, Integer age) {
        if (age < 18) {
            throw new IllegalArgumentException(" Age under 18 !!!!! ");
        }
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 18) {
            throw new IllegalArgumentException(" You can only work from the age of 18 !!!!! ");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee {"
                + "name = '" + name + '\''
                + ", post = '" + post + '\''
                + ", email = '" + email + '\''
                + ", phone = '" + phone + '\''
                + ", age = " + age
                + '}';
    }
}
