
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author donet6376
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Draws the game board
        GameBoard board = new GameBoard();
        
        //Initial spawn points and drawing of The Doctor and 3 Daleks
        Doctor who = new Doctor((int)(Math.random()*8),(int)(Math.random()*8));
        board.putPiece(who.getRow(), who.getCol(), Color.GREEN);  
        Dalek d1 = new Dalek((int)(Math.random()*8),(int)(Math.random()*8));
        board.putPiece(d1.getRow(), d1.getCol(), d1.getColor());
        Dalek d2 = new Dalek((int)(Math.random()*8),(int)(Math.random()*8));
        board.putPiece(d2.getRow(), d2.getCol(), d2.getColor());
        Dalek d3 = new Dalek((int)(Math.random()*8),(int)(Math.random()*8));
        board.putPiece(d3.getRow(), d3.getCol(), d3.getColor());
        
        //Game logic runs until Doctor wins or is captured
        while(true)
        {
        //Dalek 1 and Dalek 2 crash
        if(d1.getRow()==d2.getRow() && d1.getCol()==d2.getCol()){
            d1.crash();
            d2.crash();
        }
        //Dalek 1 and Dalek 3 crash
        if(d1.getRow()==d3.getRow() && d1.getCol()==d3.getCol()){
            d1.crash();
            d3.crash();
        }
        //Dalek 2 and Dalek 3 crash
        if(d2.getRow()==d3.getRow() && d2.getCol()==d3.getCol()){
            d2.crash();
            d3.crash();
        }
        //Draw Daleks to update if crashed
        board.putPiece(d1.getRow(), d1.getCol(), d1.getColor());
        board.putPiece(d2.getRow(), d2.getCol(), d2.getColor());
        board.putPiece(d3.getRow(), d3.getCol(), d3.getColor()); 
        
        //Dalek 1 captures the doctor
        if(who.getRow()==d1.getRow() && who.getCol()==d1.getCol()){
            board.removePiece(who.getRow(),who.getCol());
            board.putPiece(who.getRow(),who.getCol(),Color.BLUE);
            board.setMessage("You Have Been Captured!");
            break;
        // Dalek 2 captures The Doctor
        }else if(who.getRow()==d2.getRow() && who.getCol()==d2.getCol()){
            board.removePiece(who.getRow(),who.getCol());
            board.putPiece(who.getRow(),who.getCol(),Color.BLUE);
            board.setMessage("You Have Been Captured!");
            break;
        //Dalek 3 captures The Doctor
        }else if(who.getRow()==d3.getRow() && who.getCol()==d3.getCol()){
            board.removePiece(who.getRow(),who.getCol());
            board.putPiece(who.getRow(),who.getCol(),Color.BLUE);
            board.setMessage("You Have Been Captured!");
            break;
        //The Doctor Wins
        }else if(d1.hasCrashed() && d2.hasCrashed() && d3.hasCrashed()){
            board.setMessage("You Have Won!");
            break;
        }
        //The click to determine The Doctors' movement
        Coordinate c = board.getClick();
        board.removePiece(who.getRow(), who.getCol());
        who.move(c.getRow(), c.getCol());
        board.putPiece(who.getRow(), who.getCol(), Color.GREEN);
        
        //Determine Dalek 1's Movement
        if(d1.hasCrashed() == false){
            board.removePiece(d1.getRow(), d1.getCol());
            d1.advanceTowards(who);
        }
        //Determine Dalek 2's Movement
        if(d2.hasCrashed() == false){
            board.removePiece(d2.getRow(), d2.getCol());
            d2.advanceTowards(who);
        }
        //Determine Dalek 3's Movement
        if(d3.hasCrashed() == false){
            board.removePiece(d3.getRow(), d3.getCol());
            d3.advanceTowards(who);
        }
        
        //Draw Daleks to update movement
        board.putPiece(d1.getRow(), d1.getCol(), d1.getColor());
        board.putPiece(d2.getRow(), d2.getCol(), d2.getColor());
        board.putPiece(d3.getRow(), d3.getCol(), d3.getColor()); 
        }
        
    }
}
