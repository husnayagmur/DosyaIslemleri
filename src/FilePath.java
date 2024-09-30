import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FilePath {
    public static void main(String[] args) {
        /*
        * File:File, bir dosyayı veya dizini (klasörü) temsil eden bir yapıdır.
Programlarda dosya üzerinde işlem yapmak (okuma, yazma, silme, oluşturma vb.) için File sınıfı kullanılır.
File sınıfı, dosya veya dizinle ilgili bilgilere erişmek ve işlemler yapmak için çeşitli metodlar sağlar.
Örnek: File file = new File("dosya.txt");

*Path:Path, bir dosyanın veya dizinin bilgisayarın dosya sistemindeki yerini (konumunu) gösterir.
Path, dosya veya dizine erişim için gerekli olan tam yolu (örn. "C:/Users/Documents/dosya.txt") içerir.
Relative Path (göreceli yol) ve Absolute Path (mutlak yol) olmak üzere iki tür yol vardır:
Relative Path: Dosyanın konumu, programın çalışma dizinine göre belirtilir. Örneğin: "dosya.txt".
Absolute Path: Dosyanın tam konumu, kök dizinden başlar. Örneğin: "C:/Users/username/Documents/dosya.txt".*/
        File file=new File("C:\\Users\\PC\\Desktop\\JAVA\\Java301DosyaIslemleri\\FilevePath.txt");
        System.out.println(file.exists());
        /*
        file.exists():
file, bir File nesnesidir. Bu nesne, bir dosya ya da dizini (klasörü) temsil eder.
exists() metodu, dosyanın veya dizinin mevcut olup olmadığını kontrol eder.
Eğer file ile gösterilen dosya veya dizin, belirtilen konumda mevcutsa, true döner.
Eğer dosya veya dizin bulunamazsa, false döner.*/
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        /*
        file.canRead():
canRead() metodu, dosyanın okunabilir olup olmadığını kontrol eder.
Eğer dosya okunabilir durumdaysa (okuma izni varsa), true döner.
Dosya okunamaz durumdaysa (okuma izni yoksa), false döner.
        file.canWrite():
canWrite() metodu, dosyanın yazılabilir olup olmadığını kontrol eder.
Eğer dosya yazılabilir durumdaysa (yazma izni varsa), true döner.
Dosya yazılamaz durumdaysa (yazma izni yoksa), false döner.*/
        System.out.println(file.isDirectory());
        /*
        file.isDirectory():
isDirectory() metodu, file nesnesi ile temsil edilen şeyin bir dizin (klasör) olup olmadığını kontrol eder.
Eğer file bir dizin ise, true döner.
Eğer file bir dizin değilse (yani bir dosya ise), false döner.*/
        System.out.println(file.getAbsoluteFile());
        /*
        file.getAbsoluteFile():
getAbsoluteFile() metodu, dosyanın tam yolunu (mutlak yolunu) içeren bir File nesnesi döner.
Mutlak yol, dosyanın sistemdeki tam konumunu belirtir ve genellikle kök dizinden başlayarak dosyanın bulunduğu yeri gösterir.*/
        System.out.println(file.length());//length() metodu, dosyanın boyutunu byte cinsinden döner.
        System.out.println(new Date (file.lastModified()));
        /*
        new Date(file.lastModified()):
new Date(...) yapıcısı, milisaniye cinsinden geçen zamanı bir Date nesnesine dönüştürür.
Bu, milisaniye cinsinden verilen değeri daha okunabilir bir tarih ve saat biçimine dönüştürür.*/

        File file2=new File("C:\\Users\\PC\\Desktop\\JAVA\\JAVA301\\FilevePathOlusturma.txt");//dosya olusturma
        if (!file2.exists())
        {
            try {
                file2.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if(file2.exists()){
            boolean silindiMi=file2.delete();
            System.out.println(silindiMi);
        }

        Scanner scanner=new Scanner(System.in);
        System.out.println("Dosya Yolu: ");
        String path=scanner.nextLine();
        File file3=new File(path);
        String[] icerik=file3.list();
        for (int i=0;i<icerik.length;i++){
            System.out.println(icerik[i]);
        }
        scanner.close();

    }
}

