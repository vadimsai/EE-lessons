package jpa;

import javax.persistence.*;

//@DiscriminatorValue("W")
@Entity
public class Worker extends Person
{
    @Id
    @GeneratedValue
    int id;

    String name;
    int age;

    public Worker() {
    }

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }
}



@MappedSuperclass  // без @Entity и все поля из Person в наследниках и без Id, т.к. Id из Person

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //все поля из Person в наследниках
//@Inheritance(strategy = InheritanceType.JOINED)
//@Entity
//@DiscriminatorColumn(name = "className") // колонка для типов данных наследников
//@DiscriminatorValue("P")
class Person {
    @Id @GeneratedValue
    int id;


    String people;

    public Person() {
    }

    public Person(String people) {
        this.people = people;
    }
}
