package patterns;


// MVC



public class Mvc {
    public static void main(String[] args) {

        Controller c=new Controller();
        c.exec();
    }
}

class Itworker
{
   String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


interface Model    //  обработка информации
{
    Itworker getItworker();
}

class DB implements Model     //  получаем данные из DB или File
{
    @Override
    public Itworker getItworker() {
        return new Itworker();
    }
}

class Files implements Model
{
    @Override
    public Itworker getItworker() {
        return new Itworker();
    }
}

interface View       //  вывод на экран
{
    public void Show(Itworker i);
}

class Consoles implements View    // выводим данные в Console или Html
{
    @Override
    public void Show(Itworker i) {
        System.out.println("Console" + i.getName());
    }
}

class Html implements View
{
    @Override
    public void Show(Itworker i) {
        System.out.println("<html><body>" + i.getName()+ "</body </html>");
    }
}

class Controller      // обработка  Model и  вывод View
{
    Model m=new DB();
    View v= new Consoles();

    public void exec()
    {
        Itworker i=m.getItworker();
        v.Show(i);
    }
}












