import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.LinkedList;

public class BunkerMech implements Runnable {
    //List of all bunkers visible
    static LinkedList<Bunker> bunkers = new LinkedList<Bunker>();
    int width, height;
    Shape shape;

    public BunkerMech() {
        width = 30;
        height = 30;
    }

    public void draw(Graphics2D g2d) {
        //Draws number of bunkers desired
        for (int i = 0; i < bunkers.size(); i++) {
            bunkers.get(i).draw(g2d);
        }
    }

    /**
     * Goes through each bunker and its subpieces and
     * checks if any of the subpieces intersect a bullet
     * if it does then it deletes the piece
     */
    public void update() {
        LinkedList<Bullet> ammo = ShootingMech.getBullet();
        for(int i = 0; i < bunkers.size(); i++) {
            LinkedList<Rectangle> sub = bunkers.get(i).getBounds();
            for(int j = 0; j < ammo.size(); j++) {
                for(int k = 0; k < bunkers.get(i).subShape.size(); k++) {
                    if(((sub.get(k)).intersects((ammo.get(j)).getBounds()))) {
                        removeBunker(i, k);
                        ShootingMech.removeAmmo(ammo.get(j));
                        //System.out.println("*BUNKER DESTROYED*");
                    }
                }
            }
        }
    }

    public static void addBunker(int x, int y) {
        bunkers.add(new Bunker(x, y));
    }

    //Deletes a subPiece that is hit
    public static void removeBunker(int idx, int idx2) {
        bunkers.get(idx).subShape.remove(idx2);
        bunkers.get(idx).subBounds.remove(idx2);
    }

    public void run() {
        update();
    }
}