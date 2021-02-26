package jms;

import java.io.Serializable;

public class Student implements Serializable {
    String name;

    public Student(String name) {
        this.name = name;
    }
}
