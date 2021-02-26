package zadachi;

public class BlockTh extends Thread{

    Thread t1;
    UnBlock unBlock;

    public BlockTh(UnBlock unBlock) {
        this.unBlock = unBlock;
    }

    public void setT1(Thread t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {

    while (true) {
        try {

            //join();  // Блокируем поток перемещая его в конец
            unBlock.setUnblock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      }
  }
}


class BlockTh2 extends Thread{

    Thread t2;
    UnBlock unBlock;

    public BlockTh2(UnBlock unBlock) {
        this.unBlock = unBlock;
    }

    public void setT2(Thread t2) {
        this.t2 = t2;
    }

    @Override
    public void run() {
        while (true) {
            try {

                //join(); // Блокируем поток перемещая его в конец
                unBlock.setUnblock1();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class UnBlock{

    boolean flag;


    public synchronized void setUnblock() throws InterruptedException {
        if(!flag)
        {
           wait();
        }
        System.out.println(" BlockTh-1 ");
        flag=false;
        notify();
    }

    public synchronized void setUnblock1() throws InterruptedException {
        if(flag)
        {
            wait();
        }
        System.out.println(" BlockTh-2 ");
        flag=true;
        notify();
    }

}