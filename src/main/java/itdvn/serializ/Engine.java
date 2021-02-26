package itdvn.serializ;

public class Engine {

    private int power;
    private String producer;

    public Engine() {
    }

    public Engine(int power,String producer) {
        this.power = power;
        this.producer=producer;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power=" + power +
                ", producer='" + producer + '\'' +
                '}';
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
