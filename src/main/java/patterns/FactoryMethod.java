package patterns;


// создаем объект класса с помощью статик метода


public class FactoryMethod {
    public static void main(String[] args) {
        Person p=Person.getP();
    }
}

class Person
{
    private Person(){}         // приватный конструктор

    public static Person getP()  // статик- обязательно
    {
        return new Person();
    }
}