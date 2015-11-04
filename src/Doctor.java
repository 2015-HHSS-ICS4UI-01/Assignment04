/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rayan4858
 */
public class Doctor {
   private int row;
   private int col;
   /**
    * 
    * @param startRow
    * @param startCol 
    */
   public Doctor(int startRow, int startCol){
       row = startRow;
       col = startCol;
       
   }
   
   /**
    * 
    * @param row 
    * @param col 
    */
   public void move(int row, int col){
       row = this.col;
       col = this.col;
   }
   
   /**
    * Gets row of doctor
    * @return Returns the row of the Doc
    */
   public int getRow(){
       return this.row;
   }
   
   /**
    * Gets the Colum of the Doc 
    * @return Returns the colum of the Doc
    */
   public int getCol(){
       return this.col;
   }
   
   
   
}
