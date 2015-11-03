
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johns6971
 */
public class Doctor {
    
    private int row;
    private int col;
    
    /**
     * Stores the initial row and col values
     * @param startRow the row at which the doctor starts
     * @param startCol the col at which the doctor starts
     */
    public Doctor(int startRow, int startCol) {
        row = startRow;
        col = startCol;  
    }
    
    /**
     * Takes the row and col values from the main class and makes those values the doc's values 
     * @param row the row that the doctor wants to move to
     * @param col the col that the doctor wants to move to
     */
    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    /**
     * Randomizes the row and col values and changes the doctor's location to those values
     * @param row the row of the doctor
     * @param col the col of the doctor
     */
    public void teleport(int row, int col) {
        int min = 0;
        int max = 7; 
        row = random(min, max);
        col = random(min, max);
        this.row = row;
        this.col = col;
    }
    
    /**
     * 
     * @return the row of the doctor
     */
    public int getRow() {
        return this.row;
    }
    /**
     * 
     * @return the col of the doctor
     */
    public int getCol() {
        return this.col;
    }
    /**
     * 
     * @param min minimum possible value on the board (0)
     * @param max the maximum possible value on the board (7)
     * @return the random number
     */
    private int random(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
            
}
