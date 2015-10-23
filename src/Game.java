
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
        
        //creates the gameboard to work on
        GameBoard board = new GameBoard();
        
        //creates the pegs for the daleks and the doctor
        Dalek one = new Dalek(dalRow1, dalCol1);
        Dalek two = new Dalek(dalRow2, dalCol2);
        Dalek three = new Dalek(dalRow3, dalCol3);
        Doctor nima = new Doctor(docRow, docCol);
                      
        //randomly spawns the daleks and the doctor
        board.putPiece(nima.getRow(), nima.getCol() , Color.BLUE);
        board.putPiece(one.getRow(), one.getCol(), Color.RED);
        board.putPiece(dalRow2, dalCol2, Color.RED);
        board.putPiece(dalRow3, dalCol3, Color.RED);
        
        while(true){
        
        //makes the doctor move and do his thing
        Coordinate click = board.getClick();
        
        //removes all the pieces after a click
        board.removePiece(nima.getRow(), nima.getCol());
        board.removePiece(one.getRow(), one.getCol());
        board.removePiece(two.getRow(), two.getCol());
        board.removePiece(three.getRow(), three.getCol());
        
        //moves the doctor
        nima.move(click.getRow(), click.getCol());
        board.putPiece(nima.getRow(), nima.getCol() , Color.BLUE);
        
        //moving the daleks
        one.advanceTowards(nima);
        board.putPiece(one.getRow(), one.getCol() , Color.RED);
        two.advanceTowards(nima);
        board.putPiece(two.getRow(), two.getCol() , Color.RED);
        three.advanceTowards(nima);
        board.putPiece(three.getRow(), three.getCol() , Color.RED);
        }
        
    }
}
