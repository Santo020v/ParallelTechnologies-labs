package Ex5;

public class SecondSymbolTread implements Runnable {
    private String symbol;

    public SecondSymbolTread (String s)
    {
        this.symbol = s;
    }

    public void run() {
        for(int i = 1; i < 50; ++i) {
            System.out.println(this.symbol);
        }
    }
}
