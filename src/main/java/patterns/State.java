package patterns;


// при изменении параметров объекта, изменяется его поведение


public class State {
    public static void main(String[] args) {
       Context c=new Context("SAI",new LoweCase());
       c.doA();
       c.setS(new UppeCase());
       c.doA();
    }
}

interface Statee                                       // состояние(Statee) инкапсулируется в объект (LoweCase,UppeCase)
{                                                      // и в зависимости от состояния объекта- меняется поведение
    void doA(Context c);
}

class LoweCase implements Statee
{
    @Override
    public void doA(Context c) {
        System.out.println(c.name.toLowerCase());
    }
}

class UppeCase implements Statee
{
    @Override
    public void doA(Context c) {
        System.out.println(c.name.toUpperCase());
    }
}

class Context
{
    String name;
    Statee s;

    public Context(String name,Statee s) {
        this.name = name;
        this.s = s;
    }

    public void setS(Statee s) {
        this.s = s;
    }

    public void doA()
    {
        s.doA(this);
    }
}