package jpa;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

// @Column значение колонок таблиц и @Transient поле не появится в базе( нужно для расчетов, к примеру )
//  @Temporal(TemporalType.TIMESTAMP) Calendar calendar, сохраняем дату
//   Enum  @Enumerated(EnumType.STRING)   // перечисления
// @NamedQueries для JPQL запросов @NamedNativeQuery для sql запросов
// @NamedStoredProcedureQuery для хранимых процедур
@Entity
@NamedQueries({
        @NamedQuery(name = ColumnStudent.FIND_ALL,query = "select s from ColumnStudent s"),
        @NamedQuery(name = "getByid",query = "select s.surname from ColumnStudent s where s.id=110"),
        @NamedQuery(name = "getByids",query = "select s from ColumnStudent s where s.id=?1")
})
//@NamedNativeQuery(name = "getAll",query = "select * from ColumnStudent", resultClass = ColumnStudent.class)

//@NamedStoredProcedureQuery(name = "updateColumnStudent",procedureName = "updateColumnStudent",parameters = {
//       @StoredProcedureParameter(name = "studId",mode = ParameterMode.IN,type = Integer.class),
//       @StoredProcedureParameter(name = "nName",mode = ParameterMode.IN,type = String.class)
//})

@EntityListeners({
         Jpa.class
})  // слушает события с классом ColumnStudent, Jpa.class-там где код

@Access(AccessType.FIELD)  // доступ к значениям через поля, если  PROPERTY то через getSurname()(пример) и можно добавить что то к
public class ColumnStudent {
 public static final String FIND_ALL="ColumnStudent.findAll";  // для JPQL, если во многих классах используется
                                                               // и добавляем в @NamedQuery


    @PrePersist
    void prePersist()
    {
        System.out.println("prePersist");
    }

    @PostPersist
    void postPersist()
    {
        System.out.println("postPersist");
    }

    @PostLoad
    void postLoad()
    {
        System.out.println("postLoad");
    }

    @PreUpdate
    void preUpdate()
    {
        System.out.println("preUpdate");
    }

    @PostUpdate
    void postUpdate()
    {
        System.out.println("postUpdate");
    }

    @PreRemove
    void preRemove()
    {
        System.out.println("preRemove");
    }

    @PostRemove
    void postRemove()
    {
        System.out.println("postRemove");
    }





    @Id @GeneratedValue//(strategy = GenerationType.IDENTITY)
    int id;
          // имя колонки, длинна, возможность updat
    @Column(name = "Future",length = 20,unique = false,nullable = true,updatable = false)
    String name;

    @Version
    Integer version; // версия объекта, когда происходят новые операции с объектом - версия обновляется



    @Column(columnDefinition = "varchar(30) not null")  // код sql
    String  surname;

    @Transient  // поле не появится в базе( нужно для расчетов, к примеру )
    int tran=50;
    // или
    transient int tra=50; // поле не появится в базе( нужно для расчетов, к примеру )

     // @Temporal(TemporalType.TIMESTAMP)    // сохраняем дату хранения элементов (ошибка)
    // Date date=new Date();

    @Temporal(TemporalType.TIMESTAMP)
    Calendar calendar;           // календарь

    @Enumerated(EnumType.STRING)   // перечисления
    EnumStud enumStud;


    @Access(AccessType.PROPERTY) // доступ к значениям через геттер
    public String getSurname() {
        return "Mr. "+ surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ColumnStudent() {
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public ColumnStudent(String surname, String name, String c) {
        this.surname = surname;
        this.name = name;
        calendar=Calendar.getInstance();  // календарь
        calendar.setTime(new Date());

        if(c=="Alien")
        enumStud=EnumStud.Alien;
        if (c=="Male")                // перечисления
            enumStud=EnumStud.Male;


    }
}

enum EnumStud{Alien,Male,Female}