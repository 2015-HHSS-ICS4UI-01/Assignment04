/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janaj4926
 */
public class Dalek {
    private int x;
    private int y;
    private boolean hasCrashed;
    
    public Dalek(int startRow, int startCol){
        x = startRow;
        y = startCol;
        hasCrashed = false;
    }
    
    public void advanceTowards(Doctor doc){
        if (doc.getX() > x){
            x++;
        }else if(doc.getX() < x){
            x--;
        }
        if (doc.getY() > y){
            y++;
        }else if (doc.getY() < y){
            y--;
        }
    }
    
    public void crash(){
        hasCrashed = true;
    }
    
    public boolean hasCrashed(){
        return hasCrashed;
    }
    
    public int getRow(){
        return this.x;
    }
    
    public int getCol(){
        return this.y;
    }
}
