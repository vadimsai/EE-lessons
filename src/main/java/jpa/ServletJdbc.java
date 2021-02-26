package jpa;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/ServletJdbc")
public class ServletJdbc extends HttpServlet {


  //  @Resource(name = "JdbcJpa") с ресурсами в томкат не меняет данные(ошибка)
 //   DataSource dataSource;
    String userM = "hrhr2";
    String passwordM = "hrhr";
    String conectM = "jdbc:mysql://localhost:3306/sai";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(conectM, userM, passwordM) ;
            Statement statement=connection.createStatement();
            statement.executeUpdate( "update basicstudent set name='AUMAUMAUM' where id=2 ");
            statement.executeUpdate("insert into basicstudent (id,name) values (3,'SHRI')");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


   /*    try( Connection connection=dataSource.getConnection();
            Statement statement=connection.createStatement())
       {
         //  statement.executeUpdate("insert into basicstudent (id,name) values (2,'SHRI')");
           statement.executeQuery("select * from basicstudent");

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }*/


    }
}
