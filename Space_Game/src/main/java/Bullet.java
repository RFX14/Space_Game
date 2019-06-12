import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullet {
    int xPos, yPos;
     boolean hit = false;
    public Bullet(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillArc(xPos, yPos, 10, 10, 0, 180);
    }

    public void update() {
        yPos -= 2;
        if(Physics.Collision(this, new Bunker())) {
            hit = true;
            //System.out.println("I'm deaaad!!");
        } else {
            hit = false;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, 10, 10);
    }

    public boolean hit() {
        return hit;
    }
}