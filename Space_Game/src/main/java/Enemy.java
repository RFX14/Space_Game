import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy {
    int x, y;
    int xVel;
    int width, height;

    public Enemy (int x, int y) {
        this.x = x;
        this.y = y;

        xVel = 1;
        width = 30;
        height = 30;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(x, y, width, height);
    }

    public void update() {
        if(x > 620) {
            y += 40;
            xVel = -1;
        } else if(x == 0 && y != 0) {
            y += 40;
            xVel = 1;
        }

        x += xVel;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}