package itdvn.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaMain {

    public static void fire(Object obj)
    {
        System.out.println("SAI");
    }

    public static void main(String[] args) {

// Лямбда-выражение — это, по сути. реализация функционального интерфейса.
// Где видим интерфейс с одним методом — значит, такой анонимный класс можем переписать через лямбду

        long l1=System.nanoTime();
        Operat operat = new Operat() {   // анонимная функция
            @Override
            public int calcul(int a, int b) {

                return a + b;
            }
        };
        long l2=System.nanoTime();

        int su=operat.calcul(333,777);
        System.out.println("Время выполнения анонимной функции: "+(l2-l1));

        long l3=System.nanoTime();
        Operat sum = (a,b) -> { return a + b; };
        long l4=System.nanoTime();
        System.out.println("Время выполнения лямбды: "+(l3-l4));


        Operat sum1 = (a,b) -> { return a + b; }; // лямбда выражение (можно static переменные использовать, но нельзя дублировать обычные)
        Operat sub = (a,b) -> { return a - b; };
        Operat div = (a,b) -> { return a / b; };
        Operat multiple = (a,b) -> { return a * b; };


        int s=sum1.calcul(777,333);
        int subb=sub.calcul(777,333);
        int d=div.calcul(777,333);
        int m=multiple.calcul(777,333);
        System.out.println(s+subb+d+m);


        Switcher switcher=new Switcher();
        Lampa lampa=new Lampa();
        Radio radio=new Radio();

        switcher.add(lampa);
        switcher.add(radio);

        String message="AUM";

        // Анонимный класс
        switcher.add(new ElectricConsumer() {  // Создаем объект интерфейса и переопределяем метод и передаем сообщение
            @Override
            public void electricOn(Object obj) {
                System.out.println(message);
            }
        });


        switcher.add(obj -> System.out.println(message)); // используем лямбда вместо анонимного класса

        // ::  указывает на то что используется именно метод fire
        // сокращение :: возможно когда в методе количество параметров совпадает
        switcher.add(LambdaMain::fire); // Создали static метод в LambdaMain и в лямбда вызываем его

        switcher.switchOn();


        // Stream

        List<Person> list=new ArrayList<>();
        list.add(new Person("SAI",777));
        list.add(new Person("AUM",999));
        list.add(new Person("BABA",333));
        list.add(new Person("RAMA",111));
        list.add(new Person("BABADGI",555));


        list.stream().filter(e-> e.getAge()>=100).
                sorted(Comparator.comparing(Person::getName)). //sorted((p1,p2)->p1.getName().compareTo(p2.getName()))
                map(Person::getName).          // map(person->person.getName)
                forEach(System.out::println); // forEach((String n)-> System.out.println(n))


        List<Integer> list1=Arrays.asList(45,56,77,4,2,678,8,8,8,9).
                stream().
                distinct(). // убирает дубликаты
                sorted().
                collect(Collectors.toList());
        list1.forEach(System.out::println);

        Stream<Integer> stream=Stream.of(45,56,77,4,2,678,8,8,8,9);

        String[] str={"SAI","RAM","AUM"};
        Stream<String> stringStream=Arrays.stream(str);

        Stream.builder().add(12).add(334).add(55).add(334).build();

        IntStream c="BABA".chars(); // к числ
        c.forEach(System.out::println);


        //  Optional работа с null
        Optional<Integer> o=Optional.empty(); // пустой-ошибка
        Optional<Integer> o1=Optional.of(10);
        Optional<Integer> o2=Optional.ofNullable(null); // проверяет на null

        System.out.println(o1+""+o2);

        String s1;

        if (getS().isPresent()) // isPresent() возвращает value != null;
        {
            s1=getS().get();
            System.out.println(s1);
        }
        // или
        s1=getS().orElseThrow(null); // возвращает value != null;
        System.out.println(s1);

    //   @FunctionalInterface  вовращающие лямбда выражения( Predicate, Consumer, Supplier)
        Predicate<Person> pN=e->e.getName().length()>3;
        Predicate<Person> pA=e->e.getAge()>111;

        //allMatchers(person,pN.and(pA));

    }


    public static Optional<String> getS()
    {
        if (true)
        {
            return Optional.of("SAI");
        }
        return Optional.empty();
    }




}


class Switcher{
    private List<ElectricConsumer> list=new ArrayList<>();

    public void add(ElectricConsumer electric)
    {
        list.add(electric);
    }

    public void remove(ElectricConsumer electric)
    {
        list.remove(electric);
    }

    public void switchOn()
    {
        System.out.println("Выключатель включен");

        for (ElectricConsumer e : list) {
            e.electricOn(this); // this вызывает объект самого себя
        }
    }

}


class Radio implements ElectricConsumer
{

    private void radioOn()
    {
        System.out.println("Радио поет");
    }

    @Override
    public void electricOn(Object obj) {
        radioOn();    // т.к.  private radioOn()
    }
}

class Lampa implements ElectricConsumer
{

    private void lampOn()
    {
        System.out.println("Лампа зажглась");
    }

    @Override
    public void electricOn(Object obj) {
           lampOn();    // т.к.  private lampOn()
    }
}

@FunctionalInterface
 interface ElectricConsumer
{
     void electricOn(Object obj);
}


@FunctionalInterface  // содержит один абстрактный метод в интерфейсе, по умолчанию-абстрактный
interface Operat
{
    public  int calcul(int a, int b);

    default void show()  // может содержать методы по умолчанию, которые не надо переопределять
    {
        System.out.println("SAI");
    }

    static void print() // может содержать методы по умолчанию
    {
        System.out.println("AUM");
    }
}

class Person{
  private   String name;
  private   int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
}