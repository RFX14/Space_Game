import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Space_Game
 * Created: Jun 7, 2019
 * TODO: Create Menu Design
 */

/**
 * @author coffeemate
 *
 */
public class Menu extends JPanel{
    int xSize, ySize;

    public Menu() {
        setBackground(Color.BLACK);
        xSize = 640;
        ySize = 480;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(xSize/2 - 75, ySize/2 - 25, 150, 50);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public static void main(String[] args) {
        Task taskRunner = new Task();
        taskRunner.start();
    }
}

class Task extends Thread {
    public void run() {
        JFrame frame = new JFrame();

        frame.pack();
        frame.setResizable(false);
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(new Menu());
    }
}