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
    
    public Dalek(int startRow, int startCol){
        row = startRow;
        col = startCol;
    }
    
    public void advanceTowards(Doctor doc){
        if (row > doc.getRow()){
            row = row - 1;
        }else if (row < doc.getRow()){
            row = row + 1;
        }
        
        if (this.col > doc.getCol()){
            this.col = col - 1;
        }else if (this.col < doc.getCol()){
            this.col = col + 1;
        }     
    }
    
    public void crash(){
        hasCrashed = true;
    }
    
    public boolean hasCrashed(){
       return hasCrashed;     
    }
    
    public int getRow(){
       return this.row;    
    }
    
    public int getCol(){
        return this.col; 
    }
}
