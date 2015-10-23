/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class Dalek {
    
    private int row;
    private int col;
    private boolean hasCrashed;
    
    public Dalek(int startRow, int startCol){
       row = startRow;
       col= startCol;
       hasCrashed = false;
     
    }
    
    public void advanceTowards(Doctor doc){
        int docRow = doc.getRow();
        int docCol = doc.getCol();
        
        if(docRow<row)
        {
            row--;
        }else if(docRow > row){
            row++;
        } 
        
        if(docCol<col){
            col--;
        }else if(docCol>col){
            col++;
        }
        
        
    }
    
    public void crash(Dalek second){
        if(this.row == second.getRow() && this.col == second.getCol()){
           hasCrashed = true; 
           
        }
       
    }
    
    public boolean hasCrashed(){
       return this.hasCrashed;
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }

    void crash(Doctor doc) {
         if(this.row == doc.getRow() && this.col == doc.getCol()){
           hasCrashed = true; 
           
        }
    }
    
}
