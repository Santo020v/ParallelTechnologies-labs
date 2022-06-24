package FoxAlgo;

public class FoxAlgoThread extends Thread{
    private final double[][] resultMatrix;
    private double[][][][] matrixOfMatricesA;
    private double[][][][] matrixOfMatricesB;
    private final FoxAlgoThreadN foxAlgoThreadN;
    private final int blocksNum;


    public FoxAlgoThread(double[][] result, int iBound, int jBound, int blocksNum){
        this.resultMatrix = result;
        this.foxAlgoThreadN = new FoxAlgoThreadN(this.resultMatrix, iBound, jBound);
        this.blocksNum = blocksNum;
    }

    @Override
    public void run() {
        synchronized (resultMatrix){
            for (int l=0; l<blocksNum; l++){
                for (int i=0; i<blocksNum; i++){
                    for (int j=0; j<blocksNum; j++){
                        foxAlgoThreadN.setBlockOfMatrixA(matrixOfMatricesA[i][(i+l) % blocksNum]);
                        foxAlgoThreadN.setBlockOfMatrixB(matrixOfMatricesB[(i+l) % blocksNum][j]);
                    }
                }
                foxAlgoThreadN.run();
            }
        }
    }

    public void setMatrixOfMatricesA(double[][][][] matrixOfMatricesA){
        this.matrixOfMatricesA = matrixOfMatricesA;
    }
    public void setMatrixOfMatricesB(double[][][][] matrixOfMatricesB){
        this.matrixOfMatricesB = matrixOfMatricesB;
    }
}
