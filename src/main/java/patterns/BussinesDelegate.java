package patterns;

// когда надо подключаться к одному из серверов, а не к обоим сразут(трафик, нагрузка
// на сеть)


public class BussinesDelegate {
    public static void main(String[] args) {

        BisneDeleg b =new BisneDeleg();
        b.ge("jmc");
    }
}

interface BussinServ
{
    void Do();
}

class JmcServer implements BussinServ // подключаемся к одному из серверов
{
    @Override
    public void Do() {
        System.out.println("jmc");
    }
}

class EgbServer implements BussinServ
{
    @Override
    public void Do() {
        System.out.println(" egb");
    }
}

class LookService
{
    public BussinServ getSe(String s)  // метод выбора сервера к которому подключаемся
    {
        if(s.equals("jmc"))
        {
            return new JmcServer();
        }
        else
        {
            return new EgbServer();
        }
    }
}

class BisneDeleg
{
    LookService l=new LookService();

    public void ge(String s)
    {
      BussinServ b=l.getSe(s); // передаем выбранный сервер объекту реализации подключения
      b.Do();  // вызываем метод подключения
    }

}