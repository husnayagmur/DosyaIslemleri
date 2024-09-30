import java.io.*;

public class Serialization {

    public static void oku(){
        File file=new File("ogrenci.bin");
        if(file.exists()){
            FileInputStream fileInputStream=null;
            ObjectInputStream objectInputStream=null;//ObjectInputStream: Serileştirilmiş nesneleri okumak için kullanılır.
            // FileInputStream'i sarmalayarak dosyadaki serileştirilmiş nesneyi geri yükler.
            try {
                fileInputStream=new FileInputStream(file);
                objectInputStream=new ObjectInputStream(fileInputStream);//objectInputStream = new ObjectInputStream(fileInputStream):
                // Bu FileInputStream nesnesi bir ObjectInputStream ile sarmalanır, böylece dosyadaki serileştirilmiş nesne geri yüklenebilir.
                Serialization_Ogrenci ogrenci=(Serialization_Ogrenci) objectInputStream.readObject();
                //objectInputStream.readObject(): Bu satır, dosyadan okunan nesneyi geri yükler. Okunan veri Serialization_Ogrenci tipine cast edilir ve nesneye atanır.
                System.out.println(ogrenci);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally {
                try {
                    if(objectInputStream!=null){
                        objectInputStream.close();
                    }
                    if(fileInputStream!=null){
                        fileInputStream.close();
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public static void yaz(){
        Serialization_Ogrenci ogrenci=new Serialization_Ogrenci();
        ogrenci.setNumara(1);
        ogrenci.setAd("Hüsna");
        ogrenci.setSoyad("YAĞMUR");
        ogrenci.setSinif("12-B");
        System.out.println(ogrenci);
        File file=new File("ogrenci.bin");
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ogrenci);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(objectOutputStream!=null){
                    objectOutputStream.close();
                }
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*
        Tanım: Serileştirme, bir nesnenin bellekteki durumunu (değerlerini) kalıcı bir forma (dosya, veritabanı, vb.) veya ağ üzerinden gönderilebilir bir formata dönüştürme işlemidir.

Amaç:
Nesneleri kalıcı olarak saklamak.
Nesneleri ağ üzerinden transfer edebilmek.
Uygulamanın geçici durumunu kaydedip daha sonra geri yüklemek.
Geri Yükleme (Deserialization): Serileştirilmiş nesneleri, saklandıkları yerden alarak tekrar bellekte kullanılabilir hale getirme işlemidir.
Java'da Kullanımı:
Serileştirilecek sınıfın Serializable arayüzünü implement etmesi gerekir.
ObjectOutputStream ile serileştirme yapılır, ObjectInputStream ile geri yüklenir.
Serializable Arayüzü:
Java'daki Serializable arayüzü herhangi bir metot içermez; sadece nesnenin serileştirilebileceğini belirtir.*/

        //yaz();
        oku();
    }
}
