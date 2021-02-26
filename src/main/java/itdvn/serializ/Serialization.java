package itdvn.serializ;

import java.io.*;

public class Serialization {


/*   Сериализация представляет собой процесс передачи состояния объекта в поток байтов с целью
        сохранения его в памяти, в базе данных или в файле.
     Основное назначение сериализации – сохранить состояние объекта для того, чтобы иметь
         возможность восстановить его в случае необходимости.
     Процесс обратный сериализации называется десериализацией.  */


    public static void main(String[] args) {

        File file=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\serializ\\serialCar.txt");

       // Car car=new Car(7777,"BMWSAI",new Engine(1500, "BMW"));

        Bmw bmw=new Bmw(111,333333,99999,"x7",new Engine(7000,"BMW"));


       try(ObjectOutputStream  oos=new ObjectOutputStream(new FileOutputStream(file));
           ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file)))
       {
           oos.writeObject(bmw);  // сериализуем в байт код


           Bmw bmw1= (Bmw) ois.readObject(); // десериализуем из байт кода
           System.out.println(bmw1);

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }



       File file1=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\serializ\\exterialisab.txt");
       Externalizable externalizable=new Externazibl(111,"SAI");

       try(ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream(file1));
           ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file1)))
       {
           ous.writeObject(externalizable);

           Externalizable externalizable1= (Externalizable) ois.readObject();
           System.out.println(externalizable1);

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }

    }
}
