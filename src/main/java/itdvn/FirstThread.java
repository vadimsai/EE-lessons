package zadachi;

public class FirstThread extends Thread{

    Incr incr;

    public FirstThread(Incr incr) {
        this.incr = incr;
    }

    @Override
    public void run() {

        while (true) {

            try {

                incr.first();

                sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

class Incr
{
    private boolean flag;

    public synchronized void first() throws InterruptedException {
        if(!flag)
        {
            wait();
        }
        System.out.println(" FirstThread ");
        flag=false;
        notify();

    }

    public synchronized void second() throws InterruptedException {
        if (flag)
        {
            wait();

        }
        System.out.println(" SecondThread ");
        flag=true;
        notify();
    }


}

class SecondThread extends Thread{

   Incr incr;

    public SecondThread(Incr incr) {
        this.incr = incr;
    }

    @Override
    public void run() {
        while (true) {

            try {

                incr.second();

                sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
