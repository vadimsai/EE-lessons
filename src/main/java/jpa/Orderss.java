package jpa;

import javax.persistence.*;
import java.util.*;

//@Entity
public class Orderss {/*

    @Id
    @GeneratedValue()
    int id;
    String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @OrderBy("number ")  // не работает
    @OrderColumn(name = "ordercolumn")  // доп колонка, порядок добавления элементов
    List<Byss> list=new ArrayList<>();


    public Orderss() {
    }

    public Orderss(String name) {
        this.name = name;
        list.add(new Byss(3));
        list.add(new Byss(1));
        list.add(new Byss(2));

    }

    void p(){
        for (Byss e: list)
        {
            System.out.println(e.number);
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("Students");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        et.begin();
       Orderss orderss=em.find(Orderss.class,1);
       orderss.p();

        et.commit();
        em.close();
        emf.close();
    }


}
@Entity
class Byss {
    @Id
    @GeneratedValue()
    int id;
    String city;
    String street;
    int number;

    public Byss() {
    }
    public Byss(int number) {
        this.number=number;
        street="AAA";
        city="BBB";

    }*/

}