import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Task3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<ProccesData> Pids = runningPids();
        //Collections.sort(Pids);
        System.out.println(Pids.size());
        System.out.println("Список всех запущенных процессов:");
        for (ProccesData pid : Pids) {
            System.out.println(pid.getName());
            System.out.println(pid.getPriority());
        }
    }

    public static List<ProccesData> runningPids() throws IOException, InterruptedException {
        List<ProccesData> Pids = new ArrayList<>();
        ProcessBuilder procBuilder = new ProcessBuilder("tasklist");
        procBuilder.redirectErrorStream(true);

        Process process = procBuilder.start();
        InputStream stdout = process.getInputStream();
        InputStreamReader isrStdout = new InputStreamReader(stdout);
        BufferedReader brStdout = new BufferedReader(isrStdout);

        String line;
        while ((line = brStdout.readLine()) != null) {

            String[] parts = line.split("\\s+");
            System.out.println(line);
            if (parts.length > 1) {
                try {

                    ProccesData st = new ProccesData(parts[0], parts[2], parts[2], parts[4]);

                    Pids.add(st);

                } catch (NumberFormatException e) {
                }
            }
        }
        process.waitFor();
        return Pids;
    }
}
