package itdvn;

public class PriorityThread extends Thread{

    public PriorityThread(String name) {
        super(name); }  // через конструтор родителя(Thread), получим в своем конструкторе заданное имя потока

    @Override
    public void run() {
        for (int i=0;i<=50;i++) {

            System.out.println(getName()+": "+i);
        }

    }
}
