import java.awt.Rectangle;
import java.util.LinkedList;

public class Physics {
    public Physics() {
        Thread t3 = new Thread(new BunkerMech());
        t3.start();
    }
    
    /**This method is called on by Bullet() and is used to determine
     * whether or not a bullet has collided with a SubBunker
     */
    public static boolean Collision(Bullet bullet, Bunker bunker) {
        for (int i = 0; i < bunker.getBounds().size(); i++) {
            LinkedList sub = bunker.getBounds();
            if (bullet.getBounds().intersects((Rectangle)sub.get(i))) {
                return true;
            }
        }
        return false;
        
        /*
        if (bullet.getBounds().intersects((Rectangle) bunker.getBounds())) {
            return true;
        }
        return false;
        */
        
    }
    
}