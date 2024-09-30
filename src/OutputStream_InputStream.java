import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class OutputStream_InputStream {
    public static void yaz(){
        File file = new File("Output.dat");
        FileOutputStream fileOutputStream = null;
        Scanner scanner = new Scanner(System.in);
        try {
            fileOutputStream = new FileOutputStream(file);
            String line = null;
            while ((line = scanner.nextLine()).equals("guit")) ;
            {
                fileOutputStream.write(line.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            scanner.close();
        }
    }

    public static void oku() {
        //ASCII göre okur.
        File file = new File("Output.dat");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream=new FileInputStream(file);
            int c = 0;
            while ((c = fileInputStream.read()) != -1) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    InputStream, temel olarak bayt düzeyinde veri okur. Her bayt, bir ASCII karakteri olabilir.
    Bu yüzden okunan her bayt, bir karakterin ASCII karşılığıdır.
    Java'da int veri türü kullanarak baytı okuruz,
    sonra bunu bir char'a dönüştürerek ASCII karakterini elde edebiliriz.
    biz yukaridaki örnekte yapmadik ascıı degeri olarak kaldı.*/
    public static void main(String[] args) {
        oku();
    }
}

