/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class is to get the Dalek moving and be able to have the daleks crash into each other, and so that they chase the doctor.
 * @author isles3536
 */
public class Dalek {
    /**
     * These variables are for the Dalek class only, so that they can follow the doctor as well as seeing if they have crashed or not.
     */
    private int row;
    private int col;
    private boolean hasCrashed;
    /**
     * This is the Daleks starting position on the board when the game begins
     * @param startRow The starting row
     * @param startCol The starting column
     */
    public Dalek(int startRow, int startCol){
        row = startRow;
        col = startCol;
        
    }
    /**
     * The Daleks will move towards the doctor
     * @param doc The doctor that they are advancing towards.
     */
    public void advancesTowards(Doctor doc){  
        //if the Dalek has not crashed yet it will move.
     if(hasCrashed == false){
         //The rows and columns of the daleks are adjusted to move towards the doctor in any direction.
        if(row<doc.getRow()){
            row++;
        }
        if(row>doc.getRow()){
            row--;
        }
        if(col<doc.getCol()){
            col++;
        }
        if(col>doc.getCol()){
            col--;
        }
      } 
    }
    /**
     * This is to change the has crashed variable for the Daleks to set it to true, so that the game knows they have crashed
     */
    public void crash(){
        hasCrashed = true;
    }
    /**
     * Is to know if a Dalek has crashed with another Dalek.
     * @return If they have crashed or not 
     */
    public boolean hasCrashed(){
        return hasCrashed;
    }
    /**
     * To get the row of the Dalek access to the game class
     * @return To show the row of the Dalek
     */
    public int getRow(){
        return this.row;
    }
    /**
     * To get the column of the Dalek access to the game class
     * @return To show the column of the Dalek
     */
    public int getCol(){
        return this.col;
    }
    
}
