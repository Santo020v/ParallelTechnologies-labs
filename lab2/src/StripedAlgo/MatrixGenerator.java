package StripedAlgo;

import java.util.Random;

public class MatrixGenerator {

    public static double[][] randomMatrixGenerator(int matrixSize){
        Random random = new Random();
        double[][] result = new double[matrixSize][matrixSize];

        for (int i=0; i<matrixSize; i++){
            for (int j=0; j<matrixSize; j++){
                int randomIntPart = random.nextInt(10);
                double randomDoublePart = random.nextDouble();
                result[i][j] = (double) randomIntPart + randomDoublePart;
            }
        }
        return result;
    }
}
