package patterns;


// Реализация отдельно от основного кода, чтобы можно было менять
// т.е. 2 интерфейса  связываем, 1 реализуется в классах, с помощью 2 меняем реализацию 1


public class Visitor {
    public static void main(String[] args) {

        All a=new All();
        People p=new People();
        Eternity e=new Eternity();
        System.out.println(" patterns.People listen: ");
        a.Do(p);

        System.out.println("patterns.Eternity whispers :");
        a.Do(e);
    }
}

interface Sai
{
    void Do(Baba b);
}

class Babadgi implements Sai
{
    @Override
    public void Do(Baba b) {
        b.doBabadgi(this);
    }
}

class Budda implements Sai
{
    @Override
    public void Do(Baba b) {
        b.doBudda(this);
    }
}

interface Baba
{
    void doBabadgi(Babadgi b);
    void doBudda(Budda bu);
}

class All implements Sai
{   Sai[] s;

    public All()
    {
        this.s= new Sai[]{new Babadgi(),new Budda()};
    }
    @Override
    public void Do(Baba b) {       // метод в массиве вызывает метод Do на объектах implements patterns.Sai
        for (Sai e:s)
        {
            e.Do(b);
            System.out.println();
        }

    }
}

class People implements Baba  // реализация
{
    @Override
    public void doBabadgi(Babadgi b) {
        System.out.println("„I only came here to give." +
                        " If you come to doubt, " +
                        "I'll give you every reason to doubt." +
                        " If you come suspicious," +
                        " I'll give you every reason to be suspicious." +
                        " But if you come seeking Love, " +
                        "I'll show you more love than you've ever known.");
    }

    @Override
    public void doBudda(Budda bu) {
        System.out.println("Hate cannot overcome hate."+
                " Only love can overcome hatred."+
                " This is the eternal law.");

    }
}

class Eternity implements Baba // реализация
{
    @Override
    public void doBabadgi(Babadgi b) {
        System.out.println("AUM");

    }

    @Override
    public void doBudda(Budda bu) {
        System.out.println("AUMMMMM");

    }
}