package jpa;

import javax.annotation.Generated;
import javax.persistence.*;



// @SecondaryTables({@SecondaryTable(name = "adress") создание подтаблиц по ключу (@Id), @GeneratedValue генератор чисел по аннотациям с таблицей-генератор @TableGenerator чисел


//@Entity
//@Table(name = "universityStudent")  //имя таблицы задаем
//@SecondaryTables({@SecondaryTable(name = "adress"),@SecondaryTable(name = "country")}) // создаем 2 таблицы с ключом-по id от основной таблицы (universityStudent)
//@SecondaryTable(name = "adress")
//@SequenceGenerator(name = "Siqu",initialValue = 1, allocationSize = 100)
public class Student
{/*
    @Id //@GeneratedValue  // ключ по id и уникальность значений ключа
  //  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Siqu") вместе с @SequenceGenerator
    @TableGenerator(name = "I'm", table = "Sequnse", initialValue = 100, allocationSize = 10, pkColumnName = "value")
    //  создается таблица генерации ( по значениям как генерироват 101, 102, ... )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "I'm") // генератор TABLE и имя "I'm" генератора
    int id;

    String name;

    int age;

    @Column (table = "adress") // колонка city создастся у таблицы adress
    String city;

    @Column (table = "adress")
    String street;

    @Column (table = "country") // колонка count создастся у таблицы country
    String count;

    public Student() {    // должен быть пустой конструктор если есть конструктор
    }

    public Student(String name,int age) {
        this.name = name;
        this.age=age;
    }*/
}
