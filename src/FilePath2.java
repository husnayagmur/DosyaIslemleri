import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FilePath2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Dosya Yolu: ");
        String filePath=scanner.nextLine();
        File file=new File(filePath);
        if(!file.exists()){
            try {
                boolean fileCreater=file.createNewFile();
                if(fileCreater){
                    System.out.println("Dosya Olusturuldu.");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            FileWriter fileWriter=new FileWriter(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(file);
            String line=null;
            do {
                line=scanner.nextLine();
                fileWriter.write(line);
                fileWriter.write(System.lineSeparator());
            }while (!line.equals("quit"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        scanner.close();
        System.out.println("Dosya Yazdırma Basarili");
    }
}

