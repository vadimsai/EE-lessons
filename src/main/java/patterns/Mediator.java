package patterns;

import java.util.ArrayList;
import java.util.List;


// инкапсулирует общение между объектами
// пока ондна кнопка будет True, все остальные будут False

public class Mediator {
    public static void main(String[] args) {

        ConcretM cm= new ConcretM();
        cm.Add(new ConcretC(cm,"SAI"));
        cm.Add(new ConcretC(cm,"Ram"));

        Colegue c=new ConcretC(cm,"Aum");  // чтобы вызвать метод реализующий requestAll создаем объект этого класса и
        cm.Add(c);                               // кладем его в лист
        c.chanchStatus();                        // и на нем же вызываем метод



    }
}

interface Mediatr
{
    void requestAll(Colegue c);
}

class ConcretM implements Mediatr            // класс реализации
{
    List<Colegue> colegues=new ArrayList<>();
    public void Add(Colegue c)
    {
        colegues.add(c);
    }

    @Override
    public void requestAll(Colegue c) {
        c.setTrue ();
        for (Colegue e:colegues){
        if(e!=c)
        {
            e.setFalse();
        }}
    }
}

interface Colegue
{
    void setFalse();
    void setTrue();
    void chanchStatus();
}

class ConcretC implements Colegue       // класс задает статусы и имена в конструкторе
{   boolean Status;
    Mediatr m;
    String name;

    public ConcretC(Mediatr m,String name)
    {
        this.m=m;
        this.name=name;
    }

    @Override
    public void setFalse() {
        Status=false;
        System.out.println(name+" "+Status);
    }

    @Override
    public void setTrue() {
        Status=true;
        System.out.println(name+" "+Status);
    }

    @Override
    public void chanchStatus() {
        m.requestAll(this);
    }
}