/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A Coordinate on the Game Board
 * 
 * @author donet6376
 */
public class Coordinate {
    
    private int row;
    private int col;
    
    /**
     * Constructor for a new Coordinate
     * @param row the row of the coordinate
     * @param col the column of the coordinate
     */
    public Coordinate(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    /**
     * Getter for the row
     * @return the row of the coordinate
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * The getter for the column
     * @return the column of the coordinate
     */
    public int getCol(){
        return this.col;
    }
   
}
