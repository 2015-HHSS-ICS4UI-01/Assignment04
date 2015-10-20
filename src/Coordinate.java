/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A Coordinate on the Game Board
 *
 * @author lamonta
 */
public class Coordinate {

    private int x;
    private int y;

    /**
     * Constructor for a new Coordinate
     *
     * @param row the row of the coordinate
     * @param col the column of the coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for the row
     *
     * @return the row of the coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * The getter for the Col
     *
     * @return the col of the coordinate
     */
    public int getY() {
        return this.y;
    }
}
