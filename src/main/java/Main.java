import javax.management.remote.JMXConnector;
import java.io.*;

/**
 * Criado por Mariana
 * Data: 14/09/2019
 **/
public class Main {


    public static void main(String[] args) throws Exception{
        Buffer buffer = new Buffer();
        Run runDownload = new Run();
        Run runReadURL = new Run();

        new Thread(new ThreadMain(buffer, runDownload, runReadURL)).start();

        while (runReadURL.getQtd() > 0 || runDownload.getQtd() > 0 ) {
            if (runDownload.getQtd() > 0 && !buffer.isEmpty()) {
                new Download(buffer, runDownload).start();
                runDownload.removeQtd();
            }
        }
    }
}
