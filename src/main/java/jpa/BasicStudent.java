package jpa;

import javax.persistence.*;


// @Basic определенные поля можно подгружать по использованию, если они редко используются и большие данные
@Entity
public class BasicStudent
{
    @Id @GeneratedValue
    int id;

    @Basic(optional = true) // поле not null в таблице
    String name;

    @Basic(fetch = FetchType.LAZY) // будет подгружаться по требованию ( для больших данных можно)
    @Lob  // для больших данных ?(изображения)
    byte[] img;

    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BasicStudent() {
    }

    public BasicStudent(String name,int age) {
        this.name = name;
        this.age=age;
    }
}
