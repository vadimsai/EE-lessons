package jta;


import jpa.BasicStudent;
import jpa.Student;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Singleton
//@TransactionAttribute(TransactionAttributeType.REQUIRED) // транзакция создается одна, здесь, но если вызов метода из метода где есть транзакция, то здесь не создастся
// TransactionAttributeType.REQUIRES_NEW  здесь всегда создасться новая транзакция(может удобно- здесь выполнится, а в другом ролбек, здесь данные сохранятся в бд)
// TransactionAttributeType.SUPPORTS если не было транз., то не будет создаваться(ошибка, в контейнере всегда транзак. должна), если была, то ее будет использовать
// TransactionAttributeType.MANDATORY чужие транз., если не было транз.-ошибка
// TransactionAttributeType.NOT_SUPPORTED никаких транзакций
// TransactionAttributeType.NEVER если из сервлета(не было транз.), то все хорошо, если из метода и там транз., то ошибка
public class ElbJtaPersistBean {

    @Resource
    SessionContext sessionContext;

    @PersistenceContext
    EntityManager em;

    public void saveBasicSt() throws Exception {
        em.persist(new BasicStudent("SAI",777));
      //  sessionContext.setRollbackOnly(); // откат без 500
      //  throw new RuntimeException();  // откат с ошибкой 500
      //   throw new MyExcept();    // откат без 500
        throw new Exception();  //  сохранит в БД и выбросит ошибку
    }
}

@ApplicationException(rollback = true) // анотация для отката через свою ошибку + (rollback = true)
class MyExcept extends Exception{}