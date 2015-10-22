
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
    
    private final Color ALIVE_COLOR = Color.GREEN;
    private final Color DEAD_COLOR = Color.BLUE;
    
    private Coordinate coordinate;
    private boolean dead = false;
    
    private Color color;
    
    public Doctor(Coordinate coordinate)
    {
        this.coordinate = coordinate;
        color = ALIVE_COLOR;
    }
    
    public int getRow()
    {
        return coordinate.getRow();
    }
    public int getCol()
    {
        return coordinate.getCol();
    }
    
    public void moveTo(Coordinate coordinate)
    {
        this.coordinate = coordinate;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void die()
    {
        color = DEAD_COLOR;
        dead = true;
    }
    
    public boolean isDead()
    {
        return dead;
    }
}
