import java.io.File;//File: Dosyaları temsil eder.
import java.io.FileOutputStream;//FileOutputStream: Byte seviyesinde dosyaya veri yazmak için kullanılır.
import java.io.IOException;/*IOException: I/O (Girdi/Çıktı) işlemlerinde hata durumlarını yönetmek için kullanılan istisnadır.
java*/


public class FileStreamWriter {//Bu satır, FileStream isimli bir sınıf tanımlıyor. Java programlarında sınıflar, programın temel yapı taşlarıdır.
    public static void main(String[] args) {
        File file=new File("Hello.txt");
        /*Burada, File sınıfından bir nesne oluşturuluyor ve "Hello.txt" adında bir dosya temsil ediliyor.
Bu dosya, belirtilen isimde mevcut değilse program bu dosyayı oluşturur.*/
        FileOutputStream fileOutputStream=null;
        /*
        * FileOutputStream nesnesi oluşturuluyor fakat henüz başlatılmıyor. İlk başta null olarak ayarlanıyor.
Dosyaya yazma işlemi yapılırken oluşabilecek istisnalar (hatalar) için bu nesne önceden tanımlanıyor.*/
        try {
            fileOutputStream=new FileOutputStream(file);
            /*
            * FileOutputStream nesnesi, dosyaya veri yazmak için başlatılıyor.
Eğer Hello.txt adlı dosya zaten mevcutsa, üzerine yazma işlemi yapılır. Eğer yoksa, yeni bir dosya oluşturulur.*/
            fileOutputStream.write("Merhaba".getBytes());
            /*
            * Dosyaya "Merhaba" metni byte dizisine çevrilerek yazılıyor. getBytes() metodu,
String'i byte dizisine dönüştürür çünkü write metodu byte dizisi kabul eder.*/
        }catch (IOException e) {//Eğer dosya yazma sırasında bir hata (örneğin dosya bulunamazsa ya da yazılamazsa) oluşursa, IOException yakalanır ve hatanın mesajı ekrana yazdırılır.
            System.out.println(e.getMessage());
        }finally {
            if(fileOutputStream!=null){
                /*finally bloğu, hatalar olsa bile her zaman çalışır.
Bu blokta dosya akışını kapatma işlemi yapılır.
fileOutputStream nesnesinin null olup olmadığı kontrol edilir.
Eğer null değilse, yani dosya akışı oluşturulmuşsa, kapatma işlemi yapılır.*/
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                /*
                * Dosya akışını kapatmak için close() metodu çağrılır.
Eğer bu işlem sırasında bir hata olursa (örneğin dosya sisteminde bir sorun varsa), bu hata yakalanır ve detaylı hata mesajı konsola yazdırılır (e.printStackTrace()).*/
            }
        }
    }
}
/*
 * File stream, dosya okuma ve yazma işlemleri için kullanılan bir veri akışıdır. Kısaca maddelersek:
 *Dosya İle Program Arasında Veri Akışı Sağlar: Dosyadan veri okumak veya dosyaya veri yazmak için kullanılır.
 *InputStream ve OutputStream: Java'da dosya okuma için InputStream, dosya yazma için OutputStream kullanılır.
 *Byte ve Karakter Tabanlı: Dosyalarla çalışırken byte tabanlı ve karakter tabanlı stream'ler mevcuttur (FileInputStream, FileOutputStream, FileReader, FileWriter gibi).
 *Seri Veri Akışı: Veriler, belirli bir sırayla ve kesintisiz bir akış içinde iletilir.
 *Kaynakların Kapatılması Gerekir: Dosya akışları kullanıldıktan sonra kaynaklar genellikle kapatılmalıdır (close() metodu ile).
 *Bu yapı, dosya işlemlerini daha sistematik ve güvenli bir şekilde yapmayı sağlar.
 */

