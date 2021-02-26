package itdvn.threads;

public class Cassir extends Thread{

    int id;
   Tiket[] tiket;

    public Cassir(int id, Tiket[] tiket) {
        this.id = id;
        this.tiket = tiket;
    }

    @Override
    public synchronized void run() {
        for (int i=0;i<=tiket.length-1;i++)
        {
           /* if(!tiket[i].isBuy)// если билет не куплен, выполняем операциб какую-то
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {       // кассир продает билет, не праильно кассир должен купить билет
                    e.printStackTrace();
                }

                tiket[i].isBuy = true; // если куплен на экран, каждый кассир продает все билеты
                System.out.println(id + "  " + tiket[i].place);
            }*/

            tiket[i].buyCass(this); // передаем текущего кассира
        }
    }
}
