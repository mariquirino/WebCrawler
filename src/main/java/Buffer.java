import java.util.ArrayList;

/**
 * Criado por Mariana
 * Data: 14/09/2019
 **/
public class Buffer {
    private ArrayList<String> buffer;

    public Buffer() {
        this.buffer = new ArrayList<>();
    }

    public void addBuffer(String img){
        synchronized (this) {
            buffer.add(img);
        }
    }

    public String removeBuffer(){
        synchronized (this) {
            return buffer.remove(buffer.size() - 1);
        }
    }
}
