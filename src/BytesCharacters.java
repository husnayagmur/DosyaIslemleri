import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class BytesCharacters {
    public static void main(String[] args) {
        /*
        Bytes (Baytlar)
1. Dosya Okuma/Yazma:

Binary Dosyalar: Resim, video, ses dosyaları gibi ikili (binary) formatta veri içeren dosyalarla çalışırken kullanılır.
Örneğin, bir JPEG resmi veya bir MP3 ses dosyası byte dizileri olarak saklanır.
Dosya Okuma/Yazma İşlemleri: Dosyanın içeriğini byte byte okuma ve yazma işlemlerinde kullanılır.
Java'da FileInputStream ve FileOutputStream sınıfları byte verileri ile çalışır.

Characters (Karakterler)
1. Metin İşleme:

Metin Dosyaları: Karakter tabanlı dosyalar (örneğin, .txt dosyaları) ile çalışırken kullanılır.
Java'da FileReader ve BufferedReader sınıfları karakter verileri ile çalışır.
Metin Analizi ve Düzenleme: Metin analizinde ve düzenlemesinde karakterler kullanılır.
Örneğin, bir metin dosyasındaki belirli karakterleri değiştirmek veya aramak.*/
        File file=new File("C:\\Users\\PC\\Desktop\\JAVA\\Java301DosyaIslemleri\\pc.png");//file nesnesi, belirtilen dosya yolundaki (bu durumda bir resim dosyası) bir File nesnesi oluşturur.
        if(file.exists()){
            FileInputStream fileInputStream=null;//Dosyayı byte düzeyinde okumak için kullanılacak FileInputStream nesnesini başlatır.
            try {
                fileInputStream=new FileInputStream(file);//fileInputStream nesnesini, belirtilen dosyayı okumak için başlatır.
                byte[] buffer=new byte[2000];
                int lenght=0;//Okunan byte sayısını saklayacak bir length değişkenini başlatır.
                while ((lenght=fileInputStream.read(buffer))!=-1){/*read() metodu ile dosyadan byte'ları okur ve buffer dizisine yazar.
                    Dosyanın sonuna gelinmediği sürece döngü devam eder. -1 dönerse, dosya sonuna ulaşılmış demektir.*/
                    System.out.println(Arrays.toString(buffer));
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }finally {
                if(fileInputStream!=null){
                    try {
                        fileInputStream.close();
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}

