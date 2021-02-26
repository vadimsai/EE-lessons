package patterns;


//Возможность получать данные из базы данных или файлов не меняя код во всем проекте
// путем создания интерфейса и имплементирую его метод

public class Dao {
    public static void main(String[] args) {

        Data df=new Filess();
        Data dd=new DataBases();
        System.out.println(df.getData());
        System.out.println(dd.getData());

    }
}

interface Data         // интерфейс
{
    String getData();
}

class DataBases implements Data
{
    public String getDB()
    {
      return  "database";
    }

    @Override
    public String getData() {   // метод интерфейса
        return getDB();
    }
}

class Filess implements Data
{
    public String getFile()
    {
        return "file";
    }

    @Override
    public String getData() {
        return getFile();
    }  // передаем метод getFile
}