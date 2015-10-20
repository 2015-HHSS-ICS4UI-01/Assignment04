
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
        GameBoard board = new GameBoard();
        Doctor doctor = new Doctor((int) (Math.random()*8), (int) (Math.random()*8));
        Dalek dalek1 = new Dalek((int) (Math.random()*8), (int) (Math.random()*8));
        Dalek dalek2 = new Dalek((int) (Math.random()*8), (int) (Math.random()*8));
        Dalek dalek3 = new Dalek((int) (Math.random()*8), (int) (Math.random()*8));
        
        board.putPiece(doctor.getRow(), doctor.getCol(), Color.GREEN);
        board.putPiece(dalek1.getRow(), dalek1.getRow(), Color.BLUE);
        board.putPiece(dalek2.getRow(), dalek2.getRow(), Color.BLUE);
        board.putPiece(dalek3.getRow(), dalek3.getRow(), Color.BLUE);
        
        boolean moved = false;
        while(!moved){
            
        }
    }
}
