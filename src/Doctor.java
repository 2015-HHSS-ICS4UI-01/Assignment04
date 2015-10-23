
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
        if (row >= this.row + 2 || row <= this.row - 2 ||col >= this.col + 2 || col <= this.col - 2) {
            col = rand.nextInt(8);
            row = rand.nextInt(8);
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
