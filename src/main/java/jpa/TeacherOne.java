package jpa;


import javax.persistence.*;
import java.util.List;

////@Entity
public class TeacherOne {/*

    @Id @GeneratedValue
    int Id;

    String teacher;

                   //@OneToOne(orphanRemoval = true- удаление таблиц сирот
  //  @OneToOne(cascade = CascadeType.ALL) // связь один к одном, если в одной, то она главная,
                                        // CascadeType.ALL для каких изменени в обоих таблицах, если удалить в одной, то и в другой удалится все что привязанно к первой
  //  @JoinColumn(name = "together") // названия столбца объединения
  //    TeacherAdress adress;



 //   @OneToMany(cascade = CascadeType.ALL)
   // @JoinColumn(name = "teahid")
  //  @JoinTable(name = "teach")
//    List<TeacherAdress> list;



  @JoinColumn(name = "Teachid")
  //@OneToOne
  //@OneToMany
  @ManyToMany(cascade = CascadeType.ALL) // обязательно  CascadeType.ALL
  List<TeacherAdress> list;

    public TeacherOne() {
    }


    public TeacherOne(String teacher) {
        this.teacher = teacher;
    }

 //   public TeacherAdress getAdress() {
 //       return adress;
 //   }

 //   public void setAdress(TeacherAdress adress) {
 //       this.adress = adress;
 //   }

    public List<TeacherAdress> getList() {
        return list;
    }

    public void setList(List<TeacherAdress> list) {
        this.list = list;
    }*/
}
