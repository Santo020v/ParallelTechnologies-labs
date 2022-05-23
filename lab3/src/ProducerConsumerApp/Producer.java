package ProducerConsumerApp;

public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {

        int importantInfo[] = importantInfoArray(5000);

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            drop.put(importantInfo[i]);
        }
        drop.put(1111111);
    }

    public int[] importantInfoArray(int n){
        int[] importantInfo = new int[n];
        for (int i=0; i<n; i++){
            importantInfo[i] = i+1;
        }
        return importantInfo;
    }
}