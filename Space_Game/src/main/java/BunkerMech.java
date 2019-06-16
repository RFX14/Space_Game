import java.awt.Graphics2D;
import java.util.LinkedList;

public class BunkerMech implements Runnable {
    static LinkedList<Bunker> bunkers = new LinkedList<Bunker>();

    public BunkerMech() {

    }

    public void draw(Graphics2D g2d) {
        for(int i = 0; i < bunkers.size(); i++) {
            bunkers.get(i).draw(g2d);
        }
    }

    public void update() {
        LinkedList ammo = ShootingMech.getBullet();
        for(int i = 0; i < bunkers.size(); i++) {
            for(int j = 0; j < ammo.size(); j++) {
                if(bunkers.get(i).getBounds().intersects(((Bullet) ammo.get(j)).getBounds())) {
                    bunkers.remove(i);
                    //System.out.println("*BUNKER DESTROYED*");
                }
            }
        }
    }

    public static void addBunker(int x, int y) {
        bunkers.add(new Bunker(x, y));
    }

    public static void removeBunker(int idx) {
        bunkers.remove(idx);
    }

    public void run() {
        update();
    }
}