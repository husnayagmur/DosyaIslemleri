import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MetinDosyasindanCharDizisiOkumak {
    public static void main(String[] args) {
        /*
        Veri Türü:

Metin dosyası, birden çok karakterden oluşan bir diziyi (string) içerir. Örneğin, bir kitap sayfası veya bir paragraflık metin olabilir.
char, tek bir karakteri temsil eder, yani metin dosyasındaki her bir sembol bir char olarak kabul edilir.
Kapsam:

Bir metin dosyası birçok karakter içerir (örneğin, "Merhaba Dünya!" bir metin dosyasının içeriği olabilir).
char sadece bir tane karakter içerir (örneğin, 'M' bir char'dır).*/
        File file=new File("C:\\Users\\PC\\Desktop\\JAVA\\Java301DosyaIslemleri\\FileStream.txt");
        if(file.exists()){
            FileReader fileReader=null;
            try {
                fileReader=new FileReader(file);
               /* int c=0;
                while ((c=fileReader.read())!=-1){
                    System.out.print((char)c);
                }byte byte okuma*/
                char[] buffer=new char[1024];//Bu kod, bir dosyayı daha verimli bir şekilde okuyarak içeriğini ekrana yazdırıyor.
                /*
                Açıklama: Dosyanın uzunluğu kadar bir char dizisi (buffer) oluşturuluyor.
file.length() dosyanın byte cinsinden uzunluğunu döndürür. Bu uzunluk, dosyadaki karakter sayısına karşılık gelir.
Bu bilgi, tam dosya boyutunda bir buffer (arabellek) oluşturmak için kullanılır. Bu buffer, dosyadan okunan karakterlerin geçici olarak depolanacağı yerdir.*/
                int length=0;
                StringBuilder stringBuilder=new StringBuilder();
                /*
Açıklama: StringBuilder, dinamik olarak büyüyen bir dizi oluşturur ve bu sınıf,
verimli bir şekilde string birleştirme işlemleri yapar. Okunan verileri bu yapıya ekleyerek bir metin oluşturulacak.*/
                while ((length=fileReader.read(buffer))!=-1){
                    /*
                    fileReader.read(buffer) metodu, dosyadan buffer büyüklüğünde veri okur ve okunan karakter sayısını döndürür. Eğer dosyanın sonuna gelinmişse -1 döndürür.
Her okuma işleminde, dosyanın bir kısmı buffer dizisine depolanır, ve okunan karakter sayısı length değişkeninde tutulur.*/
                    stringBuilder.append(Arrays.copyOfRange(buffer,0,length));
                    /*
                     Bu kısım, buffer dizisindeki karakterlerin bir alt kümesini alır. Yani, buffer'daki ilk length karakteri kopyalar.
                     buffer: Dosyadan okunan karakterlerin depolandığı geçici dizi (char array). Boyutu, dosya boyutuna veya okuma parçasına göre değişebilir.
                     0: Kopyalamaya başlanan başlangıç indeksi, yani dizinin sıfırıncı (ilk) elemanından itibaren kopyalama yapılır.
                     length: Kaç karakter kopyalanacağını belirtir. Bu, fileReader.read(buffer) işlemi sırasında döndürülen değerdir. Her okuma işlemi sonrasında length, o okuma işleminde kaç karakterin başarıyla okunduğunu gösterir.
                     */
                }System.out.println(stringBuilder.toString());
                /*fileReader.read(buffer);//performanslı okuma.
                System.out.println(new String(buffer));*/
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(fileReader!=null){
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }else {
            System.out.println("Dosya Bulunamadi.");
        }
    }
}

