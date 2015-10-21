
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haidj9901
 */
public class Doctor {

    private int x;
    private int y;
    private Color colour;
    private boolean isCaptured;

    /**
     * Doctor constructor initializes the doctor's starting position
     * @param startX the initial x-coordinate
     * @param startY the initial y-coordinate
     */
    public Doctor(int startX, int startY) {
        x = startX;
        y = startY;
    }

    /**
     * Moves the doctor based on the given x and y coordinates
     * @param newX the x-coordinate of where the mouse was clicked
     * @param newY the y-coordinate of where the mouse was clicked
     */
    public void move(int newX, int newY, int boardWidth, int boardLength) {
        //if the given coordinates are within one tile of the Doctor
        if (Math.abs(newX - x) <= 1 && Math.abs(newY - y) <= 1) { 
            //swap old coordinates with the given coordinates
            x = newX;
            y = newY;
        }
        else //if the given coordinates are not within one tile of the Doctor
        {
            //randomly assign a new position to the Doctor
            x = (int)(Math.random()*boardWidth);
            y = (int)(Math.random()*boardLength);
        }
    }

    /**
     * Method that lets the class know the Doctor has been captured
     */
    public void captured()
    {
        colour = Color.yellow; //set the colour of the doctor to yellow
        isCaptured = true; //set the boolean isCaptured to true
    }
    
    /**
     * return method used to find whether or not the Doctor has been captured
     * @return true if the doctor has been captured, false if the doctor hasn't been captured
     */
    public boolean isCaptured()
    {
        return this.isCaptured;
    }
    
    /**
     * Getter for the x-coordinate
     * @return x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for the y-coordinate
     * @return y coordinate
     */
    public int getY() {
        return y;
    }
}
