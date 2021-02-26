package patterns;


// чтобы не создавать много кострукторов и вносить разные поля при создании объекта класса


public class Bullder {
    public static void main(String[] args) {
           Swami Sai=new Swami.Bulder("SAI").setMantra("AUM SAI RAM").obS();
           Swami Babadgi=new Swami.Bulder("Babadgi").setMantra("AUM BABADGI").obS();
           Swami V=new Swami.Bulder("Vadim").obS();
        System.out.println(Sai);
        System.out.println(Babadgi);
        System.out.println(V);
    }
}

class Swami
{
  private String name;          //  все переменные  private
  private int kol;
  private String mantra;

   public String getName() {      // только Геттеры
       return name;
   }
   public int getKol() {
       return kol;
   }
   public String getMantra() {
       return mantra;
   }

   private Swami(Bulder b)          //  коструктор private параметры объект Bulder
   {
       this.name=b.name;
       this.kol=b.kol;
       this.mantra=b.mantra;
   }
   public String toString()
   {
       return name+" "+kol+" "+mantra;
   }
static class Bulder                     //  Вложенный класс static
{
    private String name;
    private int kol=111;              //  можем установить постоянное значение
    private String mantra;

    public Bulder(String name)       // обязательное поле в кострукторе
    {
        this.name=name;
    }

   // public Bulder setKol(int kol) {
   //     this.kol = kol;
   //     return this;
   // }

    public Bulder setMantra(String mantra) {
        this.mantra = mantra;
        return this;                           //  возвращаемое значение this
    }
    public Swami obS()                 // метод создания объекта главного класса
    {
        return new Swami(this);
    }

}

}