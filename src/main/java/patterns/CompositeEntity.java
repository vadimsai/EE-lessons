package patterns;


//есть несколько сервисов- объединяем их в один и используем


public class CompositeEntity {
    public static void main(String[] args) {

        CompEntity c=new CompEntity();
        for (String e:c.getObj())           // используем
        {
            System.out.println(e);
        }
    }
}

class OneObj               //есть несколько сервисов
{
    public String one(){
   return "one";
}
}

class TwoObj
{
    public String two(){
       return "two";
    }
}

class ConsObj           //  объединяем их в один
{
    OneObj o=new OneObj();
    TwoObj t=new TwoObj();

    public String[] cons()
    {
        return new String[] {o.one(),t.two()};
    }
}

class CompEntity
{
    ConsObj c=new ConsObj();
    public String[] getObj()
    {
       return c.cons();
    }
}