/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janaj4926
 */
public class Doctor {
    private int x;
    private int y;
    
    public Doctor(int startRow, int startCol){
        x = startRow;
        y = startCol;
    }
    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}
