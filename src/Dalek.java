/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The Daleks (the computer controlled characters) on the GameBoard.
 * @author besem4079
 */
public class Dalek {
    private int theRow;
    private int theCol;
    private int TILE_SIZE;
    private boolean crashed;
    
    /**
     * Constructor for a new Dalek.
     * @param theRow the row the Dalek is currently at.
     * @param theCol the column the Dalek is currently at.
     */
    public Dalek(int theRow, int theCol){
        this.theRow = theRow;
        this.theCol = theCol;
    }
    
    /**
     * Moves the Daleks towards the Doctor on the board.
     * @param doc the coordinates of the Doctor on the board.
     */
    public void advanceTowards(Doctor doc){
        if(doc.getRow() > this.getRow()){
            this.theRow = theRow + 1;
        }else if(doc.getRow() < this.getRow()){
            this.theRow = theRow - 1;
        }
        if(doc.getCol() > this.getCol()){
            this.theCol = theCol + 1;
        }else if(doc.getCol() < this.getCol()){
            this.theCol = theCol - 1;
        }
    }
    
    /**
     * The getter for the row.
     * @return the row of the coordinate.
     */
    public int getRow(){
        return this.theRow;
    }
    
    /**
     * The getter for the col.
     * @return the column of the coordinate.
     */
    public int getCol(){
        return this.theCol;
    }
    
    /**
     * The getter for whether a Dalek has crashed into another.
     * @return 
     */
    public boolean hasCrashed(){
        return crashed;
    }
    
    /**
     * Sets two Daleks that have collided to crash.
     */
    public void crash(){
        crashed = true;
    }
    
}
