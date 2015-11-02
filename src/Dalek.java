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
        
        if(hasCrashed == false){
        
        //finding where the doctor is
        int docRow = doc.getRow();
        int docCol = doc.getCol();
        
        if(hasCrashed == false){
            
            //finding where the doctor is
            int docRow = doc.getRow();
            int docCol = doc.getCol();
        
            if(row < docRow){
                row = row + 1;
            }else if(row > docRow){
             row = row - 1;
            }
        
            if(col < docCol){
                col = col + 1;
            }else if(col > docCol){
                col = col - 1;
            }
        
        }else if(hasCrashed == true){
                
            row = row;
            col = col;
            
        }
        
        
        }else{
            row = row;
            col = col;
        }
        
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
