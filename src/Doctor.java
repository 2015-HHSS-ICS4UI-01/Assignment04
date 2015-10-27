
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thomt9963
 */
public class Doctor {

    private int row;
    private int col;

    public Doctor(int startRow, int startCol) {
        row = startRow;
        col = startCol;

    }

    public void move(int row, int col) {
        Random rand = new Random();
        if (Math.abs(row - this.row) > 1 || Math.abs(col - this.col) > 1) {
            this.col = rand.nextInt(8);
            this.row = rand.nextInt(8);
        }else{
            this.row = row;
            this.col = col;
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
