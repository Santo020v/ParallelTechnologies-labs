package Ball;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 650;
    public static final int HEIGHT = 350;
    int[] xPotsArray = new int[] {2, 2, WIDTH-44, WIDTH-44};
    int[] yPotsArray = new int[] {2, HEIGHT-96, 2, HEIGHT-96};

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");

        JLabel jLabelNumInPocketTitle = new JLabel("Кульок у лузі: ");
        JLabel jLabelNumInPocket = new JLabel("0");

        this.canvas = new BallCanvas(jLabelNumInPocket);
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        Pot p = new Pot(canvas, Color.BLACK, xPotsArray, yPotsArray);
        canvas.addPots(p);
        this.canvas.repaint();


        JButton buttonStart = new JButton("Black Ball");
        JButton buttonBlueBall = new JButton("Blue Ball");
        JButton buttonRedBall = new JButton("Red Ball");
        JButton buttonStop = new JButton("Stop");
        JButton buttonJoin = new JButton("Join");


        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int x, y;
                if(Math.random()<0.5){
                    x = new Random().nextInt(canvas.getWidth());
                    y = 0;
                }else{
                    x = 0;
                    y = new Random().nextInt(canvas.getHeight());
                }

                Ball b = new Ball(canvas, Color.darkGray, x, y);
                canvas.add(b);

                BallThread thread = new BallThread(b, xPotsArray, yPotsArray);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });
        buttonBlueBall.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 100; i++) {
                    Ball b = new Ball(canvas, Color.blue, 100, 0);
                    canvas.add(b);
                    BallThread thread = new BallThread(b, xPotsArray, yPotsArray);
                    thread.setPriority(1);
                    thread.start();
                    System.out.println("Thread blue name = " +
                            thread.getName());
                }
            }
        });

        buttonRedBall.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x, y;
                if(Math.random()<0.5){
                    x = 100;
                    y = 0;
                }else{
                    x = 100;
                    y = 0;
                }
                Ball b = new Ball(canvas, Color.red, x, y);
                canvas.add(b);
                BallThread thread = new BallThread(b, xPotsArray, yPotsArray);
                thread.setPriority(5);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        buttonJoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BounceFrame.this.joinVisualization();
            }
        });

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonBlueBall);
        buttonPanel.add(buttonRedBall);
        buttonPanel.add(buttonJoin);
        buttonPanel.add(buttonStop);
        buttonPanel.add(jLabelNumInPocketTitle);
        buttonPanel.add(jLabelNumInPocket);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void joinVisualization() {
        Ball ballPink = new Ball(this.canvas, Color.pink, 375, 175);
        Ball ballOrange = new Ball(this.canvas, Color.orange, 575, 175);
        this.canvas.add(ballPink);
        this.canvas.add(ballOrange);
        BallThread threadPink = new BallThread(ballPink, this.xPotsArray, this.yPotsArray, 500);
        BallThread threadOrange = new BallThread(ballOrange, this.xPotsArray, this.yPotsArray, 500);
        threadPink.start();

        try {
            threadPink.Join(threadOrange);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

        threadOrange.start();
    }
}