
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
        int row = (int) (Math.random() * 8);
        int col = (int) (Math.random() * 8);

        Dalek[] dlks = new Dalek[3];
        for (int i = 0; i < dlks.length; i++) {
            dlks[i] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
        }

        while ((row == dlks[0].getRow()) && (col == dlks[0].getCol()) || (row == dlks[1].getRow())
                && (col == dlks[1].getCol()) || (row == dlks[2].getRow()) && (col == dlks[2].getCol())) {
            dlks[0] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
            dlks[1] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
            dlks[2] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));

        }

        Doctor who = new Doctor(row, col);

        GameBoard game = new GameBoard();
        game.putPiece(row, col, Color.GREEN);
        game.putPiece(dlks[0].getRow(), dlks[0].getCol(), Color.YELLOW);
        game.putPiece(dlks[1].getRow(), dlks[1].getCol(), Color.YELLOW);
        game.putPiece(dlks[2].getRow(), dlks[2].getCol(), Color.YELLOW);



        while (true) {
            // wait for user to click
            Coordinate c = game.getClick();
            game.removePiece(dlks[0].getRow(), dlks[0].getCol());
            game.removePiece(dlks[1].getRow(), dlks[1].getCol());
            game.removePiece(dlks[2].getRow(), dlks[2].getCol());
            game.removePiece(row, col);






            //figure out where they click
            row = c.getRow();
            col = c.getCol();

            //put piece

            who.move(row, col);

            row = who.getRow();
            col = who.getCol();
            game.putPiece(row, col, Color.GREEN);
            
            for(int i= 0; i < dlks.length; i++){
                if(!dlks[i].hasCrashed()){
                    
                
                dlks[i].advanceTowards(who);
                }
                
            }
            
          

            
            game.putPiece(dlks[0].getRow(), dlks[0].getCol(), Color.YELLOW);

            game.putPiece(dlks[1].getRow(), dlks[1].getCol(), Color.YELLOW);

            game.putPiece(dlks[2].getRow(), dlks[2].getCol(), Color.YELLOW);

        }
    }
}
