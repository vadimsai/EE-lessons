package patterns;

import java.util.ArrayList;
import java.util.List;


//когда меняется статус одного объекта во всех изменения, объекты общаются друг с другом


public class Observer {
    public static void main(String[] args) {
        Obsev o=new Obsev("SAI");
        Obsev o2=new Obsev("RAM");
        o.setStatus("AUM");
        o2.setStatus("BABA");


    }
}

class Obsev
{  static List<Obsev> o=new ArrayList<>();
    String name;
    String status;

    public Obsev(String name) {
        this.name = name;
        o.add(this);
    }

    public void setStatus(String status) {   // при изменении статуса, notifAll() проходит по всем и Show() их меняет
        this.status = status;
        notifAll();
    }

    public void notifAll()
    {
        for (Obsev e:o)
        {
            e.Show();
        }
    }

    public void Show()   // реализация изменений может быть
    {
        System.out.println(name+" "+status);
    }
}