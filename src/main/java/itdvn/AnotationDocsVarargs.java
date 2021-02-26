package zadachi;

import javax.inject.Inject;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
* @author Vadim Novikov
 */
public class AnotationDocsVarargs {
    /**
     * person field- name
     */
    @MySAI2("RAM")
    @MySAI2("AUM")
    @MySAI2("BABADGI")
    private String name;


    /**
     * @param name for Costructor
     */
    public AnotationDocsVarargs(String name) {
        this.name = name;
    }

    public AnotationDocsVarargs() {
    }

    /**
     * @return name for getName
     */
    public String getName() {
        return name;
    }


    public static void main(String[] args) throws NoSuchMethodException {

        // VARARGS- аргументы переменной длины(как массив), всегда на последнем месте в методе
        AnotationDocsVarargs a = new AnotationDocsVarargs();
        List<Integer> list = new ArrayList<>();
        a.sumVar(list, 1, 2, 4);// передаем несколько аргументов в дженерик list
        a.sumVar(list, 5, 34);// добавляем

        for (Integer e : list) {
            System.out.println(e);
        }


        Class<?> classAno=AnotationDocsVarargs.class;
        Method m=classAno.getDeclaredMethod("Sums", int.class, int.class); // получаем все методы
        Sum sum=m.getAnnotation(Sum.class); // получаем анотацию
        a.Sums(sum.n(),sum.n2()); // вызываем метод и в него кладем полученную анотацию с параметрами



    }

    @Documented  // будет задокументированна
    @Inherited  // классы наследники будут проанотированны
    @Target({ElementType.FIELD,ElementType.METHOD}) // к чему применяется
    @Retention(RetentionPolicy.RUNTIME) // когда применяется
    @interface MySAI{ MySAI2[] value();   //String value();
    String s() default "AUM";
    int i() default 10+10;
    enum My{WHITE, BLACK, PINK}
    }

    @FunctionalInterface // интерфейс должен содержать только один метод
    interface Myinterface
    {
        int i();
    }

    @Repeatable(MySAI.class) // для использования анотации несколько раз на одном методе
    @interface MySAI2{String value();}


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Sum{int n() default 0; int n2() default 0;} // анотация с параметрами




    @Sum(n=5,n2 = 999) // передаем параметры в метод через аннотацию
    public void Sums(int number, int number2)
    {
        System.out.println(number+number2);
    }





    public static <E> List sumVar(List<E> list, E... array) {

        for (E element : array) {
            list.add(element);
        }
        return list;
    }



}