package patterns;


// сохраняем статус одного объекта в другой и можем получить этот статус


public class Momento {
    public static void main(String[] args) {

        Originat o=new Originat();
        o.setStatus("SAI"); // статус
        Care c=new Care();
        c.setM(o.creatMom()); // сохраняем статус
        o.setStatus("RAM");   // новый статус
        o.getFromMom(c.getM());  // получаем сохраненный статус
        System.out.println(o.getStatus());




    }
}

class Care               // класс реализации
{  Moment m;


    public Moment getM() {
        return m;
    }

    public void setM(Moment m) {
        this.m = m;
    }
}

class Originat       // класс сохраняемый
{
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Moment creatMom()        // метод сохранения статуса в объект Moment
    {
        return new Moment(status);
    }
    public void getFromMom(Moment m)   // метод  получения статуса
    {
       this.status=m.getStatus();
    }
}

class Moment                  // класс  куда сохраняем
{
    String status;

    public Moment(String status)
    {
        this.status=status;
    }

    public String getStatus() {
        return status;
    }
}