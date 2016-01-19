/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaol9270
 */
public class Doctor {
    private int row;
    private int col;
    
    
    /**
     * the doctor
     * @param startRow the row where the doctor starts
     * @param startCol the column where the doctor starts
     */
    public Doctor(int startRow, int startCol){
        //set row and col to the starting position
        row = startRow;
        col = startCol;
    }
    
    
    /**
     * move command, allows doctor to move
     * @param newRow the row that the doctor moves to
     * @param newCol the column the doctor moves to
     */
    public void move(int newRow, int newCol){
        //if moving to a tile more than 1 unit away
        if(newRow > row+1 || newRow < row-1 || newCol < col-1 || newCol > col+1){
            //teleport to a random location
            row = (int)(Math.random() * 8);
            col = (int)(Math.random() * 8);
        }
        else{
            //otherwise move to that position if it is 1 tile away
            row = newRow;
            col = newCol;
        }
    }
    
    /**
     * row
     * @return find the row the doctor is on
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * column
     * @return find the column the doctor is on
     */
    public int getCol(){
        return this.col;
    }
}
