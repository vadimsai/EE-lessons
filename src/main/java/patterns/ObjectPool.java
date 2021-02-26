package patterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//  т.к. ограниченное колл. соединений, то создаем pool(бассейн) объектов и используем ,и освобождаем


public class ObjectPool {
    public static void main(String[] args) {
        PooObjects p=new PooObjects();
        ObjPool o=p.getP();
        p.releaseOP(o);

    }
}

class ObjPool{}           //  объекты

class PooObjects          //   бассейн объектов
{
    List<ObjPool> free=new LinkedList<>();
    List<ObjPool> used=new LinkedList<>();

    public ObjPool getP()
    {
        if(free.isEmpty())
        {
            ObjPool p=new ObjPool();  // создаем
            free.add(p);              // добавляем
            return p;
        }
        else
        {
            ObjPool p=free.get(0);    // получаем из свободных по индексу 0
            used.add(p);              // добавляем в используемые
            free.remove(p);           // удаляем из свободных
            return p;
        }
    }

    public void releaseOP(ObjPool p)
    {
        used.remove(p);             // удаляем из используемые
        free.add(p);                // добавляем в свободные
    }
}