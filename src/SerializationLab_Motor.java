import java.io.Serializable;

public class SerializationLab_Motor implements Serializable {
    private int hacim;

    public SerializationLab_Motor() {
    }

    public SerializationLab_Motor(int hacim) {
        this.hacim = hacim;
    }

    public int getHacim() {
        return hacim;
    }

    public void setHacim(int hacim) {
        this.hacim = hacim;
    }
    @Override
    public  String toString(){
        return "Hacim: "+hacim;
    }
}
