package zadachi;

import java.lang.reflect.*;

public class ReflectionI {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        ReflectionI reflectionI=new ReflectionI();
        Class<?> clas=ReflectionI.class; // получаем объект класса
        Class<?> cl=Class.forName("java.lang.String"); // получам объект String

        int[] arr=new int[10];
        Class<?> clasarr=arr.getClass(); // получаем массив
        Class<?> clasStr="arr".getClass(); // массив с помощью строки
        Class<?> clasint=Integer.valueOf(5).getClass(); // массив с помощью int

        System.out.println(clas+" "+cl+" "+clasarr+" "+clasStr+" "+clasint);



        String s= (char)27+"[31m"; // красный цвет
        String s1= (char)27+"[34m"; // синий цвет
        String s2= (char)27+"[30m";
        String s3= (char)27+"[32m";
        Class<?> clasCat=Cat.class;
        Field[] fields=clasCat.getFields(); // только public поля

        for (Field e : fields) {
            Class<?> typef=e.getType();
            System.out.println(s+" "+e.getName());
            System.out.println(typef.getName());
        }

        fields=clasCat.getDeclaredFields(); // все поля

        for (Field e : fields) {
            Class<?> typef=e.getType();
            System.out.println(s1+" "+e.getName());
            System.out.println(typef.getName());
        }

        Constructor<?>[] constructors=clasCat.getConstructors(); // параметры конструктора и типы
        for (Constructor<?> e : constructors) {
            Class<?>[] paramType=e.getParameterTypes();
            for (Class<?> e2 : paramType) {
                System.out.println(s2+" "+e2.getName());
            }
        }


        Class<?>[] paramTypep=new Class<?>[]{int.class};
        Constructor<?> constructor = clasCat.getConstructor(paramTypep);
        Cat cat= (Cat) constructor.newInstance(Integer.valueOf(111)); // изменяем значение поля через конструктор
        System.out.println(s+" "+ cat.getAge()+" "+cat.getName()+" "+cat.getEars()+" "+cat.getTail());




        Method[] methods=clasCat.getMethods(); // получаем все методы
        for (Method e : methods) {
            System.out.println(s3+" "+e.getName());
            System.out.println("\t"+e.getReturnType().getName()); // вовращаемое значение
            Class<?>[] paramType=e.getParameterTypes(); //  параметры с возвращаемым значением
            for (Class<?> e2 : paramType) {
                System.out.println(s1+" "+e.getName());
            }
        }

        Cat cat1=new Cat();
        Class<?>[] pT=new Class<?>[]{int.class};
        Method method=clasCat.getMethod("setAge", pT); // через какое поле будем изменять
        Object[] obj=new Object[]{Integer.valueOf(999)}; //массив объектов, изменяем значение
        method.invoke(cat1,obj);
        System.out.println(s+""+ cat1.getAge());


        int mod=clasCat.getModifiers(); // получаем модификатор класса
        if(Modifier.isPrivate(mod)) {
            System.out.println("private "+mod);
        }


        Cat cat2=new Cat();
        Field field=clasCat.getDeclaredField("age"); // получаем приватное поле
        field.setAccessible(true); // все модификаторы опускаем до public
        field.setInt(cat2,333); // назначаем значение
        System.out.println(field.getInt(cat2));

/*
        Class<?> c=Class.forName(args[0]); // здесь ошибка(в натройках вроде)
        System.out.println(c);
        printMemb(c.getConstructors());
        printMemb(c.getFields());
        printMemb(c.getMethods());
*/

    }

    private static void printMemb(Member[] members)
    {
        for (int i = 0; i < members.length; i++) {
            if (members[i].getDeclaringClass() == Object.class) {
                continue;
            }
            String decl=members.toString();
            System.out.println("   ");
            System.out.println(decl);
        }
    }

private static final class Cat{
            public String name= "SAI";
            private int age =777;
            short ears=555;
            protected long tail= 333;

    public Cat() {
    }

    public Cat(int age) {
            this.age = age;
        }

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Cat(String name, int age, short ears, long tail) {
            this.name = name;
            this.age = age;
            this.ears = ears;
            this.tail = tail;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public short getEars() {
            return ears;
        }

        public long getTail() {
            return tail;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setEars(short ears) {
            this.ears = ears;
        }

        public void setTail(long tail) {
            this.tail = tail;
        }
    }
}
