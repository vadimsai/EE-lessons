package patterns;


//  вызываем свой метод на основном, с помощью абстрактного класса


public class Decorator {
    public static void main(String[] args) {

        FileStream f=new FileBuf(new FileRead());
        f.read();
    }
}

interface FileStream
{
    void read();
}

class FileRead implements FileStream
{
    @Override
    public void read()
    {
        System.out.println("read");
    }
}

abstract class FileDecort implements FileStream   // абстрактный класс с новым методом и в кострукторе интерфейс основного метода
{
    FileStream f;

    public FileDecort(FileStream f) {
        this.f = f;
    }

    public abstract void read();
}

class FileBuf extends FileDecort                   //  класс реализации
{

    public FileBuf(FileStream f) {
        super(f);
    }

    @Override
    public void read()                             // метод абстрактного класса
    {
        f.read();                                  // метод основно вызываем
        System.out.println("buf read");
    }
}