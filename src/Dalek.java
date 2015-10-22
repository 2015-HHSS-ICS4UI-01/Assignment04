
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author donet6376
 */
public class Dalek {
    
    private int row;
    private int col;
    private boolean hasCrashed;

    /**
     * Sets the starting position of the Dalek and sets the Crashed value
     * @param startRow the initial row
     * @param startCol the initial column
     */
    public Dalek(int startRow, int startCol) {
        row = startRow;
        col = startCol;
        hasCrashed = false;
    }

    /**
     * Moves the Dalek 1 space towards the Doctor
     * @param who the name of the Doctor
     */
    public void advanceTowards(Doctor who) {
        if (hasCrashed == false) {
            //gets the coordinates of the Doctor
            int whoRow = who.getRow();
            int whoCol = who.getCol();
            
            //moves the Dalek 1 row closer to the Doctor
            if(this.row > whoRow){
                this.row--;
            }else if(this.row < whoRow){
                this.row++; 
            }
            
            //moves the Dalek 1 column closer to the Doctor
            if(this.col > whoCol){
                this.col--;
            }else if(this.col < whoCol){
                this.col++;
            }
        }

    }

    /**
     * Crashes the Dalek
     */
    public void crash() {
        hasCrashed = true;
    }

    /**
     * Getter for the Crashed value
     * @return the Crashed value of the Dalek
     */
    public boolean hasCrashed() {
        return hasCrashed;
    }

    /**
     * Getter for the Row
     * @return the row of the Dalek
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Getter for the Column
     * @return the column of the Dalek
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Getter for the Color
     * @return the color of the Dalek
     */
    public Color getColor() {
        if (hasCrashed == true) {
            return Color.RED;
        } else {
            return Color.YELLOW;
        }
    }
}
