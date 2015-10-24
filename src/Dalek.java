
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
    private Color color;
    
    private Coordinate coordinate;
    private boolean crashed = false;
    
    public Dalek(Coordinate coordinate)
    {
        this.coordinate = coordinate;
        // dalek should start as alive
        color = ALIVE_COLOR;
    }
    /**
     * Returns the current color of the Dalek
     * @return 
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
        this.coordinate = coordinate;
    }
    /**
     * Gives the Dalek's current row number
     * @return row
     */
    public int getRow()
    {
        return coordinate.getRow();
    }
    /**
     * Gives the Dalek's current column number
     * @return col
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
