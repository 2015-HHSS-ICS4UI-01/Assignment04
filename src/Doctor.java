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
     * moves the doctor
     * @param row this is the row that the doctor moves on
     * @param col this is the column that the doctor moves on
     */
    public void move(int firstRow, int firstCol){
        
        if((firstRow == row || firstRow == row - 1 || firstRow == row + 1) && 
                (firstCol == col || firstCol == col - 1 || firstCol == col + 1) ){
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
