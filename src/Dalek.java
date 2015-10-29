/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vonhn0812
 */
public class Dalek {
 private int row;
 private int col;
 private boolean hasCrashed;
 private boolean docCrash;
 /**
  * Constructor method
  * @param startRow
  * @param startCol 
  */
 public Dalek(int startRow, int startCol){
     row = startRow;        //start row
     col = startCol;        //start col
     hasCrashed = false;    //hasn't crashed
     docCrash = false;
}
 /**
  * Dalek movement logic towards doctor
  * @param doc doctor
  */
 public void advanceTowards(Doctor doc){
    int docCol = doc.getCol();
    int docRow = doc.getRow();
   if(!hasCrashed){
    if(row<docRow){
        row++;
    }else if(row>docRow){
        row--;
    }
    
    if(col<docCol){
        col++;
    }else if(col>docCol){
        col--;
    }
   }
}
 /**
  * return the dalek row
  * @return 
  */
 public int getRow(){
   return this.row;  
 }
 /**
  * return the dalek col
  * @return 
  */
 public int getCol(){
   return this.col;
 }
 /**
  * Check for doctor - Dalek intersection 
  * @param doc doctor
  * @param a dalek
  */
 public void crashDoc(Doctor doc,Dalek a){
 if(doc.getRow()==a.getRow()&& doc.getCol()==a.getCol())    
  hasCrashed = true;
  
 }
 /**
  * Check for dalek - dalek intersection
  * @param a dalek 1
  * @param b dalek 2
  */
 public void crash(Dalek a, Dalek b){
  if(a.getRow()==b.getRow()&&a.getCol() == b.getCol()){
      hasCrashed = true;
  }   
 }
 /**
  * return if the dalek has crashed
  * @return 
  */        
 public boolean hasCrashed(){
  return this.hasCrashed;   
 }
 
 
}
