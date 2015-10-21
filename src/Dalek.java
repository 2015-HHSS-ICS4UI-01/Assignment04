/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author branc2347
 */
public class Dalek {

    private int x;
    private int y;
    private boolean hasCrashed = false;

    public Dalek(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void advanceTowards(Doctor doctor) {
        if (doctor.getX() > this.x) {
            this.x++;
        } else if (doctor.getX() < this.x) {
            this.x--;
        }
        if (doctor.getY() > this.y) {
            this.y++;
        } else if (doctor.getY() < this.y) {
            this.y--;
        }
    }

    public void crash() {
        hasCrashed = true;
    }

    public boolean hasCrashed() {
        return this.hasCrashed;
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
