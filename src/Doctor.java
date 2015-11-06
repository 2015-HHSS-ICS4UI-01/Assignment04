/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class is to make the doctor move and give him the ability to teleport.
 * @author isles3536
 */
public class Doctor {
    /**
     * These variables are for this class only to use to be able to change the doctors position on the board, so that he can move and teleport.
     */
    private int row;
    private int col;
    /**
     * This is for the doctors starting position
     * @param startRow This is his current row.
     * @param startCol This is his current column.
     */
    public Doctor(int startRow, int startCol){
        
        
        row = startRow;
        col = startCol;
    }
    
    /**
     * This is to make the doctor move around the board
     * @param row This is the row that the doctor is moving to, and the number is randomized if the use clicks two spaces away from himself.
     * @param col This is the column that the doctor is moving to, and the number is randomized if the use clicks two spaces away from himself.
     */
    public void move(int row, int col){
        //This to give the doctor a random place on the board if the user dicides to teleport
        if(Math.abs(row - this.row)>1 ||(Math.abs(col - this.col))>1){
            row = (int)(Math.random()*8);
            col = (int)(Math.random()*8);
        }
        this.row = row;
        this.col = col;                                                                                                              
    }
    /**
     * This to make the row that the doctor is on public to other classes.
     * @return 
     */
    public int getRow(){
        return this.row;
    }
    /**
     * This to make the column that the doctor is on public to other classes.
     * @return 
     */
    public int getCol(){
        return this.col;
    }
    
}
