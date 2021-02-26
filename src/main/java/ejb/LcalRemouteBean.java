package ejb;


import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Local(LocalRemouteInterface.class)  // если нет доступа к интерфейсу ( не ставим на нем ни какую анотацию), то здесь прописываем
@LocalBean  // добавляем, чтобы @ingect интерфейс (LocalRemouteInterface)
@Stateless
public class LcalRemouteBean implements LocalRemouteInterface{
    @Override
    public String getName() {
        return "SAI RAM";
    }

    public String getSurname()
    {
        return "AUM";
    }

}
