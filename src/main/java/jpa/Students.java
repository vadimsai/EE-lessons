package jpa;

import javax.ejb.Singleton;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Entity
//@Table(name = "students")
public class Students {/*

    @Id
    @Column(name = "id")
    @GeneratedValue()
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "age")
    int age;

    @CollectionTable(name = "LISTStudents")   // имя для отдельной таблицы для LIST
    @Column(name = "list")  // название колонки в отдельной таблице для LIST
    @ElementCollection(fetch = FetchType.LAZY) // создание отдельной таблицы для LIST, где все значения листа по id объекта из основной таблицы Stydents
    List<String> list = new ArrayList<>();

   // @CollectionTable(name = "MAPStudents")
    @Column(name = "map")
    @ElementCollection(fetch = FetchType.LAZY) // создание отдельной таблицы для Map
  //  @MapKeyColumn(name = "key")
    Map<String,Integer> map=new HashMap<>();


    @Embedded  // из StudentsAdress класса вставляем поля в эту таблицу(поля), добавляем в конструкторе, @Embeddable на классе StudentsAdress
    StudentsAdress studentsAdress=new StudentsAdress();



    public Students() {
    }

    public Students(String name, int age) {
        this.name = name;
        this.age=age;
        studentsAdress.city="Chikago";
        studentsAdress.street="9-illinois";

        list.add("SAI");
        list.add("AUM");
        list.add("RAM");
        map.put("SAI",777);
        map.put("AUM",999);
        map.put("RAM",111);


    }

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
    }*/
}
/*
@Embeddable
class StudentsAdress
{
    String city;
    String street;
}*/