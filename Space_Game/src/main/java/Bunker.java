import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.LinkedList;

public class Bunker {
    int x, y;
    //Triangles
    int xPoints[];
    int yPoints[];

    int xPoints2[];
    int yPoints2[];

    int xPoints3[];
    int yPoints3[];

    int xPoints4[];
    int yPoints4[];
    public Bunker(int x, int y) {
        //Keeps track of the subpieces life remaining from hits
        //Pieces start left to right starting from the top left
        this.x = x;
        this.y = y;
        LinkedList<Integer> bunkerSubset = new LinkedList<Integer>(Arrays.asList(4, 4, 4, 4, 
                                                                            4, 4, 4, 4, 4, 4));
        
        //Generalizes the position of the bunker
        xPoints = new int[] {x, x + 30, x + 30};
        yPoints = new int[] {y + 30, y + 30, y};

        xPoints2 = new int[] {x + 90, x + 90, x + 120};
        yPoints2 = new int[] {y, y + 30, y + 30};

        xPoints3 = new int[] {x + 30, x + 60, x + 30};
        yPoints3 = new int[] {y + 30, y + 30, y + 60};

        xPoints4 = new int[] {x + 60, x + 90, x + 90};
        yPoints4 = new int[] {y + 30, y + 30, y + 60};
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);

        //0
        g2d.fillPolygon(xPoints, yPoints, 3);

        //1
        g2d.fillRect(x + 30, y, 30, 30);

        //2
        g2d.fillRect(x + 60, y, 30, 30);

        //3
        g2d.fillPolygon(xPoints2, yPoints2, 3);

        //4
        g2d.fillRect(x, y + 30, 30, 30);

        //5
        g2d.fillPolygon(xPoints3, yPoints3, 3);

        //6
        g2d.fillPolygon(xPoints4, yPoints4, 3);

        //7
        g2d.fillRect(x + 90, y + 30, 30, 30);

        //8
        g2d.fillRect(x, y + 60, 30, 30);

        //9
        g2d.fillRect(x + 90, y + 60, 30, 30);


        /**
         * Removing the hit detection portion for now because I'm trying to 
         * generalize the drawing of the bunkers and hit detection complicates 
         * things for now
         */
        /*
        for(int i = 0; i < ShootingMech.getBullet().size(); i++) {
            if(((Bullet) ShootingMech.getBullet().get(i)).hit()) {
                g2d.setColor(Color.BLACK);
                g2d.fillRect(100, 100, 120, 90);
                ShootingMech.removeAmmo((Bullet) ShootingMech.getBullet().get(i));
            }
        }
        */
        

        
    }

    public void update() {
        
    }

    //TODO: Figure out subpiece hit
    public Rectangle getBounds() {
        /*
        LinkedList<Rectangle> subBounds = new LinkedList<Rectangle>();
        return subBounds;
        */

        return new Rectangle(x, y, 120, 90);
    }
}