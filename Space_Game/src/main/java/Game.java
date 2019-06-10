import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Space_Game
 * Created: Jun 7, 2019
 * TODO: 
 */

/**
 * @author coffeemate
 *
 */
public class Game extends JPanel implements Runnable, ActionListener {
    int xSize, ySize;
    Player player = new Player();
    static JFrame frame = new JFrame();

    public Game() {
        setLayout(null);
        xSize = 640;
        ySize = 480;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            BufferedImage sky = ImageIO.read(new File("Night_Sky.png"));
            g2d.drawImage(sky, null, 0, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void run() {
        frame.pack();
        frame.setResizable(false);
        frame.setSize(xSize, ySize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(new Game());
    }

    public void actionPerformed(ActionEvent e) {
        player.update();
    }
}
