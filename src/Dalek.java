
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
    
    private int row = 0;
    private int col = 0;
    private final Color color = Color.ORANGE;
    
    public Dalek(Coordinate coordinate)
    {
        this.row = coordinate.getRow();
        this.col = coordinate.getCol();
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
}
