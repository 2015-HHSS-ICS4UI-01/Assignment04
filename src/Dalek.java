/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kampn2687
 */
public class Dalek {

    private int row;
    private int col;
    private boolean hasCrashed;

    public Dalek(int startRow, int startCol) {
        row = startRow;
        col = startCol;
    }

    public void advanceTowards(Doctor doc) {
        //checks if the row is less or greater and if so, adds 1
        if(row < doc.getRow()){
            row ++;
        }if(row > doc.getRow()){
            row --;
        }
        //checks if the col is less or greater and if so, adds 1
        if(col < doc.getCol()){
            col ++;
        }if(col > doc.getCol()){
            col --;
        }
        
    }

    public void crash() {
        //sets has crashed to true
        hasCrashed = true;
    }

    public boolean hasCrashed() {
//sets true
        return hasCrashed;
    }

    public int getRow() {
        //gives the row of acertian dalek
        return this.row;
    }

    public int getCol() {
        //gives the col of a certian dalek
        return this.col;
    }
}
