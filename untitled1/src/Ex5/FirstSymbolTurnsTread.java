package Ex5;

public class FirstSymbolTurnsTread implements Runnable{
    Symbol symbol;

    public FirstSymbolTurnsTread(Symbol symbol) {
        this.symbol = symbol;
    }


    @Override
    public void run() {
        for (int i=0; i<100; ++i){
            symbol.FirstSymbol();
            if (i!=0 && i%50==0)
            {
                System.out.println();
            }
        }
    }
}
