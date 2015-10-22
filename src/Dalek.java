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

    public Dalek(int startRow, int startCol) {//method of the dalek
        row = startRow;
        col = startCol;
        hasCrashed = false;
    }

    public void advanceTowards(Doctor doc) {
        if (hasCrashed == false) {//if the dalek hasnt crashed

            int docRow = doc.getRow();//the doc row 
            int docCol = doc.getCol();//the doc col

            if (docRow > row) {//if the doc row is greater than the row of dalek
                row++; //move one over
            } else if (docRow < row) { // else minus one from row and or move the other way
                row--;
            }

            if (docCol > col) {//if the doc col is greater than the col of the dalek add to col
                col++;//add to col
            } else if (docCol < col) {//else if doc col is less than dalek col
                col--;//minus one from col
            }
        }

    }

    public void crash() { //crash method for the dalek
        hasCrashed = true;//the dalek has crashed
    }

    public boolean hasCrashed() {//method for whether the dalek has crashed or not
        return hasCrashed;//returnt he current state for hasCrashed 
    }

    public int getRow() {//method for getting the row of dalek
        return this.row;
    }

    public int getCol() {//methid for getting col of the dalek
        return this.col;
    }
}
