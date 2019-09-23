import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Criado por Mariana
 * Data: 14/09/2019
 **/
public class Buffer {
//    private AtomicReferenceArray<String> imageURL;
    private ArrayList<String> imageURL;

    public Buffer() {
        this.imageURL = new ArrayList<>();
//        this.imageURL = new AtomicReferenceArray(10000);
    }

    public void addBuffer(String img){
        synchronized (this) {
            imageURL.add(img);
        }
//            imageURL.getAndSet(img);
    }

    public String removeBuffer(){
        synchronized (this) {
            if (!imageURL.isEmpty()) {
                return imageURL.remove(imageURL.size() - 1);
            }
        }
        return null;
    }

    public boolean isEmpty() {
        synchronized (this) {
            return imageURL.isEmpty();
        }
    }
}
