package jta;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Stateless
public class EjbJtaBean {
    @EJB
    ElbJtaPersistBean elbJtaPersistBean;

    public void sBasic()
    {
      //  elbJtaPersistBean.saveBasicSt();
    }
}
