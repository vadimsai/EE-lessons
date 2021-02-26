package itdvn.threads;

public class DeadBlockTwo extends Thread{

    private Thread t2;

    public DeadBlockTwo() {
        System.out.println(" BlockTwo constructor");
    }

    public void setT2(Thread t2) {
        this.t2 = t2;
    }

    @Override
    public void run() {
        System.out.println("START BlockTwo");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Two interrupt One finish=Blocking");

        try {
            t2.join(); // перемещает в конец и блокировка
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FINISH BlockTwo");

    }
}
