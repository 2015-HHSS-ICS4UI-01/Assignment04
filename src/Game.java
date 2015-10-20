
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
    public static void main(String[] args) throws InterruptedException {
        
        GameBoard board = new GameBoard(8, 8);
        
        final int numDaleks = 3;
        Dalek[] daleks = new Dalek[numDaleks];
        spawnDaleks(daleks, board);
        
        boolean gameon = true;
        while (gameon)
        {
            Coordinate clickPoint = board.getClick();
            board.putPiece(clickPoint.getRow(), clickPoint.getCol(), Color.RED);
        }
        
    }
    
    /**
     * Adds all the daleks to the daleks array, at a random row and col
     * @param daleks the array to be populated with daleks
     * @param board the board to which the daleks should be added
     */
    public static void spawnDaleks(Dalek[] daleks, GameBoard board)
    {
        // spawn each dalek in a random location
        for (int i = 0; i < daleks.length; i ++)
        {
            daleks[i] = new Dalek((int)(Math.random()*board.getWidth()), (int)(Math.random()*board.getHeight()));
        }
    }
    
}
