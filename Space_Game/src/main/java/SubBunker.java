import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;

public class SubBunker {
    int width, height;
    int x, y, idx;
    int xPoints[], yPoints[], xPoints2[], yPoints2[], xPoints3[], yPoints3[], xPoints4[], yPoints4[];
    Shape shape;

    public SubBunker(int x, int y) {
        this.x = x;
        this.y = y;

        //Generalizes the position of the bunker
        xPoints = new int[] {x, x + 30, x + 30};
        yPoints = new int[] {y + 30, y + 30, y};

        xPoints2 = new int[] {x + 90, x + 90, x + 120};
        yPoints2 = new int[] {y, y + 30, y + 30};

        xPoints3 = new int[] {x + 30, x + 60, x + 30};
        yPoints3 = new int[] {y + 30, y + 30, y + 60};

        xPoints4 = new int[] {x + 60, x + 90, x + 90};
        yPoints4 = new int[] {y + 30, y + 30, y + 60};

        width = 30;
        height = 30;

    }

    public void draw(Graphics2D g2d, int idx) {
        g2d.setColor(Color.GREEN);

        if(idx == 0) {
            shape = new Polygon(xPoints, yPoints, 3);
        } else if(idx == 3) {
            shape = new Polygon(xPoints2, yPoints2, 3);
        } else if(idx == 5) {
            shape = new Polygon(xPoints3, yPoints3, 3);
        } else if(idx == 6) {
            shape = new Polygon(xPoints4, yPoints4, 3);
        } else {
            int factorY = 0;
            if(idx > 3 && idx < 8) {
                idx = (idx == 7) ? 3 : 0;
                factorY = 30;
            } else if(idx >= 8) {
                idx = (idx == 9) ? 3 : 0;
                factorY = 60;
            }
            int factorX = 30*idx;
        
            shape = new Rectangle(x + factorX, y + factorY, width, height);
        }

        g2d.fill(shape);
    }
}