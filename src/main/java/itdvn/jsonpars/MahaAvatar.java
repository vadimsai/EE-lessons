package itdvn.jsonpars;



public class MahaAvatar {
    private String eraPrema;
    private String eraSatia;
    private String eraAhimsa;
    private Avatar avatar;

    public MahaAvatar() {
    }

    public MahaAvatar(String eraPrema, String eraSatia, String eraAhimsa, Avatar avatar) {
        this.eraPrema = eraPrema;
        this.eraSatia = eraSatia;
        this.eraAhimsa = eraAhimsa;
        this.avatar = avatar;
    }

    public String getEraPrema() {
        return eraPrema;
    }

    public void setEraPrema(String eraPrema) {
        this.eraPrema = eraPrema;
    }

    public String getEraSatia() {
        return eraSatia;
    }

    public void setEraSatia(String eraSatia) {
        this.eraSatia = eraSatia;
    }

    public String getEraAhimsa() {
        return eraAhimsa;
    }

    public void setEraAhimsa(String eraAhimsa) {
        this.eraAhimsa = eraAhimsa;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "MahaAvatar{" +
                "eraPrema='" + eraPrema + '\'' +
                ", eraSatia='" + eraSatia + '\'' +
                ", eraAhimsa='" + eraAhimsa + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
