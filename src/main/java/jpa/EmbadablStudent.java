package jpa;


import javax.persistence.*;
import java.io.Serializable;

// Создание таблицы по 2 ключам(@EmbeddedId) и выделение Отдельного класса(@Embeddable) под ключи, если большие данные или...

@Entity
//@IdClass(StudidTwo.class)
public class EmbadablStudent
{
    @EmbeddedId
    StudidTwo studidTwo;  // класс с ключами

   // @Id
   // String name;
   // @Id
   // String surname;
    int age;

    public EmbadablStudent() {
    }

    public EmbadablStudent(String name, String surname,int age)
    {
        this.studidTwo=new StudidTwo(name,surname); // новый объект класса с ключами
        this.age = age;
      //  this.name = name;
      //  this.surname=surname;
    }
}

@Embeddable
class StudidTwo implements Serializable
{
    String name;
    String surname;

    public StudidTwo(String name, String surname ) {
        this.name = name;
        this.surname=surname;
    }

    public StudidTwo() {

    }
}