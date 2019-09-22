public class Semaphore {
    private int qtd;

    public Semaphore() {
        this.qtd = 0;
    }

    public int getQtd() {
        synchronized (this) {
            return qtd;
        }
    }

    public void removeQtd() {
        synchronized (this) {
            this.qtd--;
        }
    }

    public void addQtd() {
        synchronized (this) {
            this.qtd++;
        }
    }
}
