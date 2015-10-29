/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulm6438
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
    
    
    public void advanceTowards(Doctor paul){
        if(paul.getRow() > row){
            row = row + 1;
        }if(paul.getRow() < row){
            row = row - 1; 
        }if(paul.getCol() > col){
            col = col + 1; 
        }if(paul.getCol() < col)
            col = col - 1;  
    }
    
    public void crash(){
        hasCrashed = true;
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
