import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.LinkedList;

public class Bunker {
    int x, y;
    int width, height;
    //Contains all 10pieces that make up a bunker
    LinkedList<SubBunker> subShape = new LinkedList<SubBunker>();

    public Bunker(int x, int y) {                              
        width = 30;
        height = 30;
        this.x = x;
        this.y = y;

        for(int i = 0; i < 10; i++) {
            subShape.add(new SubBunker(x, y));
        }
        
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        for(int i = 0; i < subShape.size(); i++) {
            subShape.get(i).draw(g2d, i);
        }
    }

    public LinkedList getBounds() {
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
    }

}