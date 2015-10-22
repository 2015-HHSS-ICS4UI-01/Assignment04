
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kobed6328
 */
public class Dalek {
    
    private final Color CRASH_COLOR = Color.RED;
    private final Color ALIVE_COLOR = Color.ORANGE;
    
    private Coordinate coordinate;
    private Color color;
    private boolean crashed = false;
    
    public Dalek(Coordinate coordinate)
    {
        this.coordinate = coordinate;
        color = ALIVE_COLOR;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void moveTo(Coordinate coordinate)
    {
        this.coordinate = coordinate;
    }
    
    public int getRow()
    {
        return coordinate.getRow();
    }
    public int getCol()
    {
        return coordinate.getCol();
    }
    
    public boolean hasCrashed()
    {
        return crashed;
    }
    public void crash()
    {
        color = CRASH_COLOR;
        crashed = true;
    }
}
