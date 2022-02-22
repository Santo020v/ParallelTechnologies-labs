package Ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class Pot {
    private Component canvas;
    private Color potColor;
    private static final int XSIZE = 28;
    private static final int YSIZE = 22;
    int[] x;
    int[] y;

    public Pot(Component c, Color color, int[] xCor, int[] yCor) {
        this.canvas = c;
        this.potColor = color;
        this.x = xCor;
        this.y = yCor;
    }

    public void draw(Graphics2D g) {
        for(int i = 0; i < this.x.length; ++i) {
            g.setColor(this.potColor);
            g.fill(new Rectangle2D.Double(x[i],y[i],XSIZE,YSIZE));
        }

    }
}
