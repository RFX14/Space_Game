import java.awt.Color;
import java.awt.Graphics2D;

public class Bullet {
    int xPos, yPos;

    public Bullet(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillArc(xPos, yPos, 10, 10, 0, 180);
    }

    public void update() {
        yPos -= 5;
    }
}