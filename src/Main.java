import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
public class Main {

    public static void main(String[] args)
            throws IOException, InterruptedException {
        Timer timer = new Timer();
        for (int i = 0; i < 10; i++) {
            timer.schedule(new OpenNotePad(), i * 10);
        }
    }

    static class OpenNotePad extends TimerTask {
        @Override
        public void run() {
            try {
                ProcessBuilder pb = new ProcessBuilder("notepad.exe");
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

