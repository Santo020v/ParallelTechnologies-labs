package StripedAlgo;

public class StripedAlgoMain {

    public static void main(String[] args){
       goBlockStripedAlgo();
//       goExperimentOfNSize();
//        goExperimentOfNThreads();
    }

    public static void goBlockStripedAlgo() {
        double[][] matrixA = MatrixGenerator.randomMatrixGenerator(10);
        double[][] matrixB = MatrixGenerator.randomMatrixGenerator(10);
        StripedAlgoMultiplication bsm = new StripedAlgoMultiplication(matrixA, matrixB, 10);

        Result result = bsm.multiplyMatrixParallel();
        result.printMatrix();
    }

    public static void goExperimentOfNSize(){
        long[] times = new long[5];
        int[] steps = new int[]{400,800,1200,1600,2000};

        for (int i=0; i<5; i++){
            long time = 0;
            double[][] matrixA = MatrixGenerator.randomMatrixGenerator(steps[i]);
            double[][] matrixB = MatrixGenerator.randomMatrixGenerator(steps[i]);

            StripedAlgoMultiplication bsm = new StripedAlgoMultiplication(matrixA, matrixB, 400);
            Result r1 = bsm.multiplyMatrixParallel();
            time += bsm.getParallelExecutionTime();
            times[i] = time;
        }
        System.out.format("%32s%32s%32s", "Threads", "Size", "Time");
        for (int i=0; i<5; i++){
            System.out.println();
            System.out.format("%32s%32f%32f", "400", (double) steps[i], (double) times[i]);
        }
        System.out.println();
    }

    public static void goExperimentOfNThreads(){
        long[] timesParallel = new long[5];
        int[] threads = new int[]{200,400,600,800,1000};

        for (int i=0; i<5; i++){
            long timeSumParallel = 0;
            double[][] matrixA = MatrixGenerator.randomMatrixGenerator(1000);
            double[][] matrixB = MatrixGenerator.randomMatrixGenerator(1000);

            StripedAlgoMultiplication bsm = new StripedAlgoMultiplication(matrixA, matrixB, threads[i]);
            Result r1 = bsm.multiplyMatrixParallelNThreads();
            timeSumParallel += bsm.getParallelNExecutionTime();
            timesParallel[i] = timeSumParallel;
        }
        System.out.format("%32s%32s", "Threads", "Time");
        for (int i=0; i<5; i++){
            System.out.println();
            System.out.format("%32f%32f", (double) threads[i], (double) timesParallel[i]);
        }
        System.out.println();
    }
}
