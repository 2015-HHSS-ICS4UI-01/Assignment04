/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Dalek object
 * @author branc2347
 */
public class Dalek {

    private int x; //dalek's x position
    private int y; //dalek's y position
    private boolean hasCrashed = false; //dalek's state of crash or alive

    public Dalek(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Move the dalek towards the doctor
     *
     * @param doctor the doctor to move towards
     */
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

    /**
     * Set the state of the dalek as crashed
     */
    public void crash() {
        hasCrashed = true;
    }

    /**
     * if the dalek has crashed
     *
     * @return true for crash, false for alive
     */
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
