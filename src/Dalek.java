/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simma1980
 */
public class Dalek {

    private int row, col;
    private boolean hasCrashed = false;

    public Dalek(int startRow, int startCol) {
        row = startRow;
        col = startCol;
    }

    public void move(Doctor doc) {
        if (row < doc.getRow()) {
            row += 1;
        } else if (row > doc.getRow()) {
            row -= 1;
        }
        if (col < doc.getCol()) {
            col += 1;
        } else if (col > doc.getCol()) {
            col -= 1;
        }
    }

    public void crash() {
        hasCrashed = true;
    }

    public boolean hasCrashed() {
        return hasCrashed;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
