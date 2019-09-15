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

    public ReadURL(String url, Buffer buffer) {
        this.url = url;
        this.buffer = buffer;
    }

    public void run() {
        try{
            Document document = Jsoup.connect(url).get();
            Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images) {
                buffer.addBuffer(image.attr("src"));
                new Download(image.attr("src"), buffer).start();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
