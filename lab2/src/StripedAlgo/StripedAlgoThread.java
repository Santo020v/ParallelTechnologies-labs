package StripedAlgo;

public class StripedAlgoThread implements Runnable{
    private final double[] rowMatrixA;
    private final double[][] matrixB;
    private final double[][] resultMatrix;
    private final int index;

    public StripedAlgoThread(double[] rowMatrixA, double[][] matrixB, double[][] resultMatrix, int index){
        this.rowMatrixA = rowMatrixA;
        this.matrixB = matrixB;
        this.resultMatrix = resultMatrix;
        this.index = index;
    }

    @Override
    public void run() {
        for (int column = 0; column<matrixB[0].length; column++){
            double rowElement = 0;
            for (int i = 0; i<matrixB.length; i++){
                rowElement += rowMatrixA[i] * matrixB[i][column];
            }
            resultMatrix[index][column] = rowElement;
        }
    }

}
