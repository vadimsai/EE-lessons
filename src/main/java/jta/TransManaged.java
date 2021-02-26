package jta;


import jpa.BasicStudent;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

@Singleton
@TransactionManagement(TransactionManagementType.BEAN) // без анотации не работает, она для управления транзакциями
// вручную-открывать, закрывать, иначе контейнер контролирует транз.(и ошибка)
public class TransManaged {
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction userTransaction;

    public void bas() {
        try {
            userTransaction.begin();
            em.persist(new BasicStudent("AUM",999));
            userTransaction.commit();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        }
    }
}
