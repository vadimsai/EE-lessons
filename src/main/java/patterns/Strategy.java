package patterns;


// часто используемый паттерн
// позволяет менять выбранный алгоритм, независимо объктов-клиентов, которые его используют
// есть прайс с постоянной ценой, но иногда бывают скидки


public class Strategy {
    public static void main(String[] args) {
        double StartPrice=100;
        ContextStrateg c=new ContextStrateg(new HalfPrice());
      // double a=c.getP(StartPrice);
        System.out.println(c.getP(StartPrice));
    }
}

interface Strateg
{
   double getPrice(double price);
}

class FulPrice implements Strateg      // класс с постоянной ценой(метод)
{
    @Override
    public double getPrice(double price) {
        System.out.println(price);
        return price;
    }
}

class HalfPrice implements Strateg     // класс с скидки
{
    @Override
    public double getPrice(double price) {
        System.out.println(price);
        return price*0.5;
    }
}

class ContextStrateg                  // класс реализация
{
    Strateg s;

    public ContextStrateg(Strateg s)
    {
        this.s=s;
    }
    public double getP(double price)  // метод с вызовом метода интерфейса реализующего, ту или иную деятельность
    {
        return s.getPrice(price);

    }
}