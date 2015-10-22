/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author donet6376
 */
public class Doctor {
    
    private int row;
    private int col;
    
    /**
     * Sets the starting position of the Doctor
     * @param startRow the initial row
     * @param startCol the initial column
     */
    public Doctor(int startRow, int startCol) {
        row = startRow;
        col = startCol;
    }

    /**
     * Moves the Doctor
     * @param row the given row
     * @param col the given column
     */
    public void move(int row, int col) {
        //Moves the Doctor 1 space
        if(Math.abs(this.row - row) <= 1 && Math.abs(this.col - col) <= 1) {
            this.row = row;
            this.col = col;
        }else{
        //Teleports the Doctor
            this.row = (int) (Math.random() * 8);
            this.col = (int) (Math.random() * 8);
        }
    }

    /**
     * Getter for the Row
     * @return the row of the Doctor
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Getter for the Column
     * @return the column of the Doctor
     */
    public int getCol() {
        return this.col;
    }
    
}
