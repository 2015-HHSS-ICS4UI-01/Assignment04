/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class Dalek {

    private int row;
    private int col;
    private boolean hasCrashed;

    public Dalek(int startRow, int startCol) {
        row = startRow;
        col = startCol;
        //dalek starts off not crashed
        hasCrashed = false;

    }

    public void advanceTowards(Doctor doc) {
        int docRow = doc.getRow();
        int docCol = doc.getCol();

        //if the doctors row is less than the daleks row
        if (docRow < row) {
            //subtract one from the daleks row
            row--;
            //if the doctors row is greater than the daleks row
        } else if (docRow > row) {
            //add one to the daleks row
            row++;
        }
        //if the doctors column is less than the daleks column
        if (docCol < col) {
            //subtract one from the daleks column
            col--;
            //if the doctors row is greater than the daleks column
        } else if (docCol > col) {
            //add one to the daleks column
            col++;
        }


    }

    public void crash(Dalek dalek) {
        //if the row and column of a dalek is the same as another daleks row and column
        if (this.row == dalek.getRow() && this.col == dalek.getCol()) {
            //the dalek has crashed
            hasCrashed = true;

        }

    }

    public boolean hasCrashed() {
        return this.hasCrashed;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    void crash(Doctor doc) {
        //if the row and column of a dalek is the same as the doctors row and column
        if (this.row == doc.getRow() && this.col == doc.getCol()) {
            //the dalek has crashed
            hasCrashed = true;

        }
    }
}
