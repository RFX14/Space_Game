import java.awt.Graphics2D;
import java.util.LinkedList;

public class EnemyMech {
    static LinkedList<Enemy> enemies = new LinkedList<Enemy>();

    /**
     * Initiallizes the enemies by filling the LinkedList by a given amount
     * @param x is the x-coordinate of the left most enemy
     * @param y is the y-coordinate of all the enemies
     * @param numEnemy is the number of enemies that are to be spawned
     */
    public EnemyMech(int x, int y, int numEnemy) {
        addEnemy(x, y, numEnemy);
    }

    /**
     * Updates positions of the enemies as well as removes them from memory once off screen
     */
    public void update() {
        LinkedList<Bullet> bullets = ShootingMech.getBullet();
        for(int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update();
            if(enemies.get(i).getY() > 430 || enemies.get(i).getY() == 0 && enemies.get(i).getX() > 630) {
                removeEnemy(i);
            }
            for(int j = 0; j < bullets.size(); j++) {
                if(enemies.get(i).getBounds().intersects(bullets.get(j).getBounds())) {
                    removeEnemy(i);
                }
            }
        }
    }

    public void draw(Graphics2D g2d) {
        for(int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(g2d);
        }
    }

    /**
     * Adds additional enemies to the LinkedList
     * @param x is the x-coordinate of the left most enemy
     * @param y is the y-coordinate of all the enemies
     * @param numEnemy is the number of enemies that are to be spawned
     */
    public static void addEnemy(int x, int y, int numEnemy) {
        for(int i = 0; i < numEnemy; i++) {
            enemies.add(new Enemy(x + (i * 40), y));
        }
    }

    /**
     * Removes enemy from LinkedList at a given index
     * @param idx is the index of the enemy wanting to be removed
     */
    public static void removeEnemy(int idx) {
        enemies.remove(idx);
    }
}