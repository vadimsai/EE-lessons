package itdvn.serializ;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Bmw extends Car implements Serializable {

    private static int staticNumber; // static поле не записывает, но можно записать передавая
    private int nonStaticNnmber;



    private int price;
    private String model;
//    private Engine engine;
    transient Engine engine; //если не хочу делать Serializable класс Engine, но тогда поле Engine=null




    public Bmw(int weight, int nonStaticNnmber, int price, String model, Engine engine) {
        super(weight);
        this.nonStaticNnmber = nonStaticNnmber;
        staticNumber=nonStaticNnmber;
        this.price = price;
        this.model = model;
        this.engine = engine;

    }

    @Override
    public String toString() {
        return "Bmw{" +
                "nonStaticNnmber=" +staticNumber+" "+ nonStaticNnmber +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    private void writeObject(ObjectOutputStream oos)  // запись для transient поля, методы private(только для этого класса)
    {
        try{

            oos.defaultWriteObject();
            oos.writeInt(engine.getPower());
            oos.writeObject(engine.getProducer());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois) // чтение для transient поля
    {
        try {

            ois.defaultReadObject();
            this.engine = new Engine(ois.readInt(), (String) ois.readObject());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
