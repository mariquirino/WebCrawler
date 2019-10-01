import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(ReadFile.class.getName());

    public ReadFile(Buffer buffer, Semaphore semaphoreDownload, Semaphore semaphoreReadURL)  throws IOException {
        BufferedReader reader = null;
        try {
            File file = new File("urls.txt");
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null) {
                LOGGER.info("Lendo Arquivo");
                semaphoreReadURL.addQtd();
                new ReadURL(text, buffer, semaphoreReadURL, semaphoreDownload).start();
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
