package itdvn.threads;

public class DaemonThread extends Thread {

    @Override
    public void run() {
       try {
           if (isDaemon()) {
               System.out.println(" START Daemon");
               try {
                   sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           } else {
               System.out.println("Обычный поток");
           }
       }finally {
           if (!isDaemon())
           {
               System.out.println("Завершил Обычный поток");
           }else { System.out.println("Завершил Daemon поток");}
       }
    }
}