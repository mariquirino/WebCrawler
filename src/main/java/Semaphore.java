import java.util.concurrent.atomic.AtomicInteger;

public class Semaphore {
    private AtomicInteger qtd;

    public Semaphore() {
        this.qtd = new AtomicInteger(0);
    }

    public int getQtd() {
//        synchronized (this) {
            return qtd.get();
//        }
    }

    public void removeQtd() {
//        synchronized (this) {
            this.qtd.decrementAndGet();
//        }
    }

    public void addQtd() {
//        synchronized (this) {
            this.qtd.incrementAndGet();
//        }
    }
}
