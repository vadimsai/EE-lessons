package patterns;


// 2 интерфейса, старый интерфейс превращаем в новый(обертка как integer)


public class Adapter {
    public static void main(String[] args) {
         WachC w=new WachC();
         w.WC(new Audis());                     // старый
         w.WC(new Tr(new AudiTruck()));          // новый за счет реализации в промежуточном классе
    }
}


interface Cara                       // старый
{
    void clean();
}

class Audis implements Cara
{

    @Override
    public void clean() {
        System.out.println("clean car");
    }
}


interface Truck                     // новый
{
    void wash();
}

class AudiTruck implements Truck
{
    @Override
    public void wash() {
        System.out.println("wash Truck");
    }
}


class Tr implements Cara      // промежуточный класс, вызываем в переопределенном старом методе-новый
{
    Truck t;
    public Tr(Truck t)
    {
        this.t=t;
    }

    @Override
    public void clean() {
        t.wash();
    }
}


class WachC
{
    public void WC(Cara c)         // реализуем (измененый в classе Tr, обернутый уже) старый интерфейс
    {
        c.clean();
    }
}