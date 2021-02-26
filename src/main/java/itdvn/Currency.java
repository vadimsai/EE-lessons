package itdvn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Currency {
    @JsonProperty("r030")
   private int number;
    @JsonProperty("txt")
   private String name;
    @JsonProperty("rate")
   private BigDecimal Buy;
    @JsonProperty("cc")
   private String abr;
    @JsonProperty("exchangedate")
   private String data;

    public Currency() {
    }

    public Currency(int number, String name, BigDecimal buy, String abr, String data) {
        this.number = number;
        this.name = name;
        Buy = buy;
        this.abr = abr;
        this.data = data;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBuy() {
        return Buy;
    }

    public void setBuy(BigDecimal buy) {
        Buy = buy;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", Buy=" + Buy +
                ", abr='" + abr + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
