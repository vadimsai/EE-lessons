package patterns;


// Чтобы вернуть ничего, иначе NullPointerException

import java.io.File;

public class Null {
    public static void main(String[] args) {
    Animal a=getAnimal();
    a.eat();

    }

    static Animal getAnimal()
    {
        try {
            if(new File("dfjdkj.txt").exists());
            return new Lion();
        }
        finally {
            return new NoAnimal();
        }
    }
}

interface Animal
{
    void eat();
}

class Lion implements Animal
{
    @Override
    public void eat() {
        System.out.println("EAT");
    }
}

class NoAnimal implements Animal
{
    @Override
    public void eat() {       // пустой метод

    }
}