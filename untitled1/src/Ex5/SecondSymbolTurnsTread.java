package Ex5;

public class SecondSymbolTurnsTread implements Runnable {
    Symbol symbol;

    public SecondSymbolTurnsTread(Symbol symbol) {
        this.symbol = symbol;
    }


    @Override
    public void run() {
        for (int i=0; i<100; ++i){
            symbol.SecondSymbol();
            if (i!=0 && i%50==0)
            {
                System.out.println();
            }
        }
    }

}
