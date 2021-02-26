package itdvn.xmlparsing;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AllCity {

    private  Cityy cityy;
    private String street;
    private int house;

    public AllCity() {
    }

    public AllCity(Cityy city, String street, int house) {
        this.cityy = city;
        this.street = street;
        this.house = house;
    }

    public Cityy getCity() {
        return cityy;
    }
    @XmlElement
    public void setCity(Cityy city) {
        this.cityy = city;
    }

    public String getStreet() {
        return street;
    }
    @XmlElement
    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }
    @XmlElement
    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "AllCity{" +
                "cityy=" + cityy +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }
}
