package StripedAlgo;

public class Result {
    private final double[][] matrix;

    public Result(double[][] matrix) {
        this.matrix = matrix;
    }

    public Result(int matrixSize) {
        this.matrix = new double[matrixSize][matrixSize];
    }

    public void printMatrix(){
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
