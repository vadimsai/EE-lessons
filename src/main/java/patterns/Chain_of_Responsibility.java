package patterns;



// исполнение метода для каждого свое




public class Chain_of_Responsibility {
    public static void main(String[] args) {
         MessagePrint m=new Console();
         Filee f=new Filee();
         m.setNextmessage(f);
         f.setNextmessage(new DataBase());
         m.Print("SAI");
    }
}

abstract  class MessagePrint
{
    MessagePrint nextmessage;

    public void setNextmessage(MessagePrint m) //сеттер принимает параметром объект абстрактного класса( и его наследников)
    {
        this.nextmessage = m;
    }
    void Print(String message)    //  метод реализации
    {
        printMessage(message);    // вызываем абстрактный метод, который будет переопределен у наследников
        if(nextmessage!=null)     // в if задаем логику реализации
        {
            nextmessage.Print(message);
        }
    }

    abstract void printMessage(String message);
}

class Console extends MessagePrint
{
    @Override
    void printMessage(String message) {
        System.out.println("console "+message);
    }
}

class DataBase extends MessagePrint
{
    @Override
    void printMessage(String message) {
        System.out.println("database "+message);
    }
}

class Filee extends MessagePrint
{
    @Override
    void printMessage(String message) {
        System.out.println("file "+message);
    }
}