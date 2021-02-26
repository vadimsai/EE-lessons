package dependencyingection;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


// внедрение зависимостей @Inject- внедряет бин
// @Qualifier когда несколько implements, то создаем свою анотацию и помечаем( распределение аннотаций)

@WebServlet("/DependenciIngection")
public class DependenciIngection extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Inject
   @Peop   // собственная аннотация
   Person p;

  /*  @Inject
    String a;
    @Inject
    int d;
    @Inject
    double f;
    @Inject
    Car my;

    @Pip  // помечаем своей анотацией чтобы было понятно какой бин, т.к. два String
    @Inject
    String g;*/


   /* @Inject
    Car my;*/

   /* @Inject
    MyBean myBean;
    @Inject
    ChangheMyBean changheMyBean;*/


   /* @Inject
    ConversSc conversSc;*/

   /* @Inject
    MyBeanE myBeanE;*/

   /* @Inject
    LiveCycleBean liveCycleBean;*/

   /* @Inject
    Doing d; */

   /* @Inject
    Pak pak; */

  /*  @Inject
     BookService bookService;

    @Inject
    Subscribe subscribe; */

   /* @Inject
    A a; */

    /* @Resource
    ExecutorService executorService;*/

                                                //Bean validation( анотации для проверки полей по значению)

  /*  @Inject
    Person person;

  //  @Inject
  //  Validation validation;*/

 /*   @Inject
    Validator validator;

    @Inject
    Person person;*/



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(p.getName());
      //  response.getWriter().write(a+" "+d+" "+f+" "+my.name+" "+g);
      //  System.out.println(a+" "+d+" "+f+" "+my.name+" "+g);
      //  response.getWriter().write(my.name);

       /* myBean.i=5;
        changheMyBean.chanchemybean();

        response.getWriter().write(myBean.i+" ");
        response.getWriter().write(" "+changheMyBean.myBean.i);
        System.out.println(myBean.i);
        System.out.println(changheMyBean.myBean.i);*/


                                              // ConversationScoped

      /*  System.out.println(conversSc.i);    //  0
        conversSc.i=5;
        conversSc.startConv();
        System.out.println(conversSc.i);      //  5
        conversSc.Job();                      //  2
        conversSc.i=3;
        conversSc.endConv();                  //  2
        System.out.println(conversSc.i);*/    //  3


      /*  RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/BeanExpress.jsp");
        dispatcher.forward(request,response);*/


                                     // Жизненный цикл Бина
      /*  liveCycleBean.Job();
        liveCycleBean.Job2(); */

      /*  d.Job(); */

      /*  pak.print(); */

      /*  Book b=new Book("Mahabharata");
        bookService.addBook(b);
        bookService.addBook(new Book("SAI"));
        bookService.remooveBook(b);

        System.out.println(subscribe.list.size()+"");
        System.out.println(subscribe.list.get(0).getName()+""+subscribe.list.get(1).getName()+"");
        response.getWriter().write(subscribe.list.size()+"");
        response.getWriter().write(subscribe.list.get(0).getName()+""+subscribe.list.get(1).getName()+"");

       */


        /* a.print(); */

       /* executorService.submit(new P());

        try {
            executorService.submit(new S()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

                                        // Validation

       /* person.name="SAI";
        person.age=777;

        ValidatorFactory validatorFactory=Validation.buildDefaultValidatorFactory(); // создаем валидатор для вызова в main
        Validator validator=validatorFactory.getValidator();

        Set<ConstraintViolation<Person>> validate=validator.validate(person); // если есть ошибки кладем из в Set
        if(validate.size()>0) // ошибка-размер >0
        {
            System.out.println(" some error");
        }

        for (ConstraintViolation<Person> e:validate) // получаем ошибки
        {
            System.out.println(e.getMessage());  // сообщение ошибки
            System.out.println(e.getInvalidValue()); // ошибочное значение
        }

        Set<ConstraintViolation<Person>> name=validator.validateProperty(person,"name"); // проверяем конкретное значение(name)
        if (name.size()>0)
        {
           System.out.println("Name is wrong");
        }

        Set<ConstraintViolation<Person>> name2=validator.validateValue(Person.class,"name","AUM");  // проверяем без создания экземпляра класса Person конкретное значение(name)
        if(name2.size()>0)
        {
            System.out.println("Name is wrong");
        }

        try {
            Method set=Person.class.getMethod("setSurname", String.class);
            ExecutableValidator executableValidator=validator.forExecutables();
            Set<ConstraintViolation<Class<Person>>> metod=executableValidator.validateParameters(Person.class,set,new Object[]{"Aum"});  // проверяем параметры методов на конкретное значение
            if(metod.size()>0)
            {
                System.out.println("parametres was wrong");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }*/

     /*   Set<ConstraintViolation<Pes>> valemail=validator.validateValue(Pes.class, "email", "asd@mai.com");
        for (ConstraintViolation<Pes> e:valemail)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getInvalidValue());
        }

        Set<ConstraintViolation<Pes>> valema=validator.validateValue(Pes.class, "email", "asd@mai.ru");
        for (ConstraintViolation<Pes> e:valema)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getInvalidValue());
        } */
/*
       Set<ConstraintViolation<Pes>> site =validator.validateValue(Pes.class, "site", "https://mai.ru");
        for (ConstraintViolation<Pes> e:site)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getInvalidValue());
        }
        Set<ConstraintViolation<Pes>> site2=validator.validateValue(Pes.class, "site2", "http://mai.ru:21");
        for (ConstraintViolation<Pes> e:site2)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getInvalidValue());
        }
        Set<ConstraintViolation<Pes>> site3=validator.validateValue(Pes.class, "site3", "https://mai.ru");
        for (ConstraintViolation<Pes> e:site3)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getInvalidValue());
        }
        Set<ConstraintViolation<Pes>> site4=validator.validateValue(Pes.class, "site4", "https://mai.com:22");
        for (ConstraintViolation<Pes> e:site4)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getInvalidValue());
        }*/

        /*
        person.setBirsday(LocalDate.of(2017,01,02));    //???????? не работает
        person.setDeath(LocalDate.of(2019,01,02));

        Set<ConstraintViolation<Person>> date=validator.validate(person);
        for (ConstraintViolation e:date)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getInvalidValue());
        }*/


        /*
        person.s="as";
        person.s2="";
        person.s3=null;
        person.s4="";


        Set<ConstraintViolation<Person>> date=validator.validate(person,MyGroup3.class); // добавляем группу для валидации, т.е. выбираем через группу какой параметр валедировать
        for (ConstraintViolation<Person> e:date)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getInvalidValue());
        }*/



    }
}

interface Person
{
   String getName();
}

// создание собственной аннотации
@Qualifier
@Retention(RUNTIME)  // когда аннотация будет доступна
@Target(value = {ElementType.FIELD, ElementType.TYPE, ElementType.METHOD}) // элементы к которым аннотация должна быть применена.
@interface St{} // имя анотации


@St // собственная аннотация
class Student implements Person
{
    String name;

    public String getName() {
        name="SAI";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Qualifier
@Retention(RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@interface Peop{}


@Peop  // собственная аннотация
class People implements Person {
    String name;
    @Override
    public String getName() {
        name="AUM";
        return name;
    }
}


                                              //Alternative (вместо @Qualifier ( для всех Person p- будет Student))
/*

в validation.xml надо прописывать
    <alternatives>
        <class>Student</class>
    </alternatives>


interface Person
{
    String getName();
}

@Alternative
class Student implements Person
{ String name;
    public String getName() {
        name="SAI";
        return name;
    }
}

class People implements Person {
    String name;
    @Override
    public String getName() {
        name="AUM";
        return name;
    }
}*/


                             // Producers( позволяет внудрять примитивные типы и настраивать бины)
/*
@Qualifier
@Retention(RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@interface Pip{}  // для одного String

class Pod
{
    @Produces
    String s="SAI AUM";

    @Produces
            @Pip  // помечаем чтобы было понятно какой бин
    String s2= "TAT";

    @Produces
    int i=999;
    @Produces
    double d=3.3;

    @Produces
    public Car get()
    {
        return new Car("BABADGI");
    }
}
class Car
{
    String name;

    public Car(String name)
    {
        this.name=name;
    }
}*/



                                  // Disposes(очистка ресурсов после остановки)
/*
class Pod
{
    @Produces
    public Car get()
    {
        return new Car("BABADGI");
    }

    public void clean(@Disposes Car car)  // очищаем, сам сработает после остановки
    {
        car.clean();
    }

}
class Car
{
    String name;

    public Car(String name)
    {
        this.name=name;
    }
    public void clean()  // метод очистка
    {
        System.out.println("clean car");
    }
}*/


                                    // Scope бинов ( масштаб )

/*//@ApplicationScoped
//@RequestScoped   // для всего Requestа
//@SessionScoped
//@ConversationScoped
@Dependent  // при каждом обращении внедряет бин
class MyBean
{
    int i;
}

class ChangheMyBean
{
    @Inject
    MyBean myBean;

    public void chanchemybean()
    {
        myBean.i=2;
    }
}*/


                                  // ConversationScoped (2 зависимости на одном классе ConversSc 1 в самом классе, 2 в сервлете , поэтому разная область видимости и можем управлять ею )

/*@ConversationScoped
class ConversSc implements Serializable
{
    int i;

    @Inject
    Conversation conversation;
    public void startConv()
    {
        System.out.println("start conv");

        conversation.begin();
        i=2;
    }

    public void Job()
    {
        System.out.println(i);
    }

    public void endConv()
    {
        System.out.println("End conv");
        System.out.println(i);
        conversation.end();
    }
}*/



                             // Бины и Expression Language

/*@RequestScoped  //  обязательно выставить область видимости (Request или../) т.кю по умолчанию @Dependent  // при каждом обращении внедряет бин
@Named(" Vadim ")
class MyBeanE
{
   private String s = "SAI AUM";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}*/



                                  // Жизненный цикл Бина  (Круто но так не делается)

/*class  LiveCycleBean
{
    public void LiveBegin()
    {
        System.out.println("construct");
    }

    @PostConstruct
    private   void postConstruct()     // делает код после конструктора
    {
        System.out.println("post construct");
    }

    @AroundInvoke
    private Object aroundMethod(InvocationContext c) throws Exception // делает перед методами
    {
        System.out.println("befor method");
        return c.proceed();
    }

    public void Job()
    {
        System.out.println("do job");
    }

    public void Job2()
    {
        System.out.println("do job2");
    }

    @PreDestroy
    private void preDestroy()     // делает код перед уничтожением
    {
        System.out.println("destroy live cycle bean");
    }
}*/


                                       // Interceptors( делать так, можем вызывать у сколько угодно классов)

/*
class Interceptorss
{
    @AroundConstruct
    private void aroundConstract(InvocationContext a) throws Exception  // делает код перед конструктором
    {
        System.out.println("befor constract");
        a.proceed();
    }


    @PostConstruct
    private   void postConstruct(InvocationContext p) throws Exception     // делает код после конструктора
    {
        System.out.println("post construct");
        p.proceed();
    }

    @AroundInvoke
    private Object aroundMethod(InvocationContext c) throws Exception // делает перед методами
    {
        System.out.println("befor method");
        return c.proceed();
    }

    @PreDestroy
    private void preDestroy(InvocationContext d) throws Exception     // делает код перед уничтожением
    {
        System.out.println("destroy ");
        d.proceed();
    }
}
@RequestScoped
@Interceptors(Interceptorss.class)   // для вызов методов Interceptorss
class Doing
{
    public Doing() {
        System.out.println("consructor");
    }

    @Interceptors(Interceptorss.class)   // будет вызываться aroundMethod
    public void Job()
    {
        System.out.println("do job");
    }

   // @ExcludeClassInterceptors      // не будет вызываться aroundMethod
    public void Job2()
    {
        System.out.println("do job2");
    }
}*/


/*                                       // Цепочки Interceptors
class InterceptorOne
{
    @AroundInvoke
    private Object aroundInvoke(InvocationContext a) throws Exception {
        System.out.println("one");
         return a.proceed();
    }
}
class InterceptorTwo
{
    @AroundInvoke
    private Object aroundInvoke(InvocationContext a) throws Exception {
        System.out.println("two");
        return a.proceed();
    }
}
class InterceptorThree
{
    @AroundInvoke
    private Object aroundInvoke(InvocationContext a) throws Exception {
        System.out.println("three");
        return a.proceed();
    }
}
class InterceptorFour
{
    @AroundInvoke
    private Object aroundInvoke(InvocationContext a) throws Exception {
        System.out.println("four");
        return a.proceed();
    }
}


@Interceptors({InterceptorOne.class,InterceptorTwo.class})   // Два Interceptorа на классе
class Doing
{
    @Interceptors({InterceptorThree.class, InterceptorFour.class})   // Два Interceptorа на методе
    public void Job() {
        System.out.println("do job");
    }
}*/





                                           //  Interceptors Binding(так правильно цепочки)

/*
++++++++++++++++++ В beans прописываем
<interceptors>
        <class>InterceptorOne</class>
        <class>InterceptorTwo</class>
    </interceptors>
+++++++++++++++++++++++++++++


@InterceptorBinding          //  создаем свою анотацию
@Retention(RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@interface One{}


@One
@Interceptor              // помечаем своим (@InterceptorBinding ) и @Interceptor
class InterceptorOne
{
    @AroundInvoke
    private Object aroundInvoke(InvocationContext a) throws Exception
    {
        System.out.println("one");
        return a.proceed();
    }
}

@InterceptorBinding
@Retention(RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@interface Two{}


@Two
@Interceptor
class InterceptorTwo
{
    @AroundInvoke
    private Object aroundInvoke(InvocationContext a) throws Exception
    {
        System.out.println("two");
        return a.proceed();
    }
}


@One          //  вызывам до выполнения методов  при помощи (@One  @Two)
class Doing
{

   @Two
    public void Job()
   {
      System.out.println("do job");
   }
}*/




                                      //  Decorator (обертка для интерфейса, возможность доп реализации при вызове метода)
/*
+++++++++++++++++++
<decorators>
<class>vad.Decor</class>   //указываем кто декоратор
</decorators>
++++++++++++++++++++++


interface Pak
{
    void print();
}

class Obdet implements Pak
{
    @Override
    public void print() {
        System.out.println(" Print Obdet");
    }
}

@Decorator
class Decor implements Pak   // обертка для Pak, реализует еще код и при вызове метода будет все выводить
{
    @Delegate
    @Inject
    Pak pak;

    @Override
    public void print()
    {
        System.out.println(" befor");
        pak.print();
        System.out.println(" after");
    }

}*/



                                            //Bean events ( Observ слушатель)


/*
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER,ElementType.METHOD})
@interface Add{}


@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER,ElementType.METHOD})
@interface Remoove{}      //  создаем свою анотацию ( добавляем PARAMETER)

class Book
{
    String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class BookService   //  класс выполняющий работу
{
    @Inject
    @Add        //свою анотацию
    Event<Book> addevent;


    @Inject
    @Remoove   //свою анотацию
    Event<Book> remooveevent;

    public void addBook(Book book)
    {
        System.out.println(book.getName()+" add book");
        addevent.fire(book);    // метод
    }
    public void remooveBook(Book book)
    {
        System.out.println(book.getName()+" delete book");
        remooveevent.fire(book); // метод
    }

}

@Singleton
class Subscribe     // класс слушатель делает когда что то происходит, там где слушает (BookService)
{
    List<Book> list=new ArrayList<>();


    public void addBsubc(@Observes @Add Book book)
    {
        System.out.println(book.getName()+" add list");
        list.add(book);
    }


    public void deleteBsubc(@Observes @Remoove Book book)  //добавляем в параметры анотацию @Observes и свою)
    {
        System.out.println(book.getName()+" delete list");
        list.remove(book);
    }

}*/


                                           // @Specializes( в иерархии различных классов хотим использовать один из классов)

/*
interface A
{
    public void print();
}

class B implements A
{
    @Override
    public void print() {
        System.out.println("B");
    }
}

@Specializes     //  ( @Inject во всех местах где используется A)
class C extends B
{
    @Override
    public void print() {
        super.print();
        System.out.println("C");     // sout  B C
    }
}*/




                                              // Пул потоков и конкурениця ( те же классы, что в SE только Managed приставка)
                                              //  НЕТ Managed скорее всего нет библитоки в maven или уже по другому


/*
class P implements Runnable
{
    @Override
    public void run() {
        System.out.println(" Runnable");
    }
}

class S implements Callable<String>
{
    @Override
    public String call() throws Exception {
        return "SAI";
    }
}*/



                                      //Bean validation( анотации для проверки полей по значению)

/*
class Person
{
    @NotNull   // не ноль значение
    @Pattern.List({ @Pattern(regexp="[A-Z][a-z]"), @Pattern(regexp = " ")})  // несколько анотаций с регуляпным выражением
    String name;

    @Min(18)
    int age;

    @Size(max = 200,min = 0)  // размер строки, количю символов
    String desc;

    @Past      // для даты
    Date datab;

    @Future
    Date datad;

    String surname;

    @NotNull
    public String getSurname() {
        return surname;
    }

    public void setSurname(@NotNull @Pattern(regexp = "[A-Z]") String surname) // анотации в параметрах
    {
        this.surname = surname;
    }
}*/

                                               // Композитный валидатор(создание своего валидатора)

/*
class  Pes
{
    @Sai
    String email;

    @CheckSiteUrl // моя анотация
    String site;
    @CheckSiteUrl(protocol="http") // проверяемое значение для этой переменной(site2)
    String site2;
    @CheckSiteUrl(port = 21)
    String site3;
    @CheckSiteUrl(host = "mysite.com")
    String site4;
}

class UrlValidat implements ConstraintValidator<CheckSiteUrl,String> {
    int port;
    String host;
    String protocol;

    @Override
    public void initialize(CheckSiteUrl url) // инициализация валидных значений
    {
        this.host = url.host();
        this.port = url.port();
        this.protocol = url.protocol();

    }

    @Override    //  вся логика проверки в этом методе
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.equals(""))
        {
            return true; // т.к. может проверятся в @NotNull, иначе двойная проверка
        }

        URL url;
        try {
            url = new URL(s); // передаем строку (чтобы распарсить)
        } catch (MalformedURLException e) {
            return false;
        }
                                                      // и свой параметр с параметром передавемого значения
        if (protocol != null && protocol.length() > 0 && !protocol.equals(url.getProtocol())) {
            constraintValidatorContext.disableDefaultConstraintViolation();       // получаемое сообщение при ошибке
            constraintValidatorContext.buildConstraintViolationWithTemplate("protocol invalid").addConstraintViolation();
            return false;
        }
                                              // и свой параметр с параметром передавемого значения
        if (host != null && host.length() > 0 && !host.equals(url.getHost()))
        {
              constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("host invalid").addConstraintViolation();
            return false;
        }
                       // и свой параметр с параметром передавемого значения
        if (port != -1 && port!=url.getPort())
        {
       //     constraintValidatorContext.disableDefaultConstraintViolation();
       //     constraintValidatorContext.buildConstraintViolationWithTemplate("port invalid").addConstraintViolation();
            return false;
        }
        return true;
    }
}*/


                                                     // Валидация классов - не работает
/*
@ChronoDates
class Person
{
    LocalDate birsday;
    LocalDate death;

    public LocalDate getDeath() {
        return death;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    public LocalDate getBirsday() {
        return birsday;
    }

    public void setBirsday(LocalDate birsday) {
        this.birsday = birsday;
    }
}

class ChronpValid implements ConstraintValidator<ChronoDates,Person>  // Логика проверки, передаем класс и интерфейс валидный
{
    @Override
    public void initialize(ChronoDates c) {

    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        return person.birsday.isBefore(person.death); // что раньше рождение
    }
}*/




                                     //  Группы валидации (валидируем по группам, т.е. выбираем через группу какой параметр валедировать)

/*
interface MyGroup{}  // у @NotNull есть параметр- java.lang.Class<?>[] groups() default {};
interface MyGroup2{}
interface MyGroup3{}
interface MyGroup4{}

class Person
{
    @NotNull(groups = MyGroup.class)
    String s;
    @NotNull(groups = {MyGroup2.class,MyGroup3.class})
    String s2;
    @NotNull(groups = MyGroup3.class)
    String s3;
    @NotNull(groups = Default.class)
    String s4;
}*/





