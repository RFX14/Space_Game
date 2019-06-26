import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Space_Game
 * Created: Jun 7, 2019
 * TODO: ???
 */

/**
 * @author coffeemate
 */
public class Menu extends JPanel implements ActionListener, Runnable {
    int xSize, ySize;
    static JFrame frame = new JFrame();
    volatile static boolean close = false;

    public Menu() {
        setLayout(null);
        setBackground(Color.BLACK);
        xSize = 640;
        ySize = 480;

        JButton playBtn = new JButton("PLAY!");
        playBtn.setLocation(xSize / 2 - 75, ySize / 2 - 25);
        playBtn.setSize(150, 50);
        playBtn.addActionListener(this);
        add(playBtn);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Sprites sprites = new Sprites();

        sprites.printText("Space", 150, ySize / 10, g2d);
        sprites.printText("Game", 180, ySize / 4, g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if(btn.equalsIgnoreCase("play!")) {
            System.out.println("hehe");
            close = true;
        }
    }

    public void run() {
        frame.pack();
        frame.setResizable(false);
        frame.setSize(xSize, ySize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
    }

	public static boolean getClose() {
		return close;
    }
    
}