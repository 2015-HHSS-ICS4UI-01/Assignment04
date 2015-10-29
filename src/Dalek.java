/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class is to get the Dalek moving and be able to have the daleks crash into each other, and so that they chase the doctor.
 * @author isles3536
 */
public class Dalek {
    
    private int row;
    private int col;
    private boolean hasCrashed;
    
    public Dalek(int startRow, int startCol){
        row = startRow;
        col = startCol;
        
    }
    
    public void advancesTowards(Doctor doc){  
     if(hasCrashed == false){
        if(row<doc.getRow()){
            row++;
        }
        if(row>doc.getRow()){
            row--;
        }
        if(col<doc.getCol()){
            col++;
        }
        if(col>doc.getCol()){
            col--;
        }
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
