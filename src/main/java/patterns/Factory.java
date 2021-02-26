package patterns;


// создаем объект класса с помощью  метода getCar в др классе, а не в майн


public class Factory {
    public static void main(String[] args) {
          Factoy f=new Factoy();
          Cart c=f.getCar("audi");
          Cart c2=f.getCar("toyota");
          c.drive();
          c2.drive();
    }
}

interface Cart
{
    void drive();
}

class Toyota implements Cart
{
    @Override
    public void drive() {
        System.out.println("toyota");
    }
}

class Audi implements Cart
{
    @Override
    public void drive() {
        System.out.println("audi");
    }
}

class Factoy {
    public Cart getCar(String c) {
        switch (c) {
            case "toyota":
                return new Toyota();
            case "audi":
                return new Audi();
            default:
                return null;
        }
    }
}