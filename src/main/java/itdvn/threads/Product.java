package itdvn.threads;

public class Product {
    int id;
    boolean isProduc; // произведен ли

    public synchronized int getIdProd() {
        if(!isProduc) // если не произведен
        {
            try {
                wait(); // ждем( даем setIdProd произвести)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("getProd" + this.id);
        isProduc=false; // т.к. уже произведен
        notify(); // выводит из блокировки setIdProd

        return id;
    }


    public synchronized void setIdProd(int id) {
        if(isProduc) // если произведен
        {
            try {
                wait(); // ждем( даем getIdProd получить)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.id = id;
        System.out.println("setProd" + this.id);

        isProduc=true; //произвели
        notify(); // метод возобновляет выполнение потока который ожидал getIdProd

    }
}
