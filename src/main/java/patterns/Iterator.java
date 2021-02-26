package patterns;

// реализация интерфейса Iterator


public class Iterator {
    public static void main(String[] args) {

        ArrayContainer a=new ArrayContainer();
        Iterato i=a.getIterato();

        while (i.HasNext())
        {
            i.Next();
        }
    }
}

interface Iterato
{
    boolean HasNext();
    Object Next();
}

interface Container
{
    Iterato getIterato();
}

class ArrayContainer implements Container
{
String[] s={"SAI","RAM","AUM"};
    @Override
    public Iterato getIterato() {
        return new ArrayIterato();      // возвращаем объект вложенного класса
    }
    class ArrayIterato implements Iterato       // вложенный класс
    {     int index;

        @Override
        public boolean HasNext() {
            return (index<s.length)?true:false;
        }

        @Override
        public Object Next() {
            if(HasNext())                          // пока true
            {
                System.out.println( s[index++]);
            }
            return null;
        }

    }
}