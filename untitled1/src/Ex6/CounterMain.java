package Ex6;

public class CounterMain {
    public CounterMain() {
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);
        String[] methods = new String[]{"asynchronous", "synchronized block", "synchronized method", "locker"};
        String[] var3 = methods;
        int var4 = methods.length;

        int var5;
        String method;
        Thread increment1;
        Thread decrement1;
        for(var5 = 0; var5 < var4; ++var5) {
            method = var3[var5];
            System.out.println(method + ":");
            increment1 = new Thread(new IncrementTread(counter, method));
            decrement1 = new Thread(new DecrementTread(counter, method));
            increment1.start();
            decrement1.start();
            increment1.join();
            decrement1.join();
            System.out.println(counter.getCounter());
            counter.setCounter(0);
        }
        System.out.println(" ");
        System.out.println("Декілька потоків:");
        var3 = methods;
        var4 = methods.length;

        for(var5 = 0; var5 < var4; ++var5) {
            method = var3[var5];
            System.out.println(method + ":");
            increment1 = new Thread(new IncrementTread(counter, method));
            decrement1 = new Thread(new DecrementTread(counter, method));
            Thread increment2 = new Thread(new IncrementTread(counter, method));
            Thread decrement2 = new Thread(new DecrementTread(counter, method));
            increment1.start();
            decrement1.start();
            increment2.start();
            decrement2.start();
            increment1.join();
            decrement1.join();
            increment2.join();
            decrement2.join();
            System.out.println(counter.getCounter());
            counter.setCounter(0);
        }
    }
}
