import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.LinkedList;

public class Bunker {
    int x, y;
    int width, height;
    LinkedList subPiece;

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
        width = 30;
        height = 30;
        this.x = x;
        this.y = y;
        subPiece = new LinkedList<SubBunker>();
        LinkedList<Integer> subHealth = new LinkedList<Integer>(Arrays.asList(4, 4, 4, 4, 
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

        /*
        for(int i = 0; i < 10; i++) {
            subPiece.add(new SubBunker(i, x, y));
        }
        */
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        /*
        for(int i = 0; i < 10; i++) {
            ((SubBunker) subPiece.get(i)).draw(g2d);
        }
        */

        
        //0
        g2d.fillPolygon(xPoints, yPoints, 3);

        //1
        g2d.fillRect(x + 30, y, width, height);

        //2
        g2d.fillRect(x + 60, y, width, height);

        //3
        g2d.fillPolygon(xPoints2, yPoints2, 3);

        //4
        g2d.fillRect(x, y + 30, width, height);

        //5
        g2d.fillPolygon(xPoints3, yPoints3, 3);

        //6
        g2d.fillPolygon(xPoints4, yPoints4, 3);

        //7
        g2d.fillRect(x + 90, y + 30, width, height);

        //8
        g2d.fillRect(x, y + 60, width, height);

        //9
        g2d.fillRect(x + 90, y + 60, height, height);
        
        
    }

    public void update() {
        
    }

    public Rectangle getBounds() {
        /*
        LinkedList<Rectangle> subBounds = new LinkedList<Rectangle>(Arrays.asList(new Rectangle(x, y, width, height), 
                                                                    new Rectangle(x + 30, y, width, height),
                                                                    new Rectangle(x + 60, y, width, height),
                                                                    new Rectangle(x + 90, y, width, height),
                                                                    new Rectangle(x, y + 30, width, height),
                                                                    new Rectangle(x + 30, y + 30, width, height),
                                                                    new Rectangle(x + 60, y + 30, width, height),
                                                                    new Rectangle(x + 90, y + 30, width, height),
                                                                    new Rectangle(x, y + 60, width, height),
                                                                    new Rectangle(x + 90, y + 60, width, height)));
        return subBounds;
        */

        return new Rectangle(x, y, 120, 90);
    }
}