/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulm6438
 */
public class Doctor {

    private int row;
    private int col;

    public Doctor(int startRow, int startCol) {
        row = startRow;
        col = startCol;
    }

    public void move(int row, int col) {
        if (Math.abs(this.row - row) <= 1 && Math.abs(this.col - col) <= 1) {
            this.row = row;
            this.col = col;

        } else if ((Math.abs(this.row - row) >=2) || (Math.abs(this.col - col) >=2)) {
            this.row = (int) (Math.random() * 8);
            this.col = (int) (Math.random() * 8);
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
