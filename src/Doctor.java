/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author valet8115
 */
public class Doctor {

    private int row;//creates row int
    private int col;//creates col int

    public Doctor(int startRow, int startCol) {
        row = startRow;
        col = startCol;
    }

    public void move(int newRow, int newCol) {//the move method
        if ((newRow > row + 1 || newRow < row - 1) || newCol > col + 1 || newCol < col - 1) {//if the row is not one away from the doc's current spot 
            row = (int) (Math.random() * 8);//find a random row
            col = (int) (Math.random() * 8);//find a random col
        } else { //move to new spot
            row = newRow;
            col = newCol;
        }



    }

    public int getRow() {//method to get the row
        return this.row;
    }

    public int getCol() {//method to get the col
        return this.col;
    }
}