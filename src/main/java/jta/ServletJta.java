package jta;

import jpa.*;

import javax.ejb.EJB;
import javax.ejb.TransactionManagement;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import java.io.IOException;

@WebServlet("/ServletJta")
public class ServletJta extends HttpServlet {


    @EJB
     EjbBean ejbBean;

    @EJB
    EjbJtaBean ejbJtaBean;

    @EJB
    ElbJtaPersistBean elbJtaPersistBean;

    @EJB
    TransManaged transManaged;

    @Inject
    TransInject transInject;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ejbBean.save(new ColumnStudent("SAI7777777","AUM999","Alien"));

       // ejbJtaBean.sBasic(); //@TransactionAttribute(TransactionAttributeType.REQUIRED) транзакция создается одна, здесь,но если вызов метода из метода где есть транзакция, то здесь не создастся


        try {
            elbJtaPersistBean.saveBasicSt();  // sessionContext.setRollbackOnly(), @ApplicationException(rollback = true)
        } catch (MyExcept myExcept) {
            myExcept.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

            transManaged.bas();  // @TransactionManagement(TransactionManagementType.BEAN) вручную-открывать, закрывать


   /*    try {
            transInject.saveBS();   // Обычные IO бины делаем транзакционными и rollbackOn, dontRollbackOn
        } catch (MyExcept myExcept) {
            myExcept.printStackTrace();

        }*/

    }
}
@RequestScoped
@Transactional(rollbackOn = {Exception.class,MyExcept.class},dontRollbackOn = {RuntimeException.class})
// Обычные IO бины делаем транзакционными
//  rollback только RuntimeException, но в @Transactional прописываем где- rollbackOn и где- dontRollbackOn
class TransInject{
    @PersistenceContext
    EntityManager em;

    public  void saveBS() throws MyExcept
    {
        em.persist(new BasicStudent("BABADGI",555));
       // throw  new MyExcept();
    }
}