/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alimu
 */
public class Dalek {
    private int x;
    private int y;
    private boolean hasCrashed;
    
    /**
     * 
     * @param startx
     * @param starty 
     */
    public Dalek(int startx, int starty){
        //they have not crashed to start off
        hasCrashed = false;
        //the daleks starting position
        x = startx;
        y = starty;
    }
    
    /**
     * 
     * @param doc 
     */
    public void advanceTowards(Doctor doc){
        //if the dalek hasnt crashed
        if(hasCrashed == false){
        //get the doctors postion
        int docx = doc.getx();
        int docy = doc.gety();
        
        //if the doctors row is greater than daleks row
        if(docx > this.x)
        {
            //the dalek right on the board
            this.x = x+1;
        }else if(docx< this.x) //if the doctors row is less than that daleks row
        {
            //the dalek moves left on the board
            this.x = x-1;
        }
        
        //if the doctors column is greater than daleks column
        if(docy > this.y)
        {
            //the dalek moves down the board
            this.y = y+1;
        }else if(docy < this.y) //if the doctors column is less than daleks column
        {
            //the dalek moves down the board
            this.y =y-1;
        }
    }
    }
    public void crash(){
        //the dalek has crashed
        hasCrashed = true;
    }
    
    public boolean hasCrashed(){
        //return that the dalek has crashed
        return hasCrashed;
    }
    
    /**
     * get the row of the doctor
     * @return the row
     */
    public int getx(){
        //return the daleks row
        return this.x;
    }
    
    /**
     * get the column of the doctor
     * @return the column 
     */
    public int gety(){
        //return the daleks column
        return this.y;
    }
        
}
