import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferedW {
    public static void main(String[] args) {
        File file=new File("input.txt");
        BufferedWriter bufferedWriter=null;
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(file);
            bufferedWriter=new BufferedWriter(fileWriter);
            Scanner scanner=new Scanner(System.in);
            String line=null;
            while (!(line=scanner.nextLine()).equals("quit")){
                bufferedWriter.write(line);
                bufferedWriter.flush();
                /*
                flush() metodu, tamponda bekleyen verilerin hemen yazılmasını sağlar.
                Örneğin, tamponda bekleyen veriler henüz yazılmadıysa,
                flush() çağrıldığında bu veriler diske veya hedefe yazılır.*/
            }
            scanner.close();
            //direk selam yazdiğimizda input.txt dosyasina gondermez buffer'da bekler.
            // 2 yolu vardir ya quit yazarsin ve dosyaya gonderirsin yada buffered dolar o zaman yazar.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
