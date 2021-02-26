package patterns;

public class Car {      // относится к фильтрации
    int Speed;
    int Doors;
    String color;

    public Car(int Speed,int Doors,String color)
    {
        this.color=color;
        this.Doors=Doors;
        this.Speed=Speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public int getDoors() {
        return Doors;
    }

    public void setDoors(int doors) {
        Doors = doors;
    }


    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }
    public String toString()
    {
        return Speed+" "+Doors+" "+color;
    }
}
