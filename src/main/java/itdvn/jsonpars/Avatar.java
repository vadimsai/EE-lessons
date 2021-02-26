package itdvn.jsonpars;

import java.util.List;

public class Avatar {

    private String firstName;
    private  String lastName;
    private int age;
    private List<String> contacts;

    public Avatar() {
    }

    public Avatar(String firstName, String lastName, int age, List<String> contacts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.contacts = contacts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", contacts=" + contacts +
                '}';
    }
}
