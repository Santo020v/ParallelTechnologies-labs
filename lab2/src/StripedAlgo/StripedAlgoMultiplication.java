package StripedAlgo;


public class StripedAlgoMultiplication {

    private long parallelExecutionTime;
    private long parallelNExecutionTime;

    private final double[][] matrixA;
    private final double[][] matrixB;

    private int numOfThreads;

    public StripedAlgoMultiplication(double[][] matrixA, double[][] matrixB){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    public StripedAlgoMultiplication(double[][] matrixA, double[][] matrixB, int numOfThreads){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.numOfThreads = numOfThreads;
    }

    public Result multiplyMatrixParallel(){
        int rows = matrixA.length;
        int columns = matrixB[0].length;
        double[][] resultMatrix = new double[rows][columns];
        Thread[] threads = new Thread[rows];

        long startTime = System.nanoTime();
        for (int i=0; i<rows; i++){
            threads[i] = new Thread(new StripedAlgoThread(matrixA[i], matrixB, resultMatrix, i));
            threads[i].start();
        }
        try {
            for (Thread thread : threads)
                thread.join();
        } catch (InterruptedException e) {}
        this.parallelExecutionTime = (System.nanoTime() - startTime) / 1000000;
        return new Result(resultMatrix);
    }

    public Result multiplyMatrixParallelNThreads(){
        int rows = matrixA.length;
        int columns = matrixB[0].length;
        double[][] resultMatrix = new double[rows][columns];
        Thread[] threads = new Thread[numOfThreads];
        int rowsForOneThread = rows / numOfThreads;
        int firstRowForThread = 0;

        long startTime = System.nanoTime();
        for (int i=0; i<numOfThreads; i++){
            int lastRowForThread = firstRowForThread + rowsForOneThread;
            if (lastRowForThread>rows){
                lastRowForThread = rows;
            }
            threads[i] = new Thread(new StripedAlgoThreadN(matrixA, matrixB, resultMatrix, firstRowForThread, lastRowForThread));
            threads[i].start();
            firstRowForThread = lastRowForThread;
        }
        try {
            for (Thread thread : threads)
                thread.join();
        } catch (InterruptedException e) {}
        this.parallelNExecutionTime = (System.nanoTime() - startTime) / 1000000;
        return new Result(resultMatrix);
    }

    public long getParallelExecutionTime(){
        return parallelExecutionTime;
    }

    public long getParallelNExecutionTime() {
        return parallelNExecutionTime;
    }
}
