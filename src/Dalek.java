/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rayan4858
 */
public class Dalek {
    private int row;
    private int col;
    private boolean hasCrashed;
    
    
    /**
     * 
     * @aparam startRow
     * @param startCol 
     */
    public Dalek(int startRow, int startCol){
        row = startRow;
        col = startCol;
    }
    
    
    /**
     * Move towards the doctor
     * @param doc 
     */
    public void moveTowards(Doctor doc){
        if (hasCrashed == false) {
            int docrow = doc.getRow();
            int doccol = doc.getRow();
        }
    }
    
    /**
     * 
     */
    public void crash(){
        
    }
    
    /**
     * Gets the row of the dalek
     * @return 
     */
    public  int getRow(){
        return this.row;
    }
    
    /**
     * Gets colum of the dalek
     * @return 
     */
    public int getCol(){
        return this.col;
    }
    
}
