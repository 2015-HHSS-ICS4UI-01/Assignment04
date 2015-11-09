
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Doctor class
 * @author branc2347
 */
public class Doctor {

    private int x;
    private int y;
    private Random random = new Random();

    public Doctor(int startX, int startY) {
        x = startX;
        y = startY;
    }

    /**
     * Controls the movement of the doctor. (both 1 tile and transportation)
     *
     * @param x Column to move to
     * @param y Row to move to
     */
    public void move(int x, int y) {
        if (Math.abs(this.x - x) <= 1 && Math.abs(this.y - y) <= 1) {
            this.x = x;
            this.y = y;
        } else if (Math.abs(this.x - x) > 1 || Math.abs(this.y - y) > 1) {
            this.x = random.nextInt(12);
            this.y = random.nextInt(12);
        }
    }

    /**
     * Get the x-coordinate
     *
     * @return x-coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get the y-coordinate
     *
     * @return the y coordinate
     */
    public int getY() {
        return this.y;
    }
}
