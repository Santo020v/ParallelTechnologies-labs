package FoxAlgo;


public class FoxAlgoMultiplication {

    private long parallelNExecutionTime;

    private final double[][] matrixA;
    private final double[][] matrixB;
    private final Result result;
    private final int blocksNum;

    public FoxAlgoMultiplication(double[][] matrixA, double[][] matrixB, Result result, int numOfThreads){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.blocksNum = (int) Math.sqrt((double) numOfThreads);
    }

    public void multiplyMatrixNParallel(){
        int rowsCount = matrixA.length;
        FoxAlgoThread[][] threads = new FoxAlgoThread[blocksNum][blocksNum];
        int blockSize = rowsCount / blocksNum;
        double[][][][] matrixOfMatricesA = new double[blocksNum][blocksNum][blockSize][blockSize];
        double[][][][] matrixOfMatricesB = new double[blocksNum][blocksNum][blockSize][blockSize];
        int iBound = 0;

        long startTime = System.nanoTime();

        for (int i=0; i<blocksNum; i++){
            int jBound = 0;
            for (int j=0; j<blocksNum; j++){
                matrixOfMatricesA[i][j] = copyBlock(matrixA, iBound, jBound, blockSize);
                matrixOfMatricesB[i][j] = copyBlock(matrixB, iBound, jBound, blockSize);
                threads[i][j] = new FoxAlgoThread(result.matrix, iBound, jBound, blocksNum);
                jBound += blockSize;
            }
            iBound += blockSize;
        }

        for (int i=0; i<blocksNum; i++) {
            for (int j = 0; j < blocksNum; j++) {
                threads[i][j].setMatrixOfMatricesA(matrixOfMatricesA);
                threads[i][j].setMatrixOfMatricesB(matrixOfMatricesB);
            }
        }

        for (int i=0; i<blocksNum; i++){
            for (int j=0; j<blocksNum; j++){
                threads[i][j].start();
            }
        }
        for (int i=0; i<blocksNum; i++) {
            for (int j = 0; j < blocksNum; j++) {
                try {
                    threads[i][j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        this.parallelNExecutionTime = (System.nanoTime() - startTime) / 1000000;

    }

    private double[][] copyBlock(double[][] matrix, int i, int j, int size) {
        double[][] block = new double[size][size];
        for (int k = 0; k < size; k++) {
            System.arraycopy(matrix[k + i], 0 + j, block[k], 0, size);
        }
        return block;
    }

    public long getParallelNExecutionTime() {
        return parallelNExecutionTime;
    }
}
