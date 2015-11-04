/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alimu
 */
public class Doctor {
    private int x;
    private int y;
    
    /**
     * 
     * @param startx
     * @param starty 
     */
    public Doctor(int startx, int starty){
        //the strarting position of the doctor
        x = startx;
        y = starty;
    }
    
    /**
     * 
     * @param mx
     * @param my 
     */
    public void move(int mx, int my){
        //if the click is more than one spot than beside the doctor, randomize the position
        if(mx > this.x + 1 || mx < this.x -1 || my > this.y +1 || my < this.y-1){
            this.x = (int)(Math.random()*8);
            this.y = (int)(Math.random()*8);
        }else{
        //if the player clicks in a spot immediatly beside the doctor, move there
       this.x = mx;
       this.y = my;
    }
    }
    
    /**
     * gets row of the doctor
     * @return the row of the doctor
     */
    public int getx(){
        //return the doctors row
        return this.x;
    }
    
    /**
     * gets column of the doctor
     * @return the column of the doctor
     */
    public int gety(){
        //return the doctors column
        return this.y;
    }
}
