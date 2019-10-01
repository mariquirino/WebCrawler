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
    private static final Logger LOGGER = Logger.getLogger(Download.class.getName());

//    private final String path = "/home/macaxeira/IdeaProjects/webCrawler/img/";
    private final String path = "C:\\Users\\Mariana\\IdeaProjects\\webCrawler\\img\\";

    public Download(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        
            URL url = new URL(buffer.removeBuffer());
            
            String[] filename = url.toString().split("/");

        try(InputStream is = url.openStream(); 
            OutputStream os = new FileOutputStream(path + filename[filename.length - 1])
            ){

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }


            LOGGER.info("Complete image " + filename[filename.length - 1]);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
