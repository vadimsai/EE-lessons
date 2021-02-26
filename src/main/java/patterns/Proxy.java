package patterns;

public class Proxy {
    public static void main(String[] args) {
       CaracProxy c=new CaracProxy();
       c.drive();
    }
}

interface Carac
{
    void drive();
}

class Reno implements Carac
{

    @Override
    public void drive()
    {
        System.out.println("reno");
    }
}

class CaracProxy implements Carac
{
    Carac c=new Reno();

    @Override
    public void drive() {

        System.out.println("CaracProxy code");
        c.drive();
    }
}