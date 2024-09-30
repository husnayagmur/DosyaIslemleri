import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileStreamReader {
    public static void main(String[] args) {
        File file=new File("Hello.txt");
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream(file);
            int c=0;//Okunan byte'ları depolamak için bir int değişkeni tanımlanıyor.
            while ((c=fileInputStream.read())!=-1){
                /*read() metodu, dosyadan bir byte okur ve okunan byte'ı c değişkenine atar.
                -1 değeri, dosyanın sonuna ulaşıldığını belirtir. Döngü, dosyanın sonuna kadar devam eder.*/
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
/*
*  int c = 0; int tipi 32-bitlik bir tam sayı tipidir.
Burada byte verilerini depolamak için kullanılıyor çünkü FileInputStream.read() metodu bir int değeri döner.
read() metodu aslında bir byte'ı okumakla birlikte, dönen değerin tam olarak 1 byte olması için int kullanılır.
Bunun nedeni, read() metodunun dosyanın sonuna geldiğini belirlemek için -1 döndürebilmesidir.
Byte tipi -128 ile 127 arasında değer alır, bu yüzden dosya sonunu işaretlemek için -1 kullanılır ve bu işaret ancak int tipi ile depolanabilir.

*while ((c = fileInputStream.read()) != -1)Bu satır, dosyadan verileri okuyan bir döngüdür.fileInputStream.read():
Bu metodun görevi dosyadan bir byte okumaktır.
Bir byte'ı okur ve bunu int tipinde döner. Eğer dosyanın sonuna ulaşılmadıysa, okunan byte'ın değeri 0 ile 255 arasında olur
(byte veri tipinde değerler 0 ile 255 arasında temsil edilir).
Eğer dosyanın sonuna ulaşılmışsa, metod -1 döner. Bu, döngünün bitiş koşulunu sağlar.

* System.out.print((char) c);
Bu satırda, okunan her byte ekrana yazdırılır.

(char) c:c değişkeninde okunan byte değeri, bir int olarak tutuluyor (0 ile 255 arasında bir değer veya dosya sonuna ulaşıldıysa -1).
Bu byte değeri char (karakter) tipine dönüştürülür. char tipi, Unicode karakterlerini temsil eder.

İşleyişi Adım Adım:
Program dosyanın içeriğini byte byte okur.
Okunan byte'lar c değişkeninde tutulur.
Eğer read() metodu dosya sonuna ulaşmamışsa, okunan byte char tipine dönüştürülür ve ekrana yazdırılır.
Bu işlem dosyanın sonuna kadar (yani read() metodu -1 döndürene kadar) devam eder.
Bu program, dosyadaki her bir byte'ı okur, karaktere dönüştürür ve ekrana ardışık olarak yazdırır.
 */
