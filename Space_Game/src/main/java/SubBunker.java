import java.awt.Graphics2D;

public class SubBunker {
    boolean subTri = false;
    int width, height;
    int x, y, idx;
    int xPoints[], yPoints[];

    /**
     * 
     * @param idx the subpiece being selected
     */
    public SubBunker(int idx, int x, int y) {
        this.x = x;
        this.y = y;
        this.idx = idx;
        if(idx == 0 || idx == 3 || idx == 5 || idx == 6) {
            subTri = true;
        }
        width = 30;
        height = 30;
    }

    public void draw(Graphics2D g2d) {
        if(subTri) {
            switch(idx) {
                case 0:
                    xPoints = new int[] {x, x + 30, x + 30};
                    yPoints = new int[] {y + 30, y + 30, y};
                case 3:
                    xPoints = new int[] {x + 90, x + 90, x + 120};
                    yPoints = new int[] {y, y + 30, y + 30};
                case 5:
                    xPoints = new int[] {x + 30, x + 60, x + 30};
                    yPoints = new int[] {y + 30, y + 30, y + 60};
                case 6:
                    xPoints = new int[] {x + 60, x + 90, x + 90};
                    yPoints = new int[] {y + 30, y + 30, y + 60};
            }

            g2d.fillPolygon(xPoints, yPoints, 3);
        } else {
            g2d.fillRect(x, y, width, height);
        }
    }
}