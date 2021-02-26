package ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Singleton
public class DIandSesioncontex {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory; //внедряем из JPA

    @PersistenceContext
    EntityManager entityManager; //внедряем из JPA

 //   @EJB
//    FirstBean firstBean; //внедряем EJB бин

    @Inject
    MyScopped myScopped;  // внедряем обычный бин

//    @WebServiceRef
//    MyWebServic myWebServic; // внедряем сервис

    @Resource
    SessionContext sessionContext;  // позволяет вручную контролировать поведение бина




}

@RequestScoped
class MyScopped{}

//@WebService
//class MyWebServic{}
