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
            if (buffer.size() > 0) {
                return buffer.remove(buffer.size() - 1);
            }
        }
        return null;
    }

    public boolean isEmpty() {
        synchronized (this) {
            return buffer.size() == 0;
        }
    }
}
