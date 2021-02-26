package patterns;

import java.util.ArrayList;
import java.util.List;

// фильтрация элементов

public class Filter {
    public static void main(String[] args) {
        Car c=new Car(190,4,"green");   // создаем элементы
        Car c2=new Car(150,5,"green");
        Car c3=new Car(280,2,"white");
        List<Car> cars=new ArrayList<>();                 // создаем список элементов
        cars.add(c);                                      // добавляем элементы
        cars.add(c2);
        cars.add(c3);
       // patterns.SpeedFilter sf=new patterns.SpeedFilter();
       // cars=sf.f(cars);                                 // фильтруем по условию
        //System.out.println(cars);
       // patterns.DoorsFilter df=new patterns.DoorsFilter();
       // cars=df.f(cars);                                 // фильтруем по условию
        // System.out.println(cars);
        // patterns.AndFilter af=new patterns.AndFilter(new patterns.SpeedFilter(),new patterns.DoorsFilter());
       // cars=af.f(cars);                                 //  фильтруем через оба фильтра
       // System.out.println(cars);
        OrFilter of=new OrFilter(new SpeedFilter(),new DoorsFilter());
        cars=of.f(cars);                                   //  фильтруем через оба фильтра попадает ли элемент под оба критерия фильтрации
        System.out.println(cars);

    }
}

interface CarFilter
{
    List<Car> f(List<Car> c);
}

class SpeedFilter implements CarFilter     // фильтруем по условию
{
    @Override
    public List<Car> f(List<Car> c)
    {
        List<Car> l=new ArrayList<>();
      for (Car e: c)
      {
          if(e.getSpeed()<180)
          {
              l.add(e);
          }
      }
      return l;
    }
}

class DoorsFilter implements CarFilter       // фильтруем по условию
{
    @Override
    public List<Car> f(List<Car> c)
    {
        List<Car> l=new ArrayList<>();
        for (Car e: c)
        {
            if(e.getDoors()>2)
            {
                l.add(e);
            }
        }
        return l;
    }
}

class AndFilter implements CarFilter         //  фильтруем через оба фильтра
{
    CarFilter fone;
    CarFilter ftwo;

    public AndFilter(CarFilter fone,CarFilter ftwo)
        {
            this.ftwo=ftwo;
            this.fone=fone;
        }


    @Override
    public List<Car> f(List<Car> c) {
        List<Car> l = fone.f(c);
        return ftwo.f(l);
    }
}

class OrFilter implements CarFilter          //  фильтруем через оба фильтра попадает ли элемент под оба критерия фильтрации
{
    CarFilter fone;
    CarFilter ftwo;

    public OrFilter(CarFilter fone,CarFilter ftwo)
    {
        this.ftwo=ftwo;
        this.fone=fone;
    }


    @Override
    public List<Car> f(List<Car> c) {
        List<Car> l = fone.f(c);
        List<Car> l2 = ftwo.f(c);
        for (Car e: l2)
        {
            if(!l.contains(e))         //если НЕ СОДЕРЖИТ
            {
                l.add(e);
            }
        }
        return l;
    }
}