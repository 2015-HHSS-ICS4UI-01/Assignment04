/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author millg1278
 */
public class Dalek {
    
    private int row;
    private int col;
    private boolean hasCrashed;
    
    public Dalek(int startRow, int startCol){
        row = startRow;
        col = startCol;
        hasCrashed = false;
    }
    
    public void advanceTowards(Doctor doc){
        //checks if the row is less or greater and if so, adds 1
    if (row < doc.getRow()){
        row ++;
    } if (row > doc.getRow()){
        row --;
    }
    //checks if the row is less or greater and if so, adds 1
    if (col < doc.getCol()){
        col ++;
    }if (col > doc.getCol()){
        col --;
    }
        
    }
    
    public void crash(){
        // sees if the dalek is crashed
        hasCrashed = true;
    }
    
    public boolean hasCrashed(){
        return hasCrashed;
    }
    
    public int getrow(){
       return row; 
    }
    
    public int getcol(){
       return col; 
    }
}
