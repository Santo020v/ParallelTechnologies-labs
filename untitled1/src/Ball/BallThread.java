package Ball;

public class BallThread extends Thread {
    private Ball b;
    int[] x;
    int[] y;
    BallThread thread = null;
    private int movesCount = 10000;

    public BallThread(Ball ball, int[] xCor, int[] yCor){
        b = ball;
        x = xCor;
        y = yCor;
    }

    public BallThread(Ball ball, int[] xCor, int[] yCor, int moves){
        b = ball;
        x = xCor;
        y = yCor;
        movesCount = moves;
    }

    public void Join(BallThread ballThread) throws InterruptedException {
        this.thread = ballThread;
    }

    @Override
    public void run(){
        try{
            if (this.thread != null) {
                this.thread.join();
            }
            
            for(int i=1; i<movesCount; i++){
                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                for (int k=0; k<x.length; k++){
                    if (b.getX()==x[k] && b.getY()==y[k]){
                        b.setColor();
                        //System.out.println("Thread in POT = " + Thread.currentThread().getName());
                        return;
                    }
                }
                Thread.sleep(5);

            }

        } catch(InterruptedException ex){

            System.out.println("Thread STOPS = " + Thread.currentThread().getName());
            return;
        }
    }


}