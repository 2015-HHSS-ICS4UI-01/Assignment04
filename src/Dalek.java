
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The enemy of the Doctor
 * @author kobed6328
 */
public class Dalek {
    
    // colors of the dalek in its dead and alive states
    private final Color CRASH_COLOR = Color.RED;
    private final Color ALIVE_COLOR = Color.BLACK;
    // the Daleks' current doctor
    private Color color;
    // the Dalek's current coordinates
    private Coordinate coordinate;
    // the Daleks'c crashed state
    private boolean crashed = false;
    
    /**
     * Sets the Dalek's coordinates and color
     * @param coordinate the Dalek's initial coordinates
     */
    public Dalek(Coordinate coordinate)
    {
        this.coordinate = coordinate;
        // Dalek should start as alive
        color = ALIVE_COLOR;
    }
    /**
     * Returns the current color of the Dalek
     * @return the Dalek's current color
     */
    public Color getColor()
    {
        return color;
    }
    /**
     * Moves the Dalek to specified coordinates
     * @param coordinate the coordinates to which the Dalek is moved
     */
    public void moveTo(Coordinate coordinate)
    {
        // replace the current coordinates with new ones
        this.coordinate = coordinate;
    }
    /**
     * Gives the Dalek's current row number
     * @return the coordinate's row
     */
    public int getRow()
    {
        return coordinate.getRow();
    }
    /**
     * Gives the Dalek's current column number
     * @return the coordinate's column
     */
    public int getCol()
    {
        return coordinate.getCol();
    }
    /**
     * Indicates whether or not the Dalek has crashed or not
     * @return true, if the Dalek has crashed; otherwise, false
     */
    public boolean hasCrashed()
    {
        return crashed;
    }
    /**
     * Crashes the current Dalek
     */
    public void crash()
    {
        // sets crashed state to true, and updates the Dale's color
        color = CRASH_COLOR;
        crashed = true;
    }
}
