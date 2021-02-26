package itdvn.threads;

public class DeadBlockOne extends Thread{

    private Thread t1;

    public DeadBlockOne() {
        System.out.println(" BlockOne constructor");
    }

    public void setT1(Thread t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        System.out.println("START BlockOne");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("One interrupt, Two finish=Blocking ");

        try {
            t1.join(); // перемещает в конец и блокировка
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FINISH BlockOne");
    }
}
