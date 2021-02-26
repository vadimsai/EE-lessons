package ejb;


import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import java.util.concurrent.Future;

@Singleton
@Asynchronous // убирает синхронизацию, операции одновременно выполняются
public class AsynchronBean {

    @Asynchronous
    public void getName()  {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Future<String> getMyName()  // Future- используется в многопоточности
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("SAI");
    }

}
