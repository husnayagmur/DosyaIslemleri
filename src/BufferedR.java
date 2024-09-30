import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedR {
    public static void main(String[] args) {
        /*
        Java'da Buffered, genellikle okuma ve yazma işlemlerini hızlandırmak amacıyla kullanılan bir yapıdır.
Buffered yapılar, veri giriş/çıkış işlemlerinde tamponlama (buffering) yaparak performansı artırır.
Bir dosya okuma veya yazma işlemi sırasında, veriler doğrudan diskten veya ağdan okunup yazılırsa,
bu işlemler oldukça yavaş olabilir. Buffered sınıfları ise, verileri önce bir tamponda (bellekte) tutar ve bu tampon dolduğunda işlemleri topluca gerçekleştirir.
Bu sayede, daha az sayıda okuma/yazma işlemi yapılır ve performans artar.

Java'da sıkça kullanılan Buffered sınıflar şunlardır:
BufferedReader: Karakter tabanlı verileri okurken kullanılır. Örneğin, bir dosyadan satır satır veri okumak için kullanılır.
BufferedWriter: Karakter tabanlı verileri yazarken kullanılır. Yazma işlemleri daha verimli hale getirilir.
         */
        File file=new File("C:\\Users\\PC\\Desktop\\JAVA\\JAVA301\\FileStream.txt");
        java.io.BufferedReader bufferedReader=null;
        FileReader fileReader=null;
        try {
            fileReader=new FileReader(file);
            bufferedReader=new java.io.BufferedReader(fileReader);
            String line=null;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

