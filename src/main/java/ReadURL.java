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
    private Run runReadURL;
    private Run runDownload;

    public ReadURL(String url, Buffer buffer, Run runReadURL, Run runDownload) {
        this.url = url;
        this.buffer = buffer;
        this.runReadURL = runReadURL;
        this.runDownload = runDownload;
    }

    public void run() {
        try{
            System.out.println("Lendo HTML");
            Document document = Jsoup.connect(url).get();
            Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images) {
                buffer.addBuffer(image.attr("src"));
                runDownload.addQtd();
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            runReadURL.removeQtd();
        }

    }
}
