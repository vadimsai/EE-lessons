package itdvn.threads;

public class Tiket {

    boolean isBuy;
    int place;

    public Tiket(int place) {
        this.place = place;
    }

    public synchronized void buyCass(Cassir c) {  // билет куплен кассиром
        if(!isBuy) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isBuy = true;  // билет куплен
            System.out.println(c.id + "  " + this.place);
        }



    }



}
