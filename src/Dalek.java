
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author haidj9901
 */
public class Dalek {

    private int x;
    private int y;
    private boolean hasCrashed;
    private Color colour;

    /**
     * Dalek constructor used to initialize starting position and color
     * @param startX the initial x-coordinate of the dalek
     * @param startY the initial y-coordinate of the dalek
     */
    public Dalek(int startX, int startY) {
        x = startX;
        y = startY;
        colour = Color.yellow;
    }

    /**
     * Moves one space towards the doctor in terms of both the x and y positions
     * @param doc the doctor to be moved towards
     */
    public void moveTowards(Doctor doc) {
        if (!hasCrashed) { //move only if the dalek hasn't crashed
            if (doc.getX() > x) { //if the doctor's x-coordinate is less than the Dalek's
                x++; //increase the dalek's x position
            } else if (doc.getX() < x) { //if the doctor's x-coordinate is greater than the Dalek's
                x--; //decrease the dalek's x position
            }
            
            //adjust the Dalek's coordinates to get closer to the doctor (see above comemnts)
            if (doc.getY() > y) {
                y++;
            } else if (doc.getY() < y) {
                y--;
            }
        }
    }

    /**
     * Getter for the colour of the Dalek
     * @return the colour of the dalek
     */
    public Color getColour() {
        return this.colour;
    }

    /**
     * Tells the Dalek class that the dalek has crashed
     */
    public void crash() {
        hasCrashed = true; 
        colour = Color.red; //colour is set to red in order to show that the Dalek is crashed
    }

    /**
     * Getter for whether or not the Dalek has crashed yet
     * @return hasCrashed variable
     */
    public boolean hasCrashed() {
        return this.hasCrashed;
    }

    /**
     * Getter for the x-coordinate
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for the y-coordinate
     * @return y
     */
    public int getY() {
        return y;
    }
}
