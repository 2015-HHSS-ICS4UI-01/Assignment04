/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author valet8115
 */
public class Dalek {

    private int row;
    private int col;
    private boolean hasCrashed;

    public Dalek(int startRow, int startCol) {
        row = startRow;
        col = startCol;
        hasCrashed = false;
    }

    public void advanceTowards(Doctor doc) {
        if (hasCrashed == false) {

            int docRow = doc.getRow();
            int docCol = doc.getCol();

            if (docRow > row) {
                row++;
            } else if (docRow < row) {
                row--;
            }

            if (docCol > col) {
                col++;
            } else if (docCol < col) {
                col--;
            }
        }

    }

    public void crash() {
        hasCrashed = true;
    }

    public boolean hasCrashed() {
        return hasCrashed;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
