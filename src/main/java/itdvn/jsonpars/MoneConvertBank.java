package itdvn.jsonpars;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MoneConvertBank {

   // @SerializedName("ccy") // Gson реализация класса для json
    @JsonProperty("ccy")  // Jackson реализация класса для json
    private String from;
   // @SerializedName("base_ccy")
    @JsonProperty("base_ccy")
    private String to;
  //  @SerializedName("buy")
    @JsonProperty("buy")
    private BigDecimal buy;
  //  @SerializedName("sale")
    @JsonProperty("sale")
    private BigDecimal sale;

    public MoneConvertBank() {
    }

    public MoneConvertBank(String from, String to, BigDecimal buy, BigDecimal sale) {
        this.from = from;
        this.to = to;
        this.buy = buy;
        this.sale = sale;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "MoneConvertBank{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}
