package Ball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BallCanvas extends JPanel{
    private ArrayList<Ball> balls = new ArrayList<>();
    private Pot pots;
    private JLabel jLabelInPots;

    public void add(Ball b){
        this.balls.add(b);
    }
    public void addPots(Pot p){
        this.pots = p;
    }
    public BallCanvas (JLabel label){
        this.jLabelInPots = label;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        pots.draw(g2);
        for(int i=0; i<balls.size();i++){
            Ball b = balls.get(i);
            b.draw(g2);
        }
        int ballsInPocket = balls.stream().filter(x -> x.getColor() == Color.BLACK).toArray().length;
        jLabelInPots.setText(Integer.toString(ballsInPocket));

    }
}