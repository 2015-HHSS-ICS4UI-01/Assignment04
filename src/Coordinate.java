/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A Coordinate on the Game Board
 * 
 * @author haidj9901
 */
public class Coordinate {
    
    private int x;
    private int y;
    
    /**
     * Constructor for a new Coordinate
     * @param x the x-coordinate of the coordinate
     * @param y the y-coordinate of the coordinate
     */
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Getter for the x
     * @return the x-coordinate of the coordinate
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * The getter for the Col
     * @return the col of the coordinate
     */
    public int getY(){
        return this.y;
    }
   
}
