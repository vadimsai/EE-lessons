package itdvn.clon;

import java.io.*;
import java.lang.reflect.Field;


// 1. Переопределить метод clone() класса Object и реализовать интерфейс Cloneable;
// 2. Использовать конструктор копирования;
// 3. Использовать статический фабричный метод, возвращающий экземпляр своего класса
// 4. Использовать механизм рефлексии
// 5. Использовать механизм сериализации;

public class Clon {

    public static void main(String[] args) throws CloneNotSupportedException, NoSuchFieldException, IllegalAccessException, IOException, ClassNotFoundException {

      // Клон с помощью Serializable (глубокое)
        Group group5=new Group(5);
        Cow cow5=new Cow("AUM",999,555, group5 );
        System.out.println(cow5);

        ByteArrayOutputStream baos=null;  // записывает и читает БАЙТЫ из буфера
        ByteArrayInputStream  bais=null;
        ObjectOutputStream ous=null;
        ObjectInputStream ois=null;

      try {  // в таком формате иначе порядок закрытия и записи нарушается и ошибка
          baos = new ByteArrayOutputStream();
          ous = new ObjectOutputStream(baos);
          ous.writeObject(cow5);

          bais = new ByteArrayInputStream(baos.toByteArray());// копирует
          ois = new ObjectInputStream(bais);

          Cow clonCow5 = (Cow) ois.readObject();
          clonCow5.setName("AUM BABA"); // меняем поля у клона
          clonCow5.setGroup(new Group(7)); // меняем поля у клона

          System.out.println(clonCow5+"\n");
      }finally {
          if(baos!=null)
          {
              baos.flush();
              baos.close();
          }
          if (bais!=null)
          {
              bais.close();
          }
          if (ous!=null)
          {
              ous.flush();
              ous.close();
          }
          if (ois!=null)
          {
              ois.close();
          }
      }



        // Клон с помощью Рефлексии с выносом кода в метод и без выноса (Глубокое)
        Group group4=new Group(4);
        Cow cow4=new Cow("AUM",999,555, group4 );
        System.out.println(cow4);

        Cow clonCow4=reflectCopy(cow4,group4); // Клон с помощью метода
        System.out.println("Metod : "+ clonCow4+"\n ");

    /*    Cow clonCow4=cow4;// Клон Рефлексии без выноса в метод
        Class<?> clas=Cow.class; // Клон Рефлексии без выноса в метод
        Field fieldName=clas.getField("name");
        Field fieldAge=clas.getDeclaredField("age");
        fieldAge.setAccessible(true);
        fieldName.set(clonCow4,"AUM SHRI SAI RAM");
        fieldAge.set(clonCow4,9999999);
        System.out.println(clonCow4);

        Class<?> clasG=Group.class;// отдельно меняем поле id на Group.class
        Field fieldGroup=clasG.getField("id");
        fieldGroup.set(group4, 5);
        System.out.println(clonCow4+"\n ");

*/


        // Фабричный метод копирования (поверхностное)
        Group group3=new Group(3);
        Cow cow3=new Cow("SHRI",999,555, group3 );
        Cow clonCow3=Cow.fabriCopy(cow3); // Фабричный метод копирования
        clonCow3.setName("SHRI SAI RAM"); // меняем поле в клоне через сеттер
        System.out.println(cow3+"\n "+ clonCow3+"\n ");



        // Клон с помощью Конструктора(поверхностное)
        Group group2=new Group(2);
        Cow cow2=new Cow("RAM",999,555, group2 );
        Cow clonCow2=new Cow(cow2);
        System.out.println(cow2 + "\n " + clonCow2);
        clonCow2.name="SAI RAM"; // меняем поле в клоне или clonCow2.setName("SAI RAM");
        System.out.println(cow2 + "\n " + clonCow2+"\n ");



        // Клон с помощью Метода clone() из (Cow implements Cloneable)(поверхностное)
        Group group1=new Group(1);
        Cow cow1=new Cow("BABA",777,33,group1);
        Cow clonCow1 = (Cow) cow1.clone(); // создаем клон
        System.out.println(cow1 + "\n " + clonCow1);
        clonCow1.group.id=11111; // поле group.id в обоих поменяется, т.к. общее
        clonCow1.setName("SAI"); // измениться только в клоне (поля public, то clonCow1.name="SAI")
        System.out.println(cow1 + "\n " + clonCow1);



    }


    public static Cow reflectCopy(Cow cow,Group group) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clas=Cow.class;
        Field fieldName=clas.getField("name");
        Field fieldAge=clas.getDeclaredField("age");
        fieldAge.setAccessible(true);
        fieldName.set(cow,"AUM SHRI SAI RAM");
        fieldAge.set(cow,9999999);

        Class<?> clasG=Group.class;// отдельно меняем поле id на Group.class
        Field fieldGroup=clasG.getField("id");
        fieldGroup.set(group, 5);

        return cow;
    }
}
