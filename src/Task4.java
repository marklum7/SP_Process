import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Task4 {
    public static void main(String[] args){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Runtime.getRuntime().exec("tasklist.exe /fo csv /nh").getInputStream()))){
                String line;
                while ((line = reader.readLine()) != null){
                    String[] parts = line.split(",");
                    if (parts.length>1){
                        System.out.println(("Самый первый процесс:"+parts[0]));
                        break;
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

