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
    
    /**
     * used to move the dalek toward the doctor
     * @param doc the doctor used in the game class
     */
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
    
    /**
     * whether the dalek has crashed or not
     */
    public  void crash(){
        hasCrashed=true;
    }
    
    /**
     * 
     * @return the row that the dalek is in currently on the board
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * 
     * @return the colum that the dalek is in currently on the board
     */
    public int getCol(){
        return this.col;
    }
    
    /**
     * 
     * @return whether the dalek has crashed or not
     */
    public boolean getCrash(){
        return hasCrashed;
    }
    
}
