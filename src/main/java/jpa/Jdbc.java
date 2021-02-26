package jpa;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.MediaSize;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Jdbc {
    /* static   String user="hr";
      static String password="hr";
      static String conect="jdbc:oracle:thin:@localhost:1521:XE";   //для CachedRowSet

       static   String userMy="hrhr";
       static String passwordMy="hrhr";
       static String conectMy="jdbc:mysql://localhost:3306";*/
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
      /*  String user = "hr";
        String password = "hr";
        String conect = "jdbc:oracle:thin:@localhost:1521:XE";
        Class.forName("oracle.jdbc.driver.OracleDriver");*/

        String userM = "hrhr2";
        String passwordM = "hrhr";
        String conectM = "jdbc:mysql://localhost:3306/sai";
        Class.forName("com.mysql.cj.jdbc.Driver");

          Connection connection=DriverManager.getConnection(conectM, userM, passwordM) ;
          Statement statement=connection.createStatement();


      /*  ResultSet resultSet=statement.executeQuery("select * from employees");
        while (resultSet.next())
        {
            System.out.println(resultSet.getInt("employee_id"));
            System.out.println(resultSet.getString(2));
            System.out.println("---------------------------------");    close()???????
        }  */

        //   SQL Injection и PreparementStatement (защита от инъекций)


     /*   String ids="101 or 101=101";                                 // здесь мы получим все данные, если в браузере введе такую инъекцию
        ResultSet resultSet=statement.executeQuery("select * from employees where employee_id="+ids);
        while (resultSet.next())
        {
            System.out.println(resultSet.getInt("employee_id")+" "+resultSet.getString(2)+" "+resultSet.getString(3));
            System.out.println("---------------------------------");
        }*/


     /*   String ids="101 or 101=101";         // получим ошибку ( или правильный ввод)
        PreparedStatement preparedStatement=connection.prepareStatement("select * from employees where employee_id=?");  // защита от инъекций
        preparedStatement.setString(1,ids);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next())
        {
            System.out.println(resultSet.getInt("employee_id")+" "+resultSet.getString(2)+" "+resultSet.getString(3));
            System.out.println("---------------------------------");
        }*/

        //BLOB - Binary large objects (img картинки)
/*
        statement.execute("drop table Books");
        statement.executeUpdate("create table BOOKS(Id integer ,namess char(30),img BLOB)");

        BufferedImage im= ImageIO.read(new File("bg.jpg"));       //не читаем из файла
        Blob blob=connection.createBlob();                        // создаем блоп
        try (OutputStream outputStream=blob.setBinaryStream(1)){
        ImageIO.write(im,"jpg",outputStream);}                     // записываем

        PreparedStatement preparedStatement=connection.prepareStatement("insert into BOOKS (id,namess,img) values (?,?,?)");
        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"SAI");
        preparedStatement.setBlob(3,blob);
        preparedStatement.execute();

        preparedStatement.close();

  */


        // Даты




       // statement.execute("drop table Books");
        statement.executeUpdate("create table Books(Id integer ,namess char(30),dt DATE )");


        PreparedStatement preparedStatement=connection.prepareStatement("insert into BOOKS (id,namess,dt) values (?,?,?)");
        preparedStatement.setInt(1,1);   // кладем параметры по очередности
        preparedStatement.setString(2,"SAI"); // кладем параметры по очередности
        preparedStatement.setDate(3,new Date(1607536113795L));  // кладем Дату в МИЛИСЕКУНДАХ
        preparedStatement.execute();
        System.out.println(preparedStatement);

        statement.executeUpdate("insert into books(id,namess,dt) values (777,'AUM', '09.11.2020')"); // дата в обычном формате
        ResultSet resultSet= statement.executeQuery("select * from books ");
        while (resultSet.next())
        {
            System.out.println(resultSet.getDate("dt"));
        }




        // Хранимые процедуры (ошибка)


 /*
        CallableStatement cal=connection.prepareCall("{call getCoun_2(?)}");// передает
       cal.registerOutParameter(1,Types.INTEGER);
        cal.execute();
       System.out.println(cal.getInt(1));



        CallableStatement cal2=connection.prepareCall("{call getCoun_6(?)}");  // не передает данные
        cal2.setInt(1,105);
        if(cal2.execute())
        {
            ResultSet resultSet=cal2.getResultSet();
            while (resultSet.next())
                System.out.println(resultSet.getInt("employee_id"));
                System.out.println(resultSet.getString("first_name"));
            System.out.println(cal2.getInt(1));
        }
*/

        // Scrollable RowSet ( идем по базе, без изменений)

 /*
       Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    //   PreparedStatement preparedStatement=connection.prepareStatement("",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet resultSet=statement.executeQuery("select * from employees");

       if(resultSet.next())
       {
           System.out.println(resultSet.getString("first_name"));
       }
        if(resultSet.next())
        {
            System.out.println(resultSet.getString("first_name"));
        }
        if(resultSet.previous())                // предыдущий элемент
        {
            System.out.println(resultSet.getString("first_name"));
        }

        if(resultSet.relative(10))          //
        {
            System.out.println(resultSet.getString("first_name"));
        }

        if(resultSet.relative(-5))         // возвращаемся на 5 элементов
        {
            System.out.println(resultSet.getString("first_name"));
        }

        if(resultSet.absolute(10))           // 10 элемент
        {
            System.out.println(resultSet.getString("first_name"));
        }

        if(resultSet.first())               // первый элемент
        {
            System.out.println(resultSet.getString("first_name"));
        }

        if(resultSet.last())                  // последний элемент
        {
            System.out.println(resultSet.getString("first_name"));
        }
*/


        // Update ResultSet
/*

        statement.execute("drop table Books");
        statement.executeUpdate("create table BOOKS(Id integer ,namess char(30))");

        statement.executeUpdate("insert into BOOKS (id,namess) values (1,'AUM')");
        statement.executeUpdate("insert into BOOKS (id,namess) values (2,'SHRI')");
        statement.executeUpdate("insert into BOOKS (id,namess) values (3,'SAI')");
        statement.executeUpdate("insert into BOOKS (id,namess) values (4,'RAM')");

        Statement statement2=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet=statement2.executeQuery("select * from books");
         while (resultSet.next())
        {
            System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("namess"));
        }


        resultSet.last();
        resultSet.updateInt(1,2);
        resultSet.updateRow();


        resultSet.moveToInsertRow();
        resultSet.updateInt(3,4);
        resultSet.insertRow();

        resultSet.absolute(2);
        resultSet.deleteRow();

        resultSet.beforeFirst();
        while (resultSet.next())
        {
            System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("namess"));
        }
*/


        // Кэширование результата запроса - CachedRowSet (нет необходимости в постоянном подключении к базе)


/*

ResultSet resultSet=getDAta();   // метод getDAta() возвращает кэшированные данные
        while (resultSet.next())
        {
            System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("namess"));
        }

        CachedRowSet cachedRowSet= (CachedRowSet) resultSet;  // создаем кешированные данные
        cachedRowSet.setUrl(conect);
        cachedRowSet.setUsername(user);   // для проверки изменений
        cachedRowSet.setPassword(password);

     //   cachedRowSet.setCommand("select * from books where id=?");
     //   cachedRowSet.setInt(1,1);
     //   cachedRowSet.setPageSize(30);  // 30 стр.
     //   cachedRowSet.execute();

     //   do {
     //       while (cachedRowSet.next())
     //       {
     //           System.out.println(cachedRowSet.getInt("id")+" "+ cachedRowSet.getString("namess"));
     //       }

     //   }while (cachedRowSet.nextPage());


        CachedRowSet cachedRowSet2= (CachedRowSet) resultSet; // изменяем данные
        cachedRowSet2.setTableName("Books");
        cachedRowSet2.absolute(2);
        cachedRowSet2.deleteRow();  // удаляем вторую стр.
        cachedRowSet.beforeFirst();
        while (cachedRowSet2.next())
        {
            System.out.println(cachedRowSet2.getInt("id")+" "+ cachedRowSet2.getString("namess"));
        }

        cachedRowSet2.setUrl(conect);
        cachedRowSet2.setUsername(user);     // подключаемся к базе
        cachedRowSet2.setPassword(password);
        cachedRowSet2.acceptChanges();       // выполняем изменения

 */


        // Metadata (получаем данные о таблицах, название столбов, типы данных)

  /*  DatabaseMetaData databaseMetaData=connection.getMetaData();
    databaseMetaData.nullPlusNonNullIsNull();
    ResultSet resultSet=databaseMetaData.getTables(null,null,null,new String[] {"Table"});
    while (resultSet.next())
    {

        System.out.println(resultSet.getString(1));     // зависает, название таблицы должен
    }  */
/*
    ResultSet resultSet1=statement.executeQuery("select * from employees");
    ResultSetMetaData resultSetMetaData=resultSet1.getMetaData();
    for (int i=1; i<=resultSetMetaData.getColumnCount(); i++)
    {
        System.out.println(resultSetMetaData.getColumnLabel(i));         // получаем данные о таблицах, название столбов
        System.out.println(resultSetMetaData.getColumnType(i));
    }*/


        // Транзакции - transactions (набор операций которые являются целостными, если у одной что ошибка- все отменяются)


/*

   try (Statement statement=connection.createStatement()) {


       connection.setAutoCommit(false); //не выполнится пока не connection.commit(); создание таблиц(Метаданные) не откатывается

       statement.execute("drop table Books");
       statement.executeUpdate("create table BOOKS(Id integer ,namess char(30))");

       statement.executeUpdate("insert into BOOKS (id,namess) values (1,'AUMmmm')");

       Savepoint savepoint=connection.setSavepoint();   // При откате сохраняем 1 добавление

       statement.executeUpdate("insert into BOOKS (id,namess) values (2,'SHRI')");
       statement.executeUpdate("insert into BOOKS (id,namess) values (3,'SAI')");
       statement.executeUpdate("insert into BOOKS (id,namess) values (4,'RAM')");


       connection.rollback(savepoint); // откат до savepoint

       connection.commit();   // закрываем транзакцию

      // connection.releaseSavepoint(savepoint);

   }catch (SQLException e)
   {
       connection.rollback();   // Обычно так выполняется ( try catch ) , при ошибке откат всех операций
   }


*/


        //  Как накатить SQL группой - SQL Batch  ( executeUpdate- постоянно открывает и закрывает соединения-на каждой операции,
        //           а  Batch- массив операций и выполняет их за одно подключение )



/*
        try (Connection connection = DriverManager.getConnection(conect, user, password);
             Statement statement = connection.createStatement()) {

            connection.setAutoCommit(false); //не выполнится пока не connection.commit(); создание таблиц(Метаданные) не откатывается

            statement.addBatch("drop table Books");
            statement.addBatch("create table BOOKS(Id integer ,namess char(30))");  // Batch вместо executeUpdate
            statement.addBatch("insert into BOOKS (id,namess) values (1,'AUM')");
            statement.addBatch("insert into BOOKS (id,namess) values (2,'SHRI')");
            statement.addBatch("insert into BOOKS (id,namess) values (3,'SAI')");
            statement.addBatch("insert into BOOKS (id,namess) values (4,'RAM')");

            if (statement.executeBatch().length == 6) // executeBatch()- возвращает массив операций выполненных
            {
                connection.commit();
            } else {
                connection.rollback();
            }
        }

 */


        // Уровни изоляции транзакций (когда при выполнении транзакций, другая меняет данные или выводит данные
        //   то данные могут неправильно сохранится, чтобы не было
        //  connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); )



/*
        try (Connection connection = DriverManager.getConnection(conect, user, password);
             Statement statement = connection.createStatement()) {

            connection.setAutoCommit(false); //не выполнится пока не connection.commit(); создание таблиц(Метаданные) не (Rollback) откатывается

            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);


         //   statement.execute("update Books set namess='g' where id=2");

          //  ResultSet resultSet=statement.executeQuery("select * from Books");
            ResultSet resultSet=statement.executeQuery("select count (*) from Books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }


            new OtherTransaction().start();              // в одной транзакции вызыватся другая
            Thread.sleep(2000);


           // ResultSet resultSet2=statement.executeQuery("select * from Books");
            ResultSet resultSet2=statement.executeQuery("select count(*) from Books");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt(1));
            }

            //connection.rollback();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/
 /*
static class OtherTransaction extends Thread {
    @Override
    public void run() {
        try (Connection connection = DriverManager.getConnection(conect, user, password);
             Statement statement = connection.createStatement()) {

            connection.setAutoCommit(false); //не выполнится пока не connection.commit(); создание таблиц(Метаданные) не откатывается

            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

          //  statement.execute("update Books set namess='g' where id=2");    // меняем в исполняемом методе на TRANSACTION_REPEATABLE_READ
                                                                              // и тогда одинаковый вывод содержания столб.



            statement.executeUpdate("insert into Books (namess) values ('AUMM')");  // меняем в исполняемом методе на TRANSACTION_SERIALIZABLE
                                                                                        // и тогда идинаковый вывод количества столбов в табл.
            connection.commit();

           // ResultSet resultSet = statement.executeQuery("select * from Books");
           // while (resultSet.next()) {
           //     System.out.println(resultSet.getString("namess"));
           // }



        } catch (SQLException throwables) {
            System.out.println("BLAAAAAAAAAAAAAAA");
        }
    }
}*/


 /*
    public static ResultSet getDAta() throws ClassNotFoundException, SQLException {  // метод создания таблицы, возвращает cachedRowSet

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection=DriverManager.getConnection(conect, user, password);
        Statement statement=connection.createStatement();
        statement.execute("drop table Books");
        statement.executeUpdate("create table BOOKS(Id integer ,namess char(30))");

        statement.executeUpdate("insert into BOOKS (id,namess) values (1,'AUM')");
        statement.executeUpdate("insert into BOOKS (id,namess) values (2,'SHRI')");
        statement.executeUpdate("insert into BOOKS (id,namess) values (3,'SAI')");
        statement.executeUpdate("insert into BOOKS (id,namess) values (4,'RAM')");


        RowSetFactory rowSet=RowSetProvider.newFactory();
        CachedRowSet cachedRowSet=rowSet.createCachedRowSet();


        Statement statement2=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet=statement2.executeQuery("select * from books");

        cachedRowSet.populate(resultSet);      // кэшируем полученные данные в cachedRowSet

        return cachedRowSet;

    }
*/

    }
}

