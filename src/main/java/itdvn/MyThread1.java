package itdvn;

public class MyThread1 extends Thread {

    @Override
    public void run() {
          System.out.println("first work ");
        }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println("second work ");
    }
}

class MyThread3 extends Thread{
    @Override
    public void run() {
        System.out.println("third work ");
    }
}


class Inter
{

    public void t(MyThread1 thread1, MyThread2 thread2,MyThread3 thread3 )
    {
        thread1.interrupt();
        if(!thread1.isAlive())
        {
            System.out.println("завершил:  first ");
        }thread2.interrupt();
        if(!thread2.isAlive())
        {
            System.out.println("завершил: second ");
        }
        thread3.interrupt();
        if(!thread3.isAlive())
        {
            System.out.println("завершил: third ");
        }
        if(!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive())
        {
            System.out.println("завершил:  first, second, third ");
        }
    }

}
