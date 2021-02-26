package patterns;

import java.util.HashMap;
import java.util.Map;


//  если однотипные объекты и надо создавать только с новым признаком


public class FlyWeight {
    public static void main(String[] args) {

        FlyCarage f=new FlyCarage();
        Mers m=f.getM("pink");
        Mers m2=f.getM("pink");
        System.out.println(m.color);  // добавит только один объект
    }
}

class Mers
{
    String color;
}

class  FlyCarage
{
    Map<String,Mers> m=new HashMap<>();

    Mers getM(String color)
    {
        Mers ms=m.get(color);   // получаем цвет из параметров в объект
        if(ms==null)
        {
            ms=new Mers();   // если null то создаем новый
            ms.color=color;
            m.put(color,ms);  // добавляем в Map
        }
        return ms;        // иначе возвращаем с цветом из параметров
    }
}