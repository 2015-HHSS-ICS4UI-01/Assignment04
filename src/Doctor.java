
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thomt9963
 */
public class Doctor {
    
    private int row;
    private int col;

    /**
     * Create the doctor and set its row and col
     * @param startRow the starting row of the doctor
     * @param startCol the starting column of the doctor
     */
    public Doctor(int startRow, int startCol) {
        row = startRow;
        col = startCol;

    }
/**
 * The method allowing the doctor to move on the board
 * @param row the row of the doctor
 * @param col the column of the doctor
 */
    public void move(int row, int col) {
        Random rand = new Random();
        if (Math.abs(row - this.row) > 1 || Math.abs(col - this.col) > 1) {
            this.col = rand.nextInt(8);
            this.row = rand.nextInt(8);
        }else{
            this.row = row;
            this.col = col;
        }
    }
/**
 * the row of the doctor
 * @return 
 */
    public int getRow() {
        return this.row;
    }
/**
 * the column of the doctor
 * @return 
 */
    public int getCol() {
        return this.col;
    }
}
