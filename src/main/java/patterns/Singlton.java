package patterns;

// создаем объект класса(всегда один и тот же, сколько бы не создавали) с помощью статик метода

public class Singlton {
    public static void main(String[] args) {
            P p=P.getP();
    }
}

class P
{
    private static P p=new P();     // обязательно static, т.к не изменяемый

    private P(){}

    public static P getP()
    {
        return p;
    }
}