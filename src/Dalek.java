/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dinse0649
 */
public class Dalek {
    /*
     * These variables are only for the Dalek class. They are used for movement and to
     * see if the Daleks crash with the Doctor.
     */
    private int row;
    private int col;
    private boolean hasCrashed;
    
    /**
     * Dalek's starting position
     * @param startRow The starting row
     * @param startCol The starting column
     */
    public Dalek(int startRow, int startCol){
        row = startRow;
        col = startCol;
    }
    
    /**
     * Dalek's movement which is towards the Doctor
     * @param doc The Doctor that the Daleks are advancing towards
     */
    public void advanceTowards(Doctor doc){
        //If Daleks row and column is less than the Doctors, +1 to row and column
        if (row < doc.getRow()){
            row++;
        }
        if (col < doc.getCol()){
            col++;
        }
        //If Daleks row and column is more than the Doctors, -1 to the row and column
        if (row > doc.getRow()){
            row--;
        }
        
        if (col > doc.getCol()){
            col--;
        }
        
        
    }
    /**
     * Changes hasCrashed variable to true, so the game knows the Daleks crashed
     */
    public void crash(){
          hasCrashed = true;      
    }
    /**
     * Says a Dalek has crashed with another Dalek
     * @return Daleks have crashed
     */
    public boolean hasCrashed(){
         return hasCrashed;
    }
    /**
     * Makes Dalek's row available to the other classes
     * @return Dalek's row
     */
    public int getRow(){
        return this.row;  
    }
    /**
     * Makes Dalek's column available to the other classes
     * @return Dalek's column
     */
    public int getCol(){
        return this.col;
    }
}
