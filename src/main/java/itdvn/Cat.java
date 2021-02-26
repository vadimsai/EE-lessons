package zadachi;

import java.lang.reflect.Field;

public class Cat {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        zadachi.Animal animal=new zadachi.Animal();

        Class<?> clas= zadachi.Animal.class;

//        Создайте 2 класса, Animal и Cat.
//        В классе Animal инициализируйте 3 поля различных модификаторов.
//                В классе Cat используя рефлексию получите доступ к полям класса Animal и измените содержимое каждого
//        из полей.

        Field[] fields=clas.getDeclaredFields();
        for (Field e : fields) {
            System.out.println(e.getName());
            Class<?> type=e.getType();
            System.out.println(type.getName());
        }

        Field field=clas.getField("age");
        Field field2=clas.getDeclaredField("eat");
        Field field3=clas.getDeclaredField("jump");
        field.set(animal,77777);
        field3.setAccessible(true);
        field2.setAccessible(true);
        field2.set(animal,"Meme");
        field3.set(animal, "higher");
        System.out.println(" : "+ animal.age+" "+animal.jump+" "+field2.get(animal));
    }
}
