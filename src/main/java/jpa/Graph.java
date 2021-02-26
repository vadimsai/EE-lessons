package jpa;


import javax.persistence.*;

// все поля FetchType.LAZY(получаем по требования), кроме @Basic и @NamedEntityGraph
@Entity
@NamedEntityGraphs(@NamedEntityGraph (name = "getOnly", attributeNodes = {@NamedAttributeNode("name")}))
public class Graph {


    @Id
    @GeneratedValue
    int id;

    String name;

    @Basic(fetch = FetchType.EAGER)
    String surname;

    String adress;

    int age;

    public Graph() {
    }

    public Graph(String name, String surname, String adress,int age) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.age=age;
    }
}
