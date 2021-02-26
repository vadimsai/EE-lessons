package ejb;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
@Lock(LockType.WRITE) // блокирует все для записи
//@AccessTimeout(value = 20,unit = TimeUnit.SECONDS) //усли метод залочится(зависнет на себе) на 20 сек, то дает другим к нему доступ
//@ConcurrencyManagement(ConcurrencyManagementType.BEAN) // отказываемся от синхронизации этого класса
public class Mnogopot {
  //  int i;

    AtomicInteger i=new AtomicInteger(); // потокобезопасная i

 /*   public int getI() {
        return i;
    }

    public int setI(int i) {
        return this.i = i;
    }
*/

 //   @Lock(LockType.READ) // разрешаем чтение несмотря на то, что пременная изменяема
    public int create()
    {
        //return i++;
        return i.getAndIncrement();
    }
}
