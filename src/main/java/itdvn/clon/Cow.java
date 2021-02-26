package itdvn.clon;

import java.io.Serializable;

public class Cow implements Serializable{ //implements Cloneable {

    public String name;
    private int age;
    private int head;
    public Group group;



    // Фабричный метод копирования
    public static Cow fabriCopy(Cow cow)
    {
        Cow clonCow=new Cow();
        clonCow.name=cow.name;
        clonCow.age=cow.age;
        clonCow.head=cow.head;
        clonCow.group=cow.group;

        return clonCow;
    }


    // конструктор копирования
    public Cow(Cow other) // конструктор копирования
    {
        this(other.name, other.age, other.head, other.group);
    }


    // метод копирования, меняем на public
    @Override  // метод копирования, меняем на public
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }




    public Cow() {
    }

    public Cow(String name, int age, int head,Group group ) {
        this.name = name;
        this.age = age;
        this.head = head;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", head=" + head +
                ", group=" + group +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
