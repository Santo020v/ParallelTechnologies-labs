package Ex5;

public class Symbol {
    private String symbol = "-";

    public Symbol() {
    }

    public synchronized void FirstSymbol(){
        while (this.symbol.equals("|")) {
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        this.symbol = "|";
        System.out.println(this.symbol);
        this.notify();
    }

    public synchronized void SecondSymbol(){
        while (this.symbol.equals("-")) {
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        this.symbol = "-";
        System.out.println(this.symbol);
        this.notify();
    }
}
