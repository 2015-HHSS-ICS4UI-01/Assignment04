/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vonhn0812
 */
public class Doctor {
private int row;
private int col;
private boolean hasCrashed;
/**
 * Constructor method
 * @param startRow
 * @param startCol 
 */
public Doctor(int startRow, int startCol){
    row = startRow;
    col = startCol;
    hasCrashed = false;
}
/**
 * Doctor movement and position randomization
 * @param newRow row to move to
 * @param newCol col to move to
 */
   public void move(int newRow, int newCol){
    if(newRow>row+1||newRow<row-1||newCol>col+1||newCol<col-1) {    //if the requested position is farther than one square away
      row = (int) (Math.random() * 8);                              //randomize the position
      col = (int) (Math.random() * 8);
    }else{
        row = newRow;                                               
        col = newCol;
        
    }  
    }
    
   
    /**
     * return row
     * @return 
     */
    public int getRow(){
        return this.row;
}
    /**
     * return col
     * @return 
     */
   public int getCol(){
       return this.col;
    
}
   /**
    * check for doctor - dalek intersection 
    * @param doc
    * @param d 
    */
   public void crash(Doctor doc, Dalek d){
  if(doc.getRow()==d.getRow()&&doc.getCol() == d.getCol()){
      hasCrashed = true;
  }
   }
   /**
    * return if the doctor has crashed or not
    * @return 
    */
  public boolean hasCrashed(){
      return this.hasCrashed;
  }
 }
  

