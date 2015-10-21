/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fathn1690
 */
public class Doctor {
    
    private int row;
    private int col;
    
    
    /**
     * It makes a value for the doctor
     * @param startRow row which the doctor starts at
     * @param startCol column which the doctor starts at
     */
    public Doctor(int startRow, int startCol){
        
        row = startRow;
        col = startCol;
    }
    
    /**
     * 
     * @param row
     * @param col 
     */
    public void move(int firstRow, int firstCol){
        
        if((firstRow == row || firstRow == row - 1 || firstRow == row + 1) && 
                (firstCol == row || firstCol == row - 1 || firstCol == row + 1) ){
            row = firstRow;
            col = firstCol;
        }else{
            
            row = (int)(Math.random()*8);
            col = (int)(Math.random()*8);
            
        }
        
    }
    
    /**
     * returns the row of the doctor
     * @return 
     */
    public int getRow(){
        return row;
    }
    
    /**
     * returns the column of the doctor
     * @return 
     */
    public int getCol(){
        return col;        
    }
    
}
