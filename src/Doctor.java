/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The Doctor (the player) on the GameBoard.
 * @author besem4079
 */
public class Doctor {

    private int theRow;
    private int theCol;
   
    /**
     * Constructor for a new Doctor.
     * @param theRow the row the Doctor is currently at.
     * @param theCol  the column the Doctor is currently at.
     */
    public Doctor(int theRow, int theCol){
        this.theRow = theRow;
        this.theCol = theCol;
    }
    
    /**
     * Moves the Doctor to a new position.
     * @param newRow the Doctor's new row.
     * @param newCol the Doctor's new column.
     */
    public void move(int newRow, int newCol){
        if(newRow <= this.theRow){
            
        }
    }
    
    /**
     * The getter for the Row.
     * @return the row of the coordinate
     */
    public int getRow(){
        return this.theRow;
    }
    
    /**
     * The getter for the Col.
     * @return the column of the coordinate.
     */
    public int getCol(){
        return this.theCol;
    }
}
