import java.io.*;

public class SerializationLab {
    public static void yaz(){
        SerializationLab_Araba araba = new SerializationLab_Araba();
        araba.setPlaka("324 AB 789");
        araba.setMarka("X Marka");
        araba.setMarka("Y Model");
        araba.setYil(2020);

        SerializationLab_Motor motor = new SerializationLab_Motor();
        motor.setHacim(1600);
        araba.setMotor(motor);

        System.out.println(araba);
        File file=new File("araba.bin");
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {

            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(araba);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if(objectOutputStream!=null){
                    objectOutputStream.close();
                }
                if(fileOutputStream!=null) {
                    fileOutputStream.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void oku(){
        File file=new File("araba.bin");
        if(file.exists()){
            FileInputStream fileInputStream=null;
            ObjectInputStream objectInputStream=null;
            try {
                fileInputStream=new FileInputStream(file);
                objectInputStream=new ObjectInputStream(fileInputStream);
               SerializationLab_Araba araba=(SerializationLab_Araba) objectInputStream.readObject();
               System.out.println(araba);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally {
                try {
                    if(objectInputStream!=null){
                        objectInputStream.close();
                    }if (fileInputStream!=null){
                        fileInputStream.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public static void main(String[] args) {
        //yaz();
        oku();
    }
}
