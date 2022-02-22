package Ex5;

public class FirstSymbolTread implements Runnable {
    private String symbol;

    public FirstSymbolTread (String s)
    {
        this.symbol = s;
    }

    public void run() {
        for(int i = 1; i < 50; ++i) {
            System.out.println(this.symbol);
        }
    }

}
