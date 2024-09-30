import java.io.*;

public class FileStreamsLab {
    public static void main(String[] args) {
        //Okunan dosyanin icerigini yazdirma.
        File inputFile=new File("C:\\Users\\PC\\Desktop\\JAVA\\Java301DosyaIslemleri\\FileStream.txt");
        File outpuFile=new File("C:\\Users\\PC\\Desktop\\JAVA\\Java301DosyaIslemleri\\FileStreamOutput.txt");
        if(inputFile.exists()){
            FileInputStream fileInputStream=null;
            FileOutputStream fileOutputStream=null;
            try {
                fileInputStream=new FileInputStream(inputFile);
                fileOutputStream=new FileOutputStream(outpuFile);
                int c=0;
                while ((c=fileInputStream.read())!=-1){
                    char ch=(char) c;
                  /*
                  c, bir ASCII sayısal değerdir. Bu değeri bir karakter (char) veri tipine dönüştürmek için char türüne cast (dönüştürme) işlemi yapılır.
Örneğin, c 97 ise, (char) c işlemi "a" karakterini döndürür. Yani, ASCII değeri 97 olan karakter olan "a" harfi ch değişkenine atanır.*/
                    fileOutputStream.write(Character.toUpperCase(ch));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally {
                if(fileInputStream!=null){
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }if(fileOutputStream!=null){
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }else {
            System.out.println("Dosya Bulunamadi!");
        }
    }
}

