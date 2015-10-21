
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
        GameBoard board = new GameBoard();
        
        Doctor who = new Doctor((int)(Math.random()*8),(int)(Math.random()*8));
        board.putPiece(who.getRow(), who.getCol(), Color.GREEN);  
        Dalek d1 = new Dalek((int)(Math.random()*8),(int)(Math.random()*8));
        board.putPiece(d1.getRow(), d1.getCol(), d1.getColor());
        Dalek d2 = new Dalek((int)(Math.random()*8),(int)(Math.random()*8));
        board.putPiece(d2.getRow(), d2.getCol(), d2.getColor());
        Dalek d3 = new Dalek((int)(Math.random()*8),(int)(Math.random()*8));
        board.putPiece(d3.getRow(), d3.getCol(), d3.getColor());
        
        
        
        
        while(true)
        {
        if(d1.getRow()==d2.getRow() && d1.getCol()==d2.getCol()){
            d1.crash();
            d2.crash();
        }
        if(d1.getRow()==d3.getRow() && d1.getCol()==d3.getCol()){
            d1.crash();
            d3.crash();
        }
        if(d2.getRow()==d3.getRow() && d2.getCol()==d3.getCol()){
            d2.crash();
            d3.crash();
        }
        
        board.putPiece(d1.getRow(), d1.getCol(), d1.getColor());
        board.putPiece(d2.getRow(), d2.getCol(), d2.getColor());
        board.putPiece(d3.getRow(), d3.getCol(), d3.getColor()); 
        
        if(who.getRow()==d1.getRow() && who.getCol()==d1.getCol()){
            board.removePiece(who.getRow(),who.getCol());
            board.putPiece(who.getRow(),who.getCol(),Color.BLUE);
            board.setMessage("You Have Been Captured!");
            break;
        }else if(who.getRow()==d2.getRow() && who.getCol()==d2.getCol()){
            board.removePiece(who.getRow(),who.getCol());
            board.putPiece(who.getRow(),who.getCol(),Color.BLUE);
            board.setMessage("You Have Been Captured!");
            break;
        }else if(who.getRow()==d3.getRow() && who.getCol()==d3.getCol()){
            board.removePiece(who.getRow(),who.getCol());
            board.putPiece(who.getRow(),who.getCol(),Color.BLUE);
            board.setMessage("You Have Been Captured!");
            break;
        }else if(d1.hasCrashed() && d2.hasCrashed() && d3.hasCrashed()){
            board.setMessage("You Have Won!");
            break;
        }
            
        Coordinate c = board.getClick();
        board.removePiece(who.getRow(), who.getCol());
        who.move(c.getRow(), c.getCol());
        board.putPiece(who.getRow(), who.getCol(), Color.GREEN);
        
        if(d1.hasCrashed() == false){
            board.removePiece(d1.getRow(), d1.getCol());
            d1.advanceTowards(who);
        }
        if(d2.hasCrashed() == false){
            board.removePiece(d2.getRow(), d2.getCol());
            d2.advanceTowards(who);
        }
        if(d3.hasCrashed() == false){
            board.removePiece(d3.getRow(), d3.getCol());
            d3.advanceTowards(who);
        }

        board.putPiece(d1.getRow(), d1.getCol(), d1.getColor());
        board.putPiece(d2.getRow(), d2.getCol(), d2.getColor());
        board.putPiece(d3.getRow(), d3.getCol(), d3.getColor()); 

        }
        
    }
}
