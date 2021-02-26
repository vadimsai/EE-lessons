package patterns;


// реализуем 2ух уравневое наследование вместо 3х уровневого с помощью абстрактного класса, интерфейса(с одинаковым методом) , промежуточного класса имлемент интерфейс


public class Bridge {
    public static void main(String[] args) {
      ICarB c=new ToyotaB(new CarBr());
      c.drive();
      ITB t=new AudiTru(new TruBr());
      t.drive();

    }
}

class ToyotaB extends ICarB      // наследуемся от абстрактного класса
{
    public ToyotaB(IBridg b)     // в кострукторе интерфейс
    {
        super(b);
    }

    @Override
    public void drive() {
        b.drive();                // метод промежуточного класса
        System.out.println("toyotaC");

    }

}

class AudiB extends ICarB
{
    public AudiB(IBridg b) {
        super(b);
    }

    @Override
    public void drive()
    {
        System.out.println("audiC");

    }
}


class ToyTru extends ITB
{
    public ToyTru(IBridg b) {
        super(b);
    }

    @Override
    public void drive()
    {
        System.out.println("toyotaT");

    }
}

class AudiTru extends ITB
{

    public AudiTru(IBridg b) {
        super(b);
    }

    @Override
    public void drive() {
        b.drive();
        System.out.println("audiT");

    }
}

interface IBridg                  // интерфейс
{
    void drive();
}

class CarBr implements IBridg     // промежуточный
{

    @Override
    public void drive() {
        System.out.println("drive car");

    }
}

class TruBr implements IBridg
{

    @Override
    public void drive() {
        System.out.println("drive tru");
    }
}

abstract class ICarB         // абстрактный
{
    IBridg b;

    public ICarB(IBridg b)
    {
        this.b=b;
    }
    public abstract void drive();
}

abstract class ITB
{
    IBridg b;

    public ITB(IBridg b)
    {
        this.b=b;
    }
    public abstract void drive();
}
