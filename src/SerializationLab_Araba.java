import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.time.OffsetTime;

public class SerializationLab_Araba implements Serializable {
    private String plaka;
    private String model;
    private String marka;
    private int yil;
    private SerializationLab_Motor motor;

    public SerializationLab_Araba() {
    }
    public SerializationLab_Araba(String plaka,String model,String marka,int yil,SerializationLab_Motor motor) {
        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.motor=motor;
    }

    public SerializationLab_Motor getMotor() {
        return motor;
    }

    public void setMotor(SerializationLab_Motor motor) {
        this.motor = motor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getYil() {
        return yil;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }
    @Override
    public boolean equals(Object other){
        SerializationLab_Araba araba=(SerializationLab_Araba) other;
        return  this.plaka.equals(araba.plaka);
    }
    @Override
    public String toString(){
        return "Plaka:"+plaka+","+"Marka:"+marka+","+"Model:"+model+","+"Yil:"+yil+","+"Motor:"+motor.toString();
    }
}
