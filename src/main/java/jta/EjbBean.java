package jta;


import jpa.ColumnStudent;

import javax.annotation.sql.DataSourceDefinition;
import javax.annotation.sql.DataSourceDefinitions;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@DataSourceDefinitions(
        @DataSourceDefinition( name ="Definition", user="hrhr2", password = "hrhr", url ="jdbc:mysql://localhost:3306/sai",
                className = "com.mysql.cj.jdbc.Driver")) // если нет возможности прописать настройки в томкат +
                                                         // <jta-data-source>Definition</jta-data-source> в persistence
@Startup
@Stateless
public class EjbBean {

    @PersistenceContext(name = "Students")
    EntityManager em;

    public void save(ColumnStudent columnStudent)
    {
        em.persist(columnStudent);
    }
}
