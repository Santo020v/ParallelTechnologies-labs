package FoxAlgo;

public class FoxAlgoMain {

    public static void main(String[] args){
//        goFoxAlgo();
//        goExperimentOfNSize();
        goExperimentOfNThreads();
    }

    public static void goFoxAlgo() {
        double[][] matrixA = MatrixGenerator.randomMatrixGenerator(10);
        double[][] matrixB = MatrixGenerator.randomMatrixGenerator(10);
        Result r1 = new Result(10);
        FoxAlgoMultiplication fm1 = new FoxAlgoMultiplication(matrixA, matrixB, r1, 10);
        fm1.multiplyMatrixNParallel();
        r1.printMatrix();
    }

    public static void goExperimentOfNSize(){
        long[] times = new long[5];
        int[] steps = new int[]{400,800,1200,1600,2000};

        for (int i=0; i<5; i++){
            long timeSum = 0;
            double[][] matrixA = MatrixGenerator.randomMatrixGenerator(steps[i]);
            double[][] matrixB = MatrixGenerator.randomMatrixGenerator(steps[i]);
            Result r = new Result(steps[i]);
            FoxAlgoMultiplication fm = new FoxAlgoMultiplication(matrixA, matrixB, r, 400);
            fm.multiplyMatrixNParallel();
            timeSum += fm.getParallelNExecutionTime();
            times[i] = timeSum;
        }
        System.out.format("%32s%32s", "Size", "Time");
        for (int i=0; i<5; i++){
            System.out.println();
            System.out.format("%32f%32f", (double) steps[i], (double) times[i]);
        }
        System.out.println();
    }

    public static void goExperimentOfNThreads(){
        long[] times = new long[5];
        int[] threads = new int[]{200,400,600,800,1000};

        for (int i=0; i<5; i++){
            long timeSum = 0;
            double[][] matrixA = MatrixGenerator.randomMatrixGenerator(1000);
            double[][] matrixB = MatrixGenerator.randomMatrixGenerator(1000);
            Result r = new Result(1000);
            FoxAlgoMultiplication fm = new FoxAlgoMultiplication(matrixA, matrixB, r, threads[i]);
            fm.multiplyMatrixNParallel();
            timeSum += fm.getParallelNExecutionTime();

            times[i] = timeSum;
        }
        System.out.format("%32s%32s", "Threads", "Time");
        for (int i=0; i<5; i++){
            System.out.println();
            System.out.format("%32f%32f", (double) threads[i], (double) times[i]);
        }
        System.out.println();
    }
}
