import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Player {
    int xPos, yPos, xVel;
    boolean shoot = false;

    public Player() {
        xPos = 310;
        yPos = 430;
        xVel = 0;
    }

    public void update() {
        xPos += xVel;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.CYAN);
        g2d.fillRect(xPos, yPos, 20, 20);
    }

	public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D) {
            xVel = 2;
        } else if(key == KeyEvent.VK_A) {
            xVel = -2;
        } 

        if(key == KeyEvent.VK_SHIFT) {
            shoot = true;
            ShootingMech.addAmmo(new Bullet(xPos, yPos));
        }
	}

	public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D) {
            xVel = 0;
        } else if(key == KeyEvent.VK_A) {
            xVel = 0;
        } 

        if(key == KeyEvent.VK_SHIFT) {
            shoot = false;
        }
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public boolean getShoot() {
        return shoot;
    }
    
}