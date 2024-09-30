import java.io.Serializable;

public class Serialization_Ogrenci implements Serializable {
    //Serializable implement ettik lazin icinde birsey yoktur fakat yapmamız gerekir.
    // Bu interfacelere isaretleyici interface denir.

    private String ad;//string int...serilestirilebilirdir.
    private String soyad;
    private String sinif;
    private int numara;

    public Serialization_Ogrenci() {
//serilestirmek icin parametresiz constructor gereklidir.
    }
    public Serialization_Ogrenci(int numara,String ad,String soyad,String sinif) {
        this.numara=numara;
        this.ad = ad;
        this.soyad = soyad;
        this.sinif = sinif;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }
    @Override
    public boolean equals(Object obj){
        Serialization_Ogrenci ogrenci=(Serialization_Ogrenci) obj;
        return  this.numara==ogrenci.numara;
    }
    @Override
    public String toString(){
        return "Numara: "+numara+" İsim: "+ad+" Soyisim: "+soyad+" Sinif: "+sinif;
    }
}
