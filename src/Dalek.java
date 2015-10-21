/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fathn1690
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
        
    }
    
    public void crash(){
        
    }
    
    public boolean hasCrashed(){
        return hasCrashed;
    }
    
    public int getRow(){
        return row;
    }
    
    
    public int getCol(){
        return col;
    }
    
}
