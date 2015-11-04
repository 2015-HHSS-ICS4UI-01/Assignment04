/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rainy
 */
public class Doctor {
    
    private int row;
    private int col;
    
    public Doctor(int startRow, int startCol){
        row=startRow;
        col=startCol;
    }
    
    //teleport and move
    public void move(int row, int col){
        if((this.row==row-1||this.row==row||this.row==row+1)&&(this.col==col-1||this.col==col||this.col==col+1)){
        this.row=row;
        this.col=col;
        }
        else{
            this.row=(int)(Math.random()*8);
            this.col=(int)(Math.random()*8);
        }
        
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
}
