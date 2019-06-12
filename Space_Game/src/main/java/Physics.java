public class Physics {
    public Physics() {

    }

    public static boolean Collision(Bullet bullet, Bunker bunker) {
        if(bullet.getBounds().intersects(bunker.getBounds())) {
            return true;
        }
        return false;
    }
}