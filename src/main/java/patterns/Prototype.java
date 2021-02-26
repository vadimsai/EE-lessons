package patterns;

// копирование объектов

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
         Hash h=new Hash();
         h.setS(new Student());   //  кладем новый объект в сеттер
         h.getS();                 // и гет возвращает его с методом  cl() в котором вызывам clone()
    }
}

class Student implements Cloneable
{
    public Student cl() throws CloneNotSupportedException
    {
        return (Student) super.clone();
    }
}

class Hash
{
    private Student s;

    public Student getS() throws CloneNotSupportedException
    {
        return s.cl();
    }
    public void  setS(Student s)
    {
        this.s=s;
    }
}