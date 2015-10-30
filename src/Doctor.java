/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dinse0649
 */
public class Doctor {
    /**
     * These variables are only for the Doctor class and are used for movement
     */
    private int row;
    private int col;
    
    /**
     * The Doctor's starting position
     * @param startRow The starting row
     * @param startCol The starting column
     */
    public Doctor(int startRow, int startCol){
        row = startRow;
        col = startCol;
    }
    
    /**
     * The Doctor's movement
     * @param row Doctor's row
     * @param col Doctor's column
     */
    public void move(int row, int col){
        //Teleports the doctor if he's more than one space away
        if(Math.abs(row - this.row) > 1 || (Math.abs(col - this.col)) > 1)
        {
            row = (int)(Math.random()*8);
            col = (int)(Math.random()*8);
        }
        this.row = row;
        this.col = col;
    }
    
    /**
     * Makes Doctor's row available to the other classes
     * @return Doctor's row
     */
    public int getRow(){
      return this.row;
    }
    /**
     * Makes Doctor's column available to the other classes
     * @return Doctor's column
     */
    public int getCol(){
        return this.col;
    }
    
}
