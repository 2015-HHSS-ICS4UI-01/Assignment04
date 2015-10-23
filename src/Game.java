
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



        GameBoard catchGame = new GameBoard();
        Doctor walter = new Doctor(5, 5);
        Dalek dalek1 = new Dalek(2, 1);
        Dalek dalek2 = new Dalek(1, 2);
        Dalek dalek3 = new Dalek(1, 1);

        catchGame.putPiece(dalek1.getRow(), dalek1.getCol(), Color.yellow);
        catchGame.putPiece(dalek2.getRow(), dalek2.getCol(), Color.yellow);
        catchGame.putPiece(walter.getRow(), walter.getCol(), Color.green);
        catchGame.printBoard();


        while (true) {
            //wait for the user to click
            Coordinate c = catchGame.getClick();
            int row = c.getRow();
            int col = c.getCol();
            
            catchGame.removePiece(dalek1.getRow(), dalek1.getCol());
            catchGame.removePiece(dalek2.getRow(), dalek2.getCol());
            catchGame.removePiece(walter.getRow(), walter.getCol());
            
            

            walter.move(row, col);
            
            catchGame.putPiece(walter.getRow(), walter.getCol(), Color.green);

            if (!dalek1.hasCrashed()) {
                dalek1.advanceTowards(walter);
            }
            
            if(dalek1.hasCrashed()){
                catchGame.putPiece(dalek1.getRow(), dalek1.getCol(), Color.red);
            }else{
                catchGame.putPiece(dalek1.getRow(), dalek1.getCol(), Color.yellow);
            }
            
            if(!dalek2.hasCrashed()){
                dalek2.advanceTowards(walter);
            }
            
            if(dalek2.hasCrashed()){
                catchGame.putPiece(dalek2.getRow(), dalek2.getCol(), Color.red);
            }else{
                catchGame.putPiece(dalek2.getRow(), dalek2.getCol(), Color.yellow);
            }
            
            dalek1.crash(dalek2);
            dalek2.crash(dalek1);
            dalek1.crash(walter);
            dalek2.crash(walter);


        }

    }
}
