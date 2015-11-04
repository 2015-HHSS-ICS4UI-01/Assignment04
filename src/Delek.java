/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rainy
 */
public class Delek {
    
    private int row;
    private int col;
    private boolean hasCrashed;
    
    public Delek(int startRow, int startY){
        this.row = startRow;
        this.col = startY;
        hasCrashed=false;
    }
    
    public void advanceTowards(Doctor doc){
        if(doc.getCol()>col)
            this.col++;
        else if(doc.getCol()<col)
            this.col--;
        if(doc.getRow()>row)
            this.row++;
        else if(doc.getRow()<row)
            this.row--;
    }
    
    public  void crash(){
        hasCrashed=true;
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public boolean getCrash(){
        return hasCrashed;
    }
    
}
