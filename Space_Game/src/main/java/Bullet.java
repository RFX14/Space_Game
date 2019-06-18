import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullet {
    int xPos, yPos;
     boolean hit = false;

     /**
      * Creates a new bullet based on a given position, normally with a Player
      * @param xPos is the x-coordinate of the bullet
      * @param yPos is the y-coordinate of the bullet
      */
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
        BunkerMech bunker = new BunkerMech();
        
        /**
         * This collision detection sets 'hit = true' if it intersects a Bunker at a SubPiece
         * The 'hit' variable is used by the ShootingMech class to determine if
         * a bullet is to be deleted from the screen.
         */

         for(int i = 0; i < bunker.bunkers.size(); i++) {
            Bunker sub = bunker.bunkers.get(i);
            if(Physics.Collision(this, sub)) {
                hit = true;
                //System.out.println("I'm deaaad!!");
            } else {
                hit = false;
            }
         }
        
    
    }

    public int getY() {
        return yPos;
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, 10, 10);
    }

    public boolean hit() {
        return hit;
    }
}