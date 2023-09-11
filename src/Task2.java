import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Task2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<Integer> Pids = runningPids();
        Collections.sort(Pids);

        System.out.println("Список PID всех запущенных процессов:");
        for (int pid : Pids) {
            System.out.println(pid);
        }
    }

    public static List<Integer> runningPids() throws IOException, InterruptedException {
        List<Integer> Pids = new ArrayList<>();
        ProcessBuilder procBuilder = new ProcessBuilder("tasklist");
        procBuilder.redirectErrorStream(true);

        Process process = procBuilder.start();
        InputStream stdout = process.getInputStream();
        InputStreamReader isrStdout = new InputStreamReader(stdout);
        BufferedReader brStdout = new BufferedReader(isrStdout);

        String line;
        while ((line = brStdout.readLine()) != null) {
            String[] parts = line.split("\\s+");

            if (parts.length > 1) {
                try {
                    int pid = Integer.parseInt(parts[1]);
                    Pids.add(pid);
                } catch (NumberFormatException e) {
                }
            }
        }
        process.waitFor();
        return Pids;
    }
}
