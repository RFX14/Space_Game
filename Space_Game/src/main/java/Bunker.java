import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.LinkedList;

public class Bunker {
    int xPoints[] = {100, 130, 130};
    int yPoints[] = {130, 130, 100};

    int xPoints2[] = {190, 190, 220};
    int yPoints2[] = {100, 130, 130};

    int xPoints3[] = {130, 160, 130};
    int yPoints3[] = {130, 130, 160};

    int xPoints4[] = {160, 190, 190};
    int yPoints4[] = {130, 130, 160};
    public Bunker() {
        //Keeps track of the subpieces life remaining from hits
        //Pieces start left to right starting from the top left
        LinkedList<Integer> bunkerSubset = new LinkedList<Integer>(Arrays.asList(4, 4, 4, 4, 
                                                                            4, 4, 4, 4, 4, 4));
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);

        //0
        g2d.fillPolygon(xPoints, yPoints, 3);

        //1
        g2d.fillRect(130, 100, 30, 30);

        //2
        g2d.fillRect(160, 100, 30, 30);

        //3
        g2d.fillPolygon(xPoints2, yPoints2, 3);

        //4
        g2d.fillRect(100, 130, 30, 30);

        //5
        g2d.fillPolygon(xPoints3, yPoints3, 3);

        //6
        g2d.fillPolygon(xPoints4, yPoints4, 3);

        //7
        g2d.fillRect(190, 130, 30, 30);

        //8
        g2d.fillRect(100, 160, 30, 30);

        //7
        g2d.fillRect(190, 160, 30, 30);

        for(int i = 0; i < ShootingMech.getBullet().size(); i++) {
            if(((Bullet) ShootingMech.getBullet().get(i)).hit()) {
                g2d.setColor(Color.BLACK);
                g2d.fillRect(100, 100, 120, 90);
            }
        }

        
    }

    public void update() {
        
    }

    public static Rectangle getBounds() {
        //Whole bunker for now just to test out hit deterction
        return new Rectangle(100, 100, 120, 90);
    }
}