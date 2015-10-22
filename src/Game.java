
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamonta
 */
public class Game {
    
    public static void main(String[] args) {
        //initiates the doctors coordinates
        int docRow = (int)(Math.random()*8); 
        int docCol = (int)(Math.random()*8); 
        
        //initiates the daleks coordinates
        int dalRow1 = (int)(Math.random()*8); 
        int dalCol1 = (int)(Math.random()*8); 
        int dalRow2 = (int)(Math.random()*8); 
        int dalCol2 = (int)(Math.random()*8); 
        int dalRow3 = (int)(Math.random()*8); 
        int dalCol3 = (int)(Math.random()*8); 
        
        
        GameBoard board = new GameBoard();
        
        Dalek one = new Dalek(dalRow1, dalCol1);
        Dalek two = new Dalek(dalRow2, dalCol2);
        Dalek three = new Dalek(dalRow3, dalCol3);
        Doctor nima = new Doctor(docRow, docCol);
              
        
        
        
        board.putPiece(nima.getRow(), nima.getCol() , Color.BLUE);
        
        
        
        board.putPiece(one.getRow(), one.getCol(), Color.YELLOW);
        board.putPiece(dalRow2, dalCol2, Color.YELLOW);
        board.putPiece(dalRow3, dalCol3, Color.YELLOW);
        
        Coordinate click = board.getClick();
        nima.move(click.getRow(), click.getCol());
        
        board.putPiece(nima.getRow(), nima.getCol() , Color.BLUE);
        
        
        
        
    }
}
