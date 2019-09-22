import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ThreadMain implements Runnable {

    public ThreadMain(Buffer buffer, Run runDownload, Run runReadURL)  throws IOException {
        BufferedReader reader = null;
        try {
            File file = new File("urls.txt");
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                System.out.println("Lendo Arquivo");
                runReadURL.addQtd();
                new ReadURL(text, buffer, runReadURL, runDownload).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    @Override
    public void run() {

    }
}
