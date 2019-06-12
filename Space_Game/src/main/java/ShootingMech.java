import java.awt.Graphics2D;
import java.util.LinkedList;

public class ShootingMech {
    static LinkedList<Bullet> ammo = new LinkedList<Bullet>();
    Bullet temp;
    Player player = new Player();

    public ShootingMech() {
        addAmmo(new Bullet(player.getX(), player.getY()));
    }

    public void update() {
        for(int i = 0; i < ammo.size(); i++) {
            temp = ammo.get(i);
            temp.update();
        }
    }

    public void draw(Graphics2D g2d) {
        for(int i = 0; i < ammo.size(); i++) {
            temp = ammo.get(i);
            temp.draw(g2d);
        }
    }

    public static void addAmmo(Bullet bullet) {
        ammo.add(bullet);
    }

    public static void removeAmmo(Bullet bullet) {
        ammo.remove(bullet);
    }

    public static LinkedList getBullet() {
        return ammo;
    }
}