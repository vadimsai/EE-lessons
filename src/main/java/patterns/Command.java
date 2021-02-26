package patterns;

import java.util.ArrayList;
import java.util.List;


// для того чтобы инкапсулировать команды мы помещаем реализацию их в отдельный класс ( Reciver )


public class Command {
    public static void main(String[] args) {
       Reciver e=new Reciver();
       e.addC(new MousClick());
       e.addC(new MousPress());
       e.RunC();

      // e.getCc();     // как вариант
    }
}

interface  Comands
{
    void execute();
    void revert();
}

class MousClick implements Comands
{

    @Override
    public void execute() {
        System.out.println("execute MousClick ");
    }

    @Override
    public void revert() {
        System.out.println("revert MousClick ");
    }
}

class MousPress implements Comands
{

    @Override
    public void execute() {
        System.out.println("execute MousPress ");
    }

    @Override
    public void revert() {
        System.out.println("revert MousPress ");
    }
}

class Reciver
{   List<Comands> c=new ArrayList<>();

public void addC(Comands s)           // метод добавления объектов в лист
{
    c.add(s);
}
public void RunC()                    // метод реализации команд (можно через try catch )
{try {

    for (Comands e : c) {
        e.execute();
    }}
    catch (Exception d)
    {
        for (Comands e:c)
        {
            e.revert();
        }
    }
}
    /*Comands c=new MousClick();       // как вариант

    public Comands getCc() {
        c.execute();
        return c;
    }*/
}