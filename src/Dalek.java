

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johns6971
 */
public class Dalek {

    private int row;
    private int col;
    private boolean hasCrashed = false;
    private boolean hasMoved = false;

    /**
     * The initial row and col values of the dalek
     * @param startRow the row at which the dalek starts
     * @param startCol the col at which the dalek starts
     */
    public Dalek(int startRow, int startCol) {
        row = startRow;
        col = startCol;
    }
    /**
     * moves daleks to the doctor while they have not crashed
     * @param doc the player the daleks are moving toward 
     */
    public void advanceTowards(Doctor doc) {
        hasMoved = false;
        if (hasCrashed == false) {
            if (doc.getRow() < this.col && this.col != 0) {
                this.col--;
                hasMoved = true;
            }
            if (doc.getCol() > this.col && this.col != 7) {
                this.col++;
                hasMoved = true;
            }
            if (doc.getRow() < this.row) {
                this.row--;
                hasMoved = true;
            }
            if (doc.getRow() > this.row) {
                this.row++;
                hasMoved = true;
            }
            if(doc.getRow() == this.row && doc.getCol() < this.col && !hasMoved) {
                this.col--;
            }
            if(doc.getRow() == this.row && doc.getCol() > this.col && !hasMoved) {
                this.col++;
            }
        }
    }
    /**
     * tells the colliding daleks that they have crashed
     * @param one First dalek 
     * @param two Second dalek
     */
    public void crash(Dalek one, Dalek two) {
        one.hasCrashed = true;
        two.hasCrashed = true;
    }
    /**
     * 
     * @return the dalek's value for hasCrashed
     */
    public boolean hasCrashed() {
        return this.hasCrashed;
    }
    /**
     * 
     * @return the dalek's row
     */
    public int getRow() {
        return this.row;
    }
    /**
     * 
     * @return the dalek's col
     */
    public int getCol() {
        return this.col;
    }
    
}
