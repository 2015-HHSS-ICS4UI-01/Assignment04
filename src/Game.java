
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int row = (int)(Math.random() *8);
        int col = (int)(Math.random() *8);
        Doctor who = new Doctor (row,col);
        GameBoard game = new GameBoard();
        game.putPiece(row,col,Color.GREEN);
    while(true){
            // wait for user to click
        Coordinate c = game.getClick();
        game.removePiece(row,col);        
        //figure out where they click
        row = c.getRow();
        col = c.getCol();
        
        //put piece
        
        who.move(row, col);
        row = who.getRow();
        col = who.getCol();
    
        game.putPiece(row,col,Color.GREEN);
        
    }
    }
    
}
