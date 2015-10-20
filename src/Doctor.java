/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author valet8115
 */
public class Doctor {

    private int row;
    private int col;

    public Doctor(int startRow, int startCol) {
        row = startRow;
        col = startCol;
    }

    public void move(int newRow, int newCol) {
        if ((newRow > row + 1 || newRow < row - 1) || newCol > col + 1 || newCol < col - 1) {
            row = (int) (Math.random() * 8);
            col = (int) (Math.random() * 8);
        } else {
            row = newRow;
            col = newCol;
        }



    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}