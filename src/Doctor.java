
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kobed6328
 */
public class Doctor{
    
    // colors of the Doctor in its dead and alive states
    private final Color ALIVE_COLOR = Color.GREEN;
    private final Color DEAD_COLOR = Color.YELLOW;
    // the Doctor's current color
    private Color color;
    // the Doctor's current coordinates
    private Coordinate coordinate;
    // the Doctor's dead state
    private boolean dead = false;
    
    /**
     * Sets the Doctor's coordinates and color
     * @param coordinate the Doctor's initial coordinates
     */
    public Doctor(Coordinate coordinate)
    {
        this.coordinate = coordinate;
        // the Doctor should start as alive
        color = ALIVE_COLOR;
    }
    /**
     * Gives the Doctor's current row
     * @return the coordinate's row
     */
    public int getRow()
    {
        return coordinate.getRow();
    }
    /**
     * Gives the Doctor's current column
     * @return the coordinate's column
     */
    public int getCol()
    {
        return coordinate.getCol();
    }
    /**
     * Moves the Doctor to specified coordinates
     * @param coordinate the coordinates to move to
     */
    public void moveTo(Coordinate coordinate)
    {
        // replace the current coordinates with new ones
        this.coordinate = coordinate;
    }
    /**
     * Gives the Doctor's current color
     * @return color
     */
    public Color getColor()
    {
        return color;
    }
    /**
     * Kills the Doctor
     */
    public void die()
    {
        // sets the current color to the dead color, and updates the dead state
        color = DEAD_COLOR;
        dead = true;
    }
    /**
     * Gives the Doctor's current dead state
     * @return true if the Doctor is dead; otherwise, return false
     */
    public boolean isDead()
    {
        return dead;
    }
}
