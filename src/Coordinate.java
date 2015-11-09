/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A Coordinate on the Game Board
 *
 * @author branc2347
 */
public class Coordinate {

    private int x;
    private int y;

    /**
     * Constructor for a new Coordinate
     *
     * @param y the row of the coordinate
     * @param x the column of the coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for the y
     *
     * @return the row of the coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * The getter for the x
     *
     * @return the col of the coordinate
     */
    public int getX() {
        return this.x;
    }
}
