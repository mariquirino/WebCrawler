import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Criado por Mariana
 * Data: 14/09/2019
 **/
public class Download extends Thread{
    private Buffer buffer;

    private final String path = "/home/macaxeira/IdeaProjects/webCrawler/img/";
//    private final String path = "C:\\Users\\Mariana\\IdeaProjects\\webCrawler\\img\\";

    public Download(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try{
            URL url = new URL(buffer.removeBuffer());
            InputStream is = url.openStream();
            String[] filename = url.toString().split("/");

            OutputStream os = new FileOutputStream(path + filename[filename.length - 1]);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();

            System.out.println("Complete image " + filename[filename.length - 1]);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
