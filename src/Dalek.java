/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaol9270
 */
public class Dalek {
    
    private int row;
    private int col;
    private boolean hasCrashed;
    
    /**
     * Dalek
     * @param startRow starting row
     * @param startCol starting col
     */
    public Dalek(int startRow, int startCol){
        //set row and col to the starting positions
        row = startRow;
        col = startCol;
    }
    
    /**
     * Goes toward doctor
     * @param doc the doctor
     */
    public void advanceTowards(Doctor doc){
        //if doctor is above, move up
        if(doc.getRow() < this.row){
            row-=1;
        }
        //if doctor is left, move left
        if(doc.getCol() < this.col){
            col-=1;
        }
        //if doctor is below, move down
        if(doc.getRow() > this.row){
            row+=1;
        }
        //if doctor is right, move right
        if(doc.getCol() > this.col){
            col+=1;
        }
        
    }
    
    /**
     * when crashed with another dalek
     */
    public void crash(){
        hasCrashed = true;
    }
    
    /**
     * already crashed
     * @return if it has crashed
     */
    public boolean hasCrashed(){
        return hasCrashed;
    }
    
    /**
     * row
     * @return find the row the dalek is on
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * column
     * @return find the column the dalek is on
     */
    public int getCol(){
        return this.col;
    }
}
