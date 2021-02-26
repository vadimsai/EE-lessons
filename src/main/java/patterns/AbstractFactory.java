package patterns;


// создаем фабрики


public class AbstractFactory {
    public static void main(String[] args) {
       Factoryy fc=new AbstFact().getF("Car");
       Factoryy ft =new AbstFact().getF("T");
       Carc ct=fc.getC("toyotaC");
       Carc ca=fc.getC("audiC");
       ct.drive();
       ca.drive();
       T tt=ft.getT("toyotaT");
       T ta=ft.getT("audiT");
       tt.drive();
       ta.drive();
    }
}

interface Carc
{
    void drive();
}

class Toyota2 implements Carc
{
    @Override
    public void drive() {
        System.out.println("toyotaC");
    }
}

class Audi2 implements Carc
{
    @Override
    public void drive() {
        System.out.println("audiC");
    }
}

class FactoryC implements Factoryy {
    @Override
    public Carc getC(String c) {       // используем метод интерфейса Factoryy!!!!
        switch (c) {
            case "toyotaC":
                return new Toyota2();
            case "audiC":
                return new Audi2();
            default:
                return null;
        }
    }

    @Override
    public T getT(String c) {
        return null;
    }
}

interface T
{
    void drive();
}

class ToyotaT implements T
{
    @Override
    public void drive() {
        System.out.println("toyotaT");
    }
}

class AudiT implements T
{
    @Override
    public void drive() {
        System.out.println("audiT");
    }
}

class FactoyT implements Factoryy{
    @Override
    public T getT(String c) {       // используем метод интерфейса Factoryy!!!!!
        switch (c) {
            case "toyotaT":
                return new ToyotaT();
            case "audiT":
                return new AudiT();
            default:
                return null;
        }
    }

    @Override
    public Carc getC(String c) {
        return null;
    }

}

interface Factoryy     // интерфей создания фабрик
{
    Carc getC(String c);
    T getT(String c);
}

class AbstFact
{
    public Factoryy getF(String c)        // создаем фабрики
    {
        switch (c){
            case "Car": return new FactoryC();
            case "T": return new FactoyT();
            default: return null;
        }
    }
}