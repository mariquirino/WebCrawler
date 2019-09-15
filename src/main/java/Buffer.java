import java.util.ArrayList;

/**
 * Criado por Mariana
 * Data: 14/09/2019
 **/
public class Buffer {
    private ArrayList<String> buffer;
    private final Object lock = new Object();

    public Buffer() {
        this.buffer = new ArrayList<>();
    }

    public void addBuffer(String img){
        synchronized (lock) {
            buffer.add(img);
        }
    }

    public String removeBuffer(){
        synchronized (lock) {
            return buffer.remove(buffer.size() - 1);
        }
    }
}
