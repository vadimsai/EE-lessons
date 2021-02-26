package itdvn.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadMain extends Thread{

    private int cou;
    private String word;
    private Thread t;

    public ThreadMain(int cou, String word) {
        this.cou = cou;
        this.word = word;
    }

    public void setT(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (!isInterrupted()) // или попадаем в бесконечный цикл
        {
            t.interrupt(); // очищает флаг isInterrupted() или оба выполнятся

            for (int i=0;i<=cou;i++)
            {
                System.out.println(word + i);
            }


        }
    }

    public static void main(String[] args) throws InterruptedException {

        Value value=new Value();
        LockThread[] lockThread=new LockThread[10];// колличество потоков

        for (int i=0;i<10;i++)
        {
            lockThread[i]=new LockThread(value,100000);// передаем в каждый поток
        }

        for (LockThread e : lockThread) {
            e.start();// запускаем все потоки
        }

        for (LockThread e : lockThread) {
            e.join(); // перемещаем каждый поток в конец
        }


        System.out.println(value.getCoun());



       /* DaemonThread daemonThread=new DaemonThread();
        DaemonThread daemonThread1=new DaemonThread();
        daemonThread.setDaemon(true);
       // daemonThread1.setDaemon(true); // если оба то не запустятся, т.к. поток Daemon должен быть только в потоке Usere
        daemonThread.start();
        daemonThread1.start();*/



        /*ThreadMain threadMain1=new ThreadMain(5, "DID");
        ThreadMain threadMain2=new ThreadMain(5, "DID NOT");
        threadMain1.setT(threadMain2);
        threadMain2.setT(threadMain1);
       // threadMain1.setPriority(MAX_PRIORITY);
        threadMain1.start();
        threadMain2.start();*/




       /* Counter counter=new Counter();
        counter.start();
        Thread.sleep(3000);
        counter.interrupt(); // выбросит InterruptedException и продолжит цикл
*/


       /* DeadBlockOne one=new DeadBlockOne();
        DeadBlockTwo two=new DeadBlockTwo();
        one.start();
        two.start();

        one.setT1(two);
        two.setT2(one);*/


        /*Egg egg=new Egg();
        egg.start();
        sayChiken();
        who(egg);*/




       /* Product product=new Product();
        Produsser produsser=new Produsser(product,5);
        Consumer consumer=new Consumer(product,5);
        produsser.start();
        consumer.start();*/



       /* Tiket[] tiket={new Tiket(11),new Tiket(13),new Tiket(77),new Tiket(15),new Tiket(99),};
        Cassir cassir1= new Cassir(1,tiket);
        Cassir cassir2= new Cassir(2,tiket);
        Cassir cassir3= new Cassir(3,tiket);
        Cassir cassir4= new Cassir(4,tiket);
        Cassir cassir5= new Cassir(5,tiket);
        cassir1.start();cassir2.start();cassir3.start();cassir4.start();cassir5.start();
*/



       // Thread thread=Thread.currentThread();// инкапрсилирует текущий поток в этот поток
       // new OtherTh().start();// вызываем поток в классе и потк main одновременно выполяются

      /*  Thread thread= new Thread(new OtherTh());
        thread.start();

        for (int k=0;k<=5;k++)
        {
                Thread.sleep(1000);
            System.out.println("k "+k + Thread.currentThread().getName());

            if(k==2){thread.join();}  // join останавливает поток(main) в котором выполняется и ставит его в конец, другой поток(OthearTh) продожит работу и когда он закончит, запустится поток(main) на котором вызван был join
        }*/



    }
    public static class LockThread extends Thread
    {
        private Value value;
        private int number;

        public LockThread(Value value, int number) {
            this.value = value;
            this.number = number;
        }

        @Override
        public void run() {
            for (int i=0;i<number;i++)
            {
                value.IncrValue();
            }
        }
    }



    public static class Value
    {
        private int coun=0;
        Lock reel=new ReentrantLock();

        public void IncrValue()
        {
            reel.lock(); // только один поток может пользоваться
            coun++;
            reel.unlock();


        }

        public int getCoun() {
            return coun;
        }
    }



  public static class Counter extends Thread
  {
      @Override
      public void run() {
          int i=0;
          while (!isInterrupted()) // если поток не прерван
          {
              System.out.println(i++);
              if (i==1)
              {
                  interrupt(); // выбросит InterruptedException и продолжит цикл
              }
              try {
                  sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }

    public static void who(Egg egg)
    {
        if(egg.isAlive())
        {  try {
                egg.join();
           } catch (InterruptedException e) {
                    e.printStackTrace();
                }
           System.out.println(" Первое яйцо ");
        } else {
            System.out.println(" Первая курица ");
        }
        System.out.println(" fin ");
    }

    public static void sayChiken()
    {
        for (int i=0;i<=5;i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" курица ");
        }
    }

}

class OtherTh implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<=5;i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i "+i+ Thread.currentThread().getName());
        }
    }
}