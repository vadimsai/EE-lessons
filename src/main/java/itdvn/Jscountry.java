package zadachi;

import com.google.gson.annotations.SerializedName;

public class Jscountry {
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("street")
    private String street;

    public Jscountry() {
    }

    public Jscountry(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Jscountry{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
