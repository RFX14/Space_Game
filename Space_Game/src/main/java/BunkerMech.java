import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.LinkedList;

public class BunkerMech implements Runnable {
    static LinkedList<Bunker> bunkers = new LinkedList<Bunker>();
    int width, height;
    Shape shape;

    public BunkerMech() {
        width = 30;
        height = 30;
    }

    public void draw(Graphics2D g2d) {
        for (int i = 0; i < bunkers.size(); i++) {
            bunkers.get(i).draw(g2d);
        }
    }

    public void update() {
        LinkedList ammo = ShootingMech.getBullet();
        for(int i = 0; i < bunkers.size(); i++) {
            LinkedList sub = bunkers.get(i).getBounds();
            for(int j = 0; j < ammo.size(); j++) {
                for(int k = 0; k < bunkers.get(i).subShape.size(); k++) {
                    if(((Rectangle) sub.get(k)).intersects(((Bullet) ammo.get(j)).getBounds())) {
                        removeBunker(i, k);
                        //System.out.println("*BUNKER DESTROYED*");
                    }
                }
            }
        }
    }

    public static void addBunker(int x, int y) {
        bunkers.add(new Bunker(x, y));
    }

    public static void removeBunker(int idx, int idx2) {
        bunkers.get(idx).subShape.remove(idx2);
    }

    public void run() {
        update();
    }
}