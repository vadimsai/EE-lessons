package patterns;

// Алгоритм как основа для создания

public class Template {
    public static void main(String[] args) {
        Poccer p=new Poccer();
        p.run();
    }
}

abstract class Game
{
    abstract void Start();
    abstract void Play();
    abstract void End();

    public void run()
    {
        Start();
        Play();
        End();
    }
}

class Poccer extends Game
{

    @Override
    void Start() {
        System.out.println("get card");
    }

    @Override
    void Play() {
        System.out.println("Play");
    }

    @Override
    void End() {
        System.out.println("loose money");
    }
}