package ejb;

import javax.ejb.Singleton;

//@Stateless   // не сохраняет
@Singleton // сохраняет инф пока сами не поменяем
//@Stateful  // сохраняет на время
public class Ejb {
    int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

}