/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class Doctor {

    private int row;
    private int col;
    private boolean hasCrashed;

    public Doctor(int startRow, int startCol) {
        row = startRow;
        col = startCol;
        hasCrashed = false;
    }

    public void move(int newRow, int newCol) {
        //if the area clicked on the board is more than 1 tile away from the Doctor
        if (newRow > row + 1 || newRow < row - 1 || newCol > col + 1 || newCol < col - 1) {
            //move to a random row and Column of the board
            row = (int) (Math.random() * 8);
            col = (int) (Math.random() * 8);
        } else {
            //if clicked 1 tile away from the doctor
            //move the doctor to where you clicked
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

    public boolean hasCrashed() {
        return this.hasCrashed;
    }

    //if the row and the Column is the same as a daleks row and column
    void crash(Dalek dalek) {
        if (this.row == dalek.getRow() && this.col == dalek.getCol()) {
            //the doctor has crashed
            hasCrashed = true;

        }
    }
}
