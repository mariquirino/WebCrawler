public class Run {
    private int qtd;

    public Run() {
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
