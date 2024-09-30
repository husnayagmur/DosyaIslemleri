import java.io.*;

public class InputStreamReader_OutputStreamReader {
    public static void yaz(){
        /*
        InputStreamReader, bir InputStream nesnesinden okunan byte'ları karakterlere dönüştüren bir sınıftır.
Byte verilerini karakter verilerine çevirir, böylece metin verilerini daha rahat bir şekilde işleyebilirsiniz.
OutputStreamWriter, bir OutputStream nesnesine karakterleri byte'lara dönüştüren bir sınıftır.
*/
        File file=new File("test.txt");
        FileOutputStream fileOutputStream=null;
        /*
        fileOutputStream isimli bir FileOutputStream nesnesini tanımlar ve başlangıçta null olarak ayarlar.
Bu nesne, dosyaya byte düzeyinde veri yazmak için kullanılacak.*/
        try {
            fileOutputStream=new FileOutputStream(file);
            /*
            fileOutputStream nesnesini, file nesnesi ile temsil edilen dosyaya veri yazmak üzere başlatır.
Dosya açılır ve yazma işlemi için hazırlanır.*/
            OutputStreamWriter outputStream=new OutputStreamWriter(fileOutputStream);
            /*
            Bu nesne, fileOutputStream nesnesini kullanarak byte akışını karakter akışına dönüştürür.
Böylece karakter verilerini dosyaya yazabilirsiniz.*/
            outputStream.write("Merhaba Dünya");//write() metodu, karakterleri byte'lara dönüştürür ve dosyaya yazar.
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public static void oku() {
        File file = new File("test.txt");//File sınıfı, dosya işlemlerini gerçekleştirmek için kullanılır. Burada "test.txt" adında bir dosya nesnesi oluşturuluyor. Bu dosya, aynı dizinde mevcut olmalı.
        FileInputStream fileInputStream = null;//Dosyayı byte bazlı okumak için kullanılır.
        InputStreamReader inputStreamReader = null;//Byte verilerini karaktere çevirmek için kullanılır.
        BufferedReader bufferedReader = null;//Veriyi satır satır okuyabilmek için kullanılır.
        try {
            fileInputStream = new FileInputStream(file);//nesnesi dosyanın içeriğini okur.
            inputStreamReader = new InputStreamReader(fileInputStream);//dosyadaki byte verilerini karakterlere çevirir.
            bufferedReader = new BufferedReader(inputStreamReader);//bu karakterleri tamponlayarak satır satır okumayı sağlar.
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {//bufferedReader.readLine() dosyadaki satırları birer birer okur. null döndüğünde dosyanın sonuna gelinmiş olur.
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (bufferedReader != null) {//Her bir nesne null olup olmadığını kontrol edilerek kapatılır. Eğer kapanırken hata oluşursa, hata mesajı ekrana yazdırılır.
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }
    public static void main(String[] args){
        oku();
    }
}
