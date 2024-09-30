import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class RemoteFile {
    public static void UzaktanDosyaAlma(){

        try {
            URL url = new URL("Alınacak dosya adresi.txt");
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            InputStream inputStream=connection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            char[] buffer=new char[10024];
            // 6. Okunan veriyi bir StringBuilder'a eklemek için bir StringBuilder oluşturuluyor
            StringBuilder builder=new StringBuilder();
            int length=0;
            // 7. Veri okuma işlemi başlatılıyor
            while ((length=inputStreamReader.read(buffer))!=-1){
                // 8. Tamponun okunan kısmı StringBuilder'a ekleniyor
                builder.append(Arrays.copyOfRange(buffer,0,length));
            }
            System.out.println(buffer.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void BilgisayarimaKaydet(){
        try {
            // 1. URL nesnesi oluşturuluyor (URL kısmı boş, gerçek URL eklenmelidir)
            URL url = new URL("");
            // 2. URL'ye HTTP bağlantısı açılıyor
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            // 3. Bağlantıdan veri akışı alınıyor
            InputStream inputStream=connection.getInputStream();
            // 4. InputStream'den veri okumak için InputStreamReader oluşturuluyor
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            // 5. Veri okuma için bir karakter tamponu oluşturuluyor
            char[] buffer=new char[10024];
            FileOutputStream fileOutputStream=new FileOutputStream("bilgisayarimiza kaydedilecek dosya ismi.txt");
            //StringBuilder builder=new StringBuilder();
            int length=0;
            while ((length=inputStreamReader.read(buffer))!=-1){
                //builder.append(Arrays.copyOfRange(buffer,0,length));
                fileOutputStream.write(new String(Arrays.copyOfRange(buffer,0,length)).getBytes());
            }
            //System.out.println(buffer.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void uzaktakiUrlKullanicidanAl() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("URL Giriniz: ");
        String line = scanner.nextLine();
        scanner.close();
        try {
            URL url = new URL(line);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(System.currentTimeMillis()));
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(Arrays.copyOfRange(buffer, 0, length));
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        uzaktakiUrlKullanicidanAl();
    }
}

