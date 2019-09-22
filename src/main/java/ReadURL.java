import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Criado por Mariana
 * Data: 14/09/2019
 **/
public class ReadURL extends Thread {
    private String url;
    private Buffer buffer;
    private Semaphore semaphoreReadURL;
    private Semaphore semaphoreDownload;

    public ReadURL(String url, Buffer buffer, Semaphore semaphoreReadURL, Semaphore semaphoreDownload) {
        this.url = url;
        this.buffer = buffer;
        this.semaphoreReadURL = semaphoreReadURL;
        this.semaphoreDownload = semaphoreDownload;
    }

    public void run() {
        try{
            System.out.println("Lendo HTML");
            Document document = Jsoup.connect(url).get();
            Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images) {
                buffer.addBuffer(image.attr("src"));
                semaphoreDownload.addQtd();
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            semaphoreReadURL.removeQtd();
        }

    }
}
