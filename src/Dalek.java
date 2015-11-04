/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thomt9963
 */
public class Dalek {
    
    private int row;
    private int col;
    private boolean hasCrashed;
    /**
     * Create the Dalek and state the starting row and col
     * @param startRow the starting row of the Dalek
     * @param startCol the starting column of the Dalek
     */
    public Dalek(int startRow, int startCol){
        row = startRow;
        col = startCol;
    }
    /**
     * Set the Dalek movements towards the doctor
     * @param doc the players position
     */
    public void advanceTowards(Doctor doc){
        if (row > doc.getRow()){
            row = row - 1;
        }else if (row < doc.getRow()){
            row = row + 1;
        }
        
        if (col > doc.getCol()){
            col = col - 1;
        }else if (col < doc.getCol()){
            col = col + 1;
        }     
    }
    /**
     * set the Dalek hasCrashed to true
     */
    public void crash(){
        hasCrashed = true;
    }
    /**
     * Disables the Dalek
     * @return 
     */
    public boolean hasCrashed(){
       return hasCrashed;     
    }
    /**
     * the row of the Dalek
     * @return 
     */
    public int getRow(){
       return this.row;    
    }
    /**
     * the column of the Dalek
     * @return 
     */
    public int getCol(){
        return this.col; 
    }
}
