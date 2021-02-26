package jpa;

import jta.EjbBean;

import javax.ejb.EJB;
import javax.persistence.*;
import javax.transaction.*;
import javax.transaction.RollbackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jpa {

    @PrePersist    // слушает события с ColumnStudent
    void persist(ColumnStudent columnStudent)
    {
        System.out.println(columnStudent.getSurname());
    }

public static void main(String[] args) throws InterruptedException, SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

/*
 // Фабрика предостовляет доступ к интерфейсу EntityManager ( через него обращаемся к БД)
 // Фабрика определяет через настройки persistence.xml с какой ORM работать и какие Классы подключать и value="drop-and-create"
 EntityManagerFactory emf= Persistence.createEntityManagerFactory("Student");
// EntityManager обращаемся к БД
EntityManager em=emf.createEntityManager();

Student student=new Student();
student.name="SAI";
student.age=777;

EntityTransaction et=em.getTransaction();  // получаем транзакцию
et.begin();    // начинаем
em.persist(student);  // выполняем
et.commit();   // комитим

em.close();  //  EntityManager  ЗАКРЫВАЕМ
emf.close(); //  EntityManagerFactory ЗАКРЫВАЕМ

 /*
    em.getTransaction().begin();
    em.persist(new Student());       // или такой код
    em.close();
 */


                      // <exclude-unlisted-classes>false</exclude-unlisted-classes>  ( в persistence.xml пишем)
// Позволяет подключать все Классы помеченные @Entity к БД ( либо <class>jpa.Student</class> в ручную пишем)




                                      // TABLE (создание таблиц, нескольких)

EntityManagerFactory emf=Persistence.createEntityManagerFactory("Students");
EntityManager em=emf.createEntityManager();
//EntityTransaction et=em.getTransaction();



                // создание подтаблиц по ключу (@Id), генератор чисел по аннотациям с таблицей-генератор чисел
/*
  //  EntityTransaction et=em.getTransaction();
    et.begin();
    em.persist(new Student("AUM",9));
    em.persist(new Student("SHRI",7));
    em.persist(new Student("SAI",5));
    em.persist(new Student("RAM",3));
 //   et.commit();

 //   em.close();
 //   emf.close();





             // Создание таблицы по 2 ключам(@EmbeddedId) и выделение Отдельного класса(@Embeddable) под ключи, если большие данные или...


  //  EntityTransaction et=em.getTransaction();
  //  et.begin();
    em.persist(new EmbadablStudent("AUM","OM",9));
    em.persist(new EmbadablStudent("SHRI","Kriya",7));
    em.persist(new EmbadablStudent("SAI","SAI",5));
    em.persist(new EmbadablStudent("RAM","Babadgi",3));
  //  et.commit();

   // em.close();
   // emf.close();





             // @Basic определенные поля можно подгружать по использованию, если они редко используются и большие данные

  //  EntityTransaction et=em.getTransaction();
  //  et.begin();
    em.persist(new BasicStudent("AUM"));
    em.persist(new BasicStudent("SHRI"));
    em.persist(new BasicStudent("SAI"));
    em.persist(new BasicStudent("RAM"));
  //  et.commit();

  //  em.close();
 //   emf.close();

*/
               // @Enumerated(EnumType.STRING) + @Access(AccessType.PROPERTY) + @Temporal(TemporalType.TIMESTAMP) календарь
/*
    EntityTransaction et=em.getTransaction();
   et.begin();
    em.persist(new ColumnStudent("AUM","BABA","Alien"));
    em.persist(new ColumnStudent("SHRI","BABA","Alien"));
    em.persist(new ColumnStudent("SAI","BABA","Alien"));
    em.persist(new ColumnStudent("RAM","BABA","Alien"));
   et.commit();

    em.close();
    emf.close();
*/


                       // LIST и MAP в объекте + @Embedded и @Embeddable
  //  et.begin();
  //  em.persist(new Students("BABADGI",777));






                          // One to One (в главной создать SET и GET на объекте второй таблицы,
                                         // чтобы добавлять значения в др. таблицу)
/*
    et.begin();

    TeacherOne one=new TeacherOne("AUM");
    TeacherAdress adressTeach=new TeacherAdress(one);
    adressTeach.city="Chikago";
    adressTeach.adress="11-street";
    one.setAdress(adressTeach);

    em.persist(one);

    et.commit();

    em.close();
    emf.close();
*/




                               // Many to One(List объектов к одному объекту ) и One to Many ( Всегда хозяин)
/*
    et.begin();

    TeacherOne onemany=new TeacherOne("AUM"); // объект OnetoMany

    TeacherAdress adressTeach=new TeacherAdress(onemany); //  ManytoOne
    TeacherAdress adressTeach2=new TeacherAdress(onemany);

    List<TeacherAdress> list=new ArrayList<>();   // List объектов ManytoOne
    adressTeach.city="Chikago";
    adressTeach.adress="11-street";
    adressTeach2.city="Maykop";
    adressTeach2.adress="7-street";
    list.add(adressTeach);
    list.add(adressTeach2);

    onemany.setList(list);
    em.persist(onemany);

    et.commit();
*/


                                      // Many to Many(Все свазанны друг с другом)
/*
    et.begin();

    TeacherOne onemany=new TeacherOne("AUM"); // Many to Many объект
    TeacherOne onemany2=new TeacherOne("SAI");

    TeacherAdress adressTeach=new TeacherAdress(); //  Many to Many объект
    TeacherAdress adressTeach2=new TeacherAdress();


    List<TeacherAdress> listadress=new ArrayList<>();   // List объектов ManytoMany
    List<TeacherOne> listone=new ArrayList<>();   // List объектов ManytoMany

    adressTeach.city="Chikago";
    adressTeach.adress="11-street";
    adressTeach2.city="Maykop";
    adressTeach2.adress="7-street";


    listadress.add(adressTeach);  // добавляем в лист
    listadress.add(adressTeach2);
    listone.add(onemany);
    listone.add(onemany2);


    onemany.setList(listadress);
    adressTeach.setList(listone);


    em.persist(onemany);


    et.commit();
*/



                         // @OrderBy не работает
/*
    et.begin();
    em.persist(new Orderss("BABADGI"));
    et.commit();*/




                   // Стратегия наследования (extends) @MappedSuperclass(без @Entity на суперклассе) и @Inheritance(strategy = InheritanceType.JOINED)
/*
    et.begin();
    em.persist(new Worker("SAI",777));
    em.persist(new Player("AUM",999));
    et.commit();
*/


                  // find()  поиск по id в таблице
                  // getReference()  поиск по id в таблице
                  // remove() удаление
                 // @OneToOne(orphanRemoval = true)- удаление таблиц сирот
                 // flush()   записывает в БД в любом месте кода
                 // refresh() вернуть объект к значению из базы, в отдельной транзакции
                 // detach()  удаляет из persist объект
                 // clear()   очищает persist от всех объектов
                 // merge()  обновление данных, даже после detach()
/*
   em.getTransaction().begin();

    ColumnStudent columnStudent=new ColumnStudent("AUM","BABA","Alien");
    em.persist(columnStudent);
    em.find(ColumnStudent.class, 108);   //поиск по id в таблице
    System.out.println(columnStudent.getSurname());
    em.getReference(ColumnStudent.class, 109);   //поиск по id в таблице
    System.out.println(columnStudent.getSurname());
   // em.remove(columnStudent);         // удаление 1 объекта из таблицы
    System.out.println(columnStudent.getSurname());
    em.flush(); // записывает в БД в любом месте кода( без комита), но данные должны быть целостны иначе ошибка

    em.getTransaction().commit();

    columnStudent.setSurname("DFDF");
    System.out.println(columnStudent.getSurname()); // DFDF изменено на DFDF
    em.getTransaction().begin();
    em.refresh(columnStudent);  // если в коде изменить значение объекта, то refresh() должен вернуть его к значению из базы(для этого возвращаемое значение должно быть уже в базе)
    em.getTransaction().commit();
    System.out.println(columnStudent.getSurname()); // Mr. AUM в базе

    em.getTransaction().begin();
    System.out.println(em.contains(columnStudent)); // true
    em.detach(columnStudent);  // удаляет из persist объект (немного очищает память)
    em.clear();       // очищает persist от всех объектов
    System.out.println(em.contains(columnStudent)); // false
    em.getTransaction().commit();

    em.getTransaction().begin();
    columnStudent=em.find(ColumnStudent.class, 188);

    columnStudent.setSurname("BABADGIIII");

    System.out.println(columnStudent.getSurname());
    em.detach(columnStudent);
    //em.detach(columnStudent.getSurname());
    //System.out.println(columnStudent.getSurname()); // ошибка т.к. нет объекта после detach()
    em.merge(columnStudent);  // обновление данных, даже после detach()
    System.out.println(columnStudent.getSurname());
    em.getTransaction().commit();
*/


                            // JJJJPPPPQQQQLLLLL  JPQL

/*
    em.getTransaction().begin();
    em.persist(new ColumnStudent("AUM","BABA","Alien"));
    em.persist(new ColumnStudent("SHRI","BABA","Alien"));
    em.persist(new ColumnStudent("SAI","BABA","Alien"));
    em.persist(new ColumnStudent("RAM","BABA","Alien"));
    em.getTransaction().commit();


   // Query query3=em.createQuery("select s.Player.sum from Worker s");
  //  List<Integer> list3=query3.getResultList();
    for (Integer e:list3)
    {
        System.out.println(e);
    }

                                         // Запросы как в sql

  //  Query query=em.createQuery("select new jpa.ColumnStudent(s.name,s.surname,s.name) from ColumnStudent s");
    Query query=em.createQuery("select c from ColumnStudent c where  c.surname='Mr. SAI'");
    List<ColumnStudent> list=query.getResultList();
    for (ColumnStudent e:list)
    {
        System.out.println(e.id+" "+e.getSurname());
    }

   // Query query2=em.createQuery("select case s.id when 200 then 5 else 10 end from ColumnStudent s");
    Query query2=em.createQuery("select max(s.id) from ColumnStudent s");
    List<Integer> list2=query2.getResultList();
    for (Integer e:list2)
    {
        System.out.println(e);
    }


    Query query6=em.createQuery("select count(s) from ColumnStudent s");
    List<Long> list6=query6.getResultList();
    for (Long e:list6)
    {
        System.out.println(e);
    }

    Query query7=em.createQuery("select distinct s.surname from ColumnStudent s");
    Query query7=em.createQuery("select UPPER(s.surname) from ColumnStudent s");
    List<String> list7=query7.getResultList();
    for (String e:list7)
    {
        System.out.println(e);
    }
*/

                               // like
                              // in
                              // between
                               // or
/*
  //  Query query8=em.createQuery("select s.surname from ColumnStudent s where surname='Mr. SAI' or surname='Mr. SHRI'");
  //  Query query8=em.createQuery("select s.surname from ColumnStudent s where s.id>150");
  //  Query query8=em.createQuery("select s.surname from ColumnStudent s where s.id between 150 and 200");
  //  Query query8=em.createQuery("select s.surname from ColumnStudent s where s.id in (150,200,110,188)");
  //  Query query8=em.createQuery("select s.surname from ColumnStudent s where s.enumStud is not null ");
  //  Query query8=em.createQuery("select s.surname from ColumnStudent s where s.surname like '%AU%'");
  //  Query query8=em.createQuery("select s.surname from ColumnStudent s where s.id=(select c.id from ColumnStudent c where c.surname='Mr. SHRI') ");
    Query query8=em.createQuery("select s.surname from ColumnStudent s order by s.surname desc ");
    List<String> list8=query8.getResultList();
    for (String e:list8)
    {
        System.out.println(e);
    }

    Query query4=em.createQuery("select new jpa.ColumnStudent(s.name,s.surname,s.name) from ColumnStudent s");
      List<ColumnStudent> list4=query4.getResultList();
    for (ColumnStudent e:list4)
    {
        System.out.println(e.name+" "+e.surname);
    }
*/

                                 // group by
                                // having
                                // order by
/*
   // Query query=em.createQuery("select s from ColumnStudent s order by s.surname" );
   // Query query=em.createQuery("select count(s) from ColumnStudent s  order by s.surname" );
  //  Query query=em.createQuery("select count(s) from ColumnStudent s where s.id>100 group by s.surname" );
    Query query=em.createQuery("select s.surname from ColumnStudent s where s.id>100 group by s.surname having count(s)>1" );
    List<String> list=query.getResultList();
    for (String e:list)
    {
        System.out.println(e);
    }
*/


                                 // update изменяет в объекте
 /*                                // delete удаляет
    em.getTransaction().begin();
    Query query1=em.createQuery("update ColumnStudent s set s.surname='SAI RAM' where s.surname='Mr. AUM' and s.id=110");
    query1.executeUpdate();
    Query query2=em.createQuery("delete from ColumnStudent s where s.id=181 or s.surname='Mr. Mr. AUM'");
    query2.executeUpdate();
    em.getTransaction().commit();
*/


                                 // TypedQuery getSingleResult() для типа данных-class
                                 // setParameter(1,194) можно вставлять параметры, как в jdbc
                                 // setMaxResults(2); не больше 2 значений получим
/*
  //  TypedQuery<ColumnStudent> typedQuery=em.createQuery("select s from ColumnStudent s where s.id=175",ColumnStudent.class);
  //  TypedQuery<ColumnStudent> typedQuery=em.createQuery("select s from ColumnStudent s where s.id=?1 or s.surname=?2",ColumnStudent.class);
  //  TypedQuery<ColumnStudent> typedQuery=em.createQuery("select s from ColumnStudent s where s.id=:idOne or s.id=:idTwo",ColumnStudent.class);
    TypedQuery<ColumnStudent> typedQuery=em.createQuery("select s from ColumnStudent s where s.surname=?1 ",ColumnStudent.class).setParameter(1,"SAI RAM").setMaxResults(2);
  //  typedQuery.setParameter(1,194);
  //  typedQuery.setParameter(2,"Swer");
  //  typedQuery.setParameter("idOne",194);
  //  typedQuery.setParameter("idTwo",200);
  //  ColumnStudent columnStudent=typedQuery.getSingleResult();
    //  System.out.println(columnStudent.surname);
    List<ColumnStudent> list1 =  typedQuery.getResultList();
    for (ColumnStudent e:list1)
    {
        System.out.println(e.surname);
    }
*/

                                   // @NamedQueries и @NamedQuery
                                   // (создаем на классе, здесь вызываем)
                                // @NamedQueries для JPQL запросов @NamedNativeQuery для sql запросов
                                // createNativeQuery для sql запросов

  //  Query query3=em.createNamedQuery(ColumnStudent.FIND_ALL,ColumnStudent.class);
  //  Query query3=em.createNamedQuery("getByids",ColumnStudent.class).setParameter(1,188);
  //  Query query3=em.createNamedQuery("getAll",ColumnStudent.class);
 /*   Query query3=em.createNativeQuery("select * from ColumnStudent",ColumnStudent.class); // для sql запросов
    List<ColumnStudent> list1 =  query3.getResultList();

    for (ColumnStudent e:list1)
    {
        System.out.println(e.surname);
    }*/


                                      // @NamedStoredProcedureQuery (процедуры)
 /*  // 1 вариант через @NamedStoredProcedureQuery на классе

    em.getTransaction().begin();
    Query query=em.createNamedStoredProcedureQuery("updateColumnStudent");
    query.setParameter("studId", 188);
    query.setParameter("nName", "SAIRAM");
    query.executeUpdate();
    em.getTransaction().commit();


    // 2 вариант без аннотации

    em.getTransaction().begin();
    StoredProcedureQuery ColumSt= em.createStoredProcedureQuery("updateColumnStudent");
    ColumSt.registerStoredProcedureParameter("studId", Integer.class, ParameterMode.IN);
    ColumSt.registerStoredProcedureParameter("nName",String.class,ParameterMode.IN);
    ColumSt.setParameter("studId", 110);
    ColumSt.setParameter("nName", "SAIRAM");
    ColumSt.execute();
    em.getTransaction().commit();
*/


                           // Кэш 2 уровня (есть PersistentContext в нем сохраняются данные и в кэш 2уровня они сохраняются,
                                            // чтобы не лезть в БД- можно получать данные из кэша 2)
/*
    em.getTransaction().begin();
    ColumnStudent columnStudent=new ColumnStudent("SAI","AUM","Alien");
    em.persist(columnStudent);
    em.persist(new ColumnStudent("SAI2","AUM","Alien"));
    em.getTransaction().commit();

    Cache cache= emf.getCache();
    System.out.println(cache.contains(ColumnStudent.class,columnStudent.getSurname())); //получаем кэш 2 уровня должен true но false
    cache.evict(ColumnStudent.class,columnStudent); // чистим кэш 2 уровня
    cache.evictAll();
    System.out.println(cache.contains(ColumnStudent.class,columnStudent.getSurname())); // false
*/


                              // @Version + Integer version в классе
                             // версия объекта, когда происходят новые операции с объектом - версия обновляется
                             // и в БД создается новая колонка с версией
/*
    em.getTransaction().begin();
    ColumnStudent columnStudent=new ColumnStudent("SAI","AUM","Alien");
    em.persist(columnStudent);
    System.out.println(columnStudent.getVersion()); // 0
    columnStudent.setSurname("IMRAM");
    System.out.println(columnStudent.getVersion()); // 0
    em.persist(new ColumnStudent("SAI2","AUM","Alien"));
    em.getTransaction().commit();
    System.out.println(columnStudent.getVersion());  // 1 SAI2


    em.getTransaction().begin();
    em.merge(columnStudent); // обновился IMRAM
    em.getTransaction().commit();
    System.out.println(columnStudent.getVersion()); // 2 IMRAM
*/




                                          // LockModeType.OPTIMISTIC- выбрасывает Exception (на drop-and-create)
                                          //  PESSIMISTIC_WRITE- сохраняет, но часто нельзя, большой объем (лочит поток, нельзя не записать не прочитать)
                                         // PESSIMISTIC_READ- позволяет читать данные другим
                                          // когда два пользователя одновременно пытаются записать данные,
                                          // то может быть потеря данных
                                         // Борьба с потерей данных и конкуренцией

/*
    EntityManager em2=emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(new ColumnStudent("SAIIMRAM", "AUM", "Alien"));
    em.getTransaction().commit();


    new Thread() {
        @Override
        public void run() {
           em.getTransaction().begin();
            ColumnStudent columnStudent=em.find(ColumnStudent.class, 1,LockModeType.PESSIMISTIC_READ);
          // em.lock(columnStudent,LockModeType.OPTIMISTIC); // можно отдельно использовать
            columnStudent.setSurname(columnStudent.getSurname()+" 3");


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            em.getTransaction().commit();
        }

    } .start();


    new Thread() {
        @Override
        public void run() {
            em2.getTransaction().begin();
            ColumnStudent columnStudent=em2.find(ColumnStudent.class, 1,LockModeType.PESSIMISTIC_WRITE);
            columnStudent.setSurname(columnStudent.getSurname()+" 4");
            em2.getTransaction().commit();
        }

    } .start();

    Thread.sleep(2000);
    em2.close();
*/



                                           // Жизненый цикл Entity
                                           // persist -- @PrePersist @PostPersist
                                           // merge, refresh -- @PostLoad
                                           // remove -- @PostUpdate @PreUpdate
/*
    em.getTransaction().begin();
    ColumnStudent columnStudent=new ColumnStudent("SAI","AUM","Alien"); // в памяти - не managed
    em.persist(columnStudent);          // @PrePersist @PostPersist в persiste
    em.getTransaction().commit();

    em.getTransaction().begin();
 //   em.detach(columnStudent);
 //   em.merge(columnStudent);            // @PostLoad
    columnStudent.setSurname("AUMAUMAUM");  // @PreUpdate  @PostUpdate
    em.refresh(columnStudent);          // @PostLoad
    em.getTransaction().commit();

    em.getTransaction().begin();
    em.remove(columnStudent);    // @PostUpdate @PreUpdate
    em.getTransaction().commit();
    em.close();
    emf.close();
*/





                             // EntityGraph    все поля FetchType.LAZY(получаем по требования при select объекта), кроме @Basic и @NamedEntityGraph
                           // @NamedEntityGraphs
/*
    em.getTransaction().begin();
    em.persist(new Graph("SAIIMRAM", "AUM", "Moscow",111));
    em.persist(new Graph("SAIIMRAM2", "AUM2", "Moscow",333));
    em.persist(new Graph("SAIIMRAM3", "AUM3", "Moscow",555));
    em.getTransaction().commit();


   // EntityGraph graph2=em.createEntityGraph("getOnly"); // для @NamedEntityGraphs
    EntityGraph<Graph> graph=em.createEntityGraph(Graph.class);
    graph.addAttributeNodes("adress");
    Map fetch=new HashMap();
    fetch.put("javax.persistence.fetchgraph", graph); // получаем только из addAttributeNodes("adress");
  //  fetch.put("javax.persistence.fetchgraph", graph2); // для @NamedEntityGraphs
    Map load=new HashMap();
    load.put("javax.persistence.loadgraph", graph);  // получаем addAttributeNodes("adress") и @Basic(fetch = FetchType.EAGER) поля
  //  load.put("javax.persistence.loadgraph", graph2); // для @NamedEntityGraphs
    Graph graph1=em.find(Graph.class,1,load);
    Graph graph2=em.find(Graph.class,1,fetch);
    System.out.println(graph1.age);
    System.out.println(graph2.name);


    List<Graph> list=em.createQuery("select g from Graph g").setHint("javax.persistence.fetchgraph", graph).getResultList();
    for (Graph e:list)
    {
        System.out.println(e.id+e.name+e.surname+e.age);
    }
*/

    em.getTransaction().begin();
    em.persist(new BasicStudent("САИ",111));
    em.persist(new BasicStudent("AUM2", 333));
    em.persist(new BasicStudent("AUM3", 555));
    em.getTransaction().commit();


    //Query query=em.createQuery("select new jpa.ColumnStudent(s.name,s.surname,s.name) from ColumnStudent s");
    Query query=em.createQuery("select c from BasicStudent c ");
    List<BasicStudent> list=query.getResultList();
    for (BasicStudent e:list)
    {
        System.out.println(e.id+" "+e.name+e.age);
    }

    em.close();
    emf.close();

}
}
