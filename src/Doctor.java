
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
    
    private int row = 0;
    private int col = 0;
    
    private final Color color = Color.GREEN;
    
    public Doctor(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    
    public Color getColor()
    {
        return color;
    }
}
