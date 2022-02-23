package Ex5;

public class SymbolsMain {

    public static void main(String[] args) throws InterruptedException {

        //();
        secondTest();

    }

    static void firstTest(){
        Thread t1 = new Thread(new FirstSymbolTread("-"));
        Thread t2 = new Thread(new SecondSymbolTread("|"));
        t2.start();
        t1.start();
    }

    static void secondTest(){
        Symbol symbol = new Symbol();
        Thread t1 = new Thread(new FirstSymbolTurnsTread(symbol));
        Thread t2 = new Thread(new SecondSymbolTurnsTread(symbol));
        t1.start();
        t2.start();
    }

}
