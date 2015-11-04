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
    /**
     * used to move the doctor is the new point is within one tile away from the doctor, 
     * otherwise it is a randomized position on the board
     * @param row the row on the gameboard that the doctor is in
     * @param col the colum on the gameboard that the doctor is in
     */
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
    
    /**
     * 
     * @return the row that the doctor is in on the gameboard
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * 
     * @return the colum that the doctor is in on the gameboard
     */
    public int getCol(){
        return this.col;
    }
}
