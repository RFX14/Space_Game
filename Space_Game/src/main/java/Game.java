import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

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
    Player player;
    ShootingMech shoot;
    EnemyMech enemies;
    BunkerMech bunkers;
    Timer gamelooptimer;
    static JFrame frame = new JFrame();

    public Game() {
        setLayout(null);
        xSize = 640;
        ySize = 480;
        player = new Player();
        shoot = new ShootingMech();
        bunkers = new BunkerMech();
        BunkerMech.addBunker(100, 100);
        BunkerMech.addBunker(500, 100);
        enemies = new EnemyMech(0, 0, 2);

        setFocusable(true);
        gamelooptimer = new Timer(5, this);
        gamelooptimer.start();
        addKeyListener(new KeyInput(player));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            BufferedImage sky = ImageIO.read(getClass().getClassLoader().getResource("Night_Sky.png"));
            g2d.drawImage(sky, null, 0, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        enemies.draw(g2d);
        bunkers.draw(g2d);
        player.draw(g2d);
        shoot.draw(g2d);
        
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
        enemies.update();
        bunkers.update();
        player.update();
        shoot.update();
        repaint();
    }
}
