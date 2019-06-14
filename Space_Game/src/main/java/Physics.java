import java.awt.Rectangle;

public class Physics {
    public Physics() {

    }

    public static boolean Collision(Bullet bullet, Bunker bunker) {
        /*
        for (int i = 0; i < bunker.getBounds().size(); i++) {
            if (bullet.getBounds().intersects((Rectangle) bunker.getBounds().get(i))) {
                return true;
            }
        }
        */
        if (bullet.getBounds().intersects((Rectangle) bunker.getBounds())) {
            return true;
        }
        return false;
    }
}