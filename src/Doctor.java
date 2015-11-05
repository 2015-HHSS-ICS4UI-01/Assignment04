
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kampn2687
 */
public class Doctor {
   private int row;
   private int col;
   
   public Doctor(int startRow, int startCol){
       row = startRow;
       col = startCol;
   }
   
   public void move(int row, int col){
     //checks if the mouse is more than one square away
       if((Math.abs(row - this.row)) > 1 || (Math.abs(col - this.col)) > 1 ){
           row = (int)(Math.random()*8);
           col = (int)(Math.random()*8);
       }
       //sets the doctors position to the mouse click
        this.row = row;   
        this.col = col;
   }
   
   public int getRow(){
       //returns the doctors row when called
       return this.row;
   }
   public int getCol(){
       //returns the doctors col when called
       return this.col;
   }
   
}
