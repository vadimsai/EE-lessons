package itdvn.threads;

public class Produsser extends Thread {
    Product product;
    int coll;

    public Produsser(Product product, int coll) {
        this.product = product;
        this.coll = coll;
    }

    @Override
    public void run() {
        for (int i=1;i<=coll+1;i++) {
              product.setIdProd(i);
        }
    }
}

class Consumer extends Thread
{
    Product product;
    int coll;

    public Consumer(Product product, int coll) {
        this.product = product;
        this.coll = coll;
    }

    @Override
    public void run() {
        for (int i=1;i<=coll+1;i++) {
            product.getIdProd();
        }
    }
}