
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
        //makes row the starting row of the doctor(player) random
        int row = (int) (Math.random() * 8);
        //makes the starting col of the doctor(player) random
        int col = (int) (Math.random() * 8);
        //make sure the game is not in its gameover state
        boolean gameover = false;

        //makes 3 daleks
        Dalek[] dlks = new Dalek[3];
        
        //makes random spawn locations for daleks and makes it not spawn on the doctor
        for (int i = 0; i < dlks.length; i++) {
            dlks[i] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
        }

        while ((row == dlks[0].getRow()) && (col == dlks[0].getCol()) || (row == dlks[1].getRow())
                && (col == dlks[1].getCol()) || (row == dlks[2].getRow()) && (col == dlks[2].getCol())) {
            dlks[0] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
            dlks[1] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
            dlks[2] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));

        }
        
        //makes a new doctor named who
        Doctor who = new Doctor(row, col);
         //checks to see if the daleks are ont top of eachother and crashes them if they are
        for (int i = 0; i < dlks.length - 1; i++) {
                for (int j = i + 1; j < dlks.length; j++) {
                    if (dlks[i].getRow() == dlks[j].getRow() && dlks[i].getCol() == dlks[j].getCol()) {
                        dlks[i].crash();
                        dlks[j].crash();
                    }
                }
            }
        //creates the game board and names it agme
        GameBoard game = new GameBoard();
        //places the doctor
        game.putPiece(row, col, Color.GREEN);
          for (int i = 0; i < dlks.length; i++) {
                if (!dlks[i].hasCrashed()) {
                    game.putPiece(dlks[i].getRow(), dlks[i].getCol(), Color.YELLOW);
                } else {
                    game.putPiece(dlks[i].getRow(), dlks[i].getCol(), Color.RED);
                }


            }
        



        while (!gameover) {
            // wait for user to click
            Coordinate c = game.getClick();

            for (int i = 0; i < dlks.length; i++) {
                game.removePiece(dlks[i].getRow(), dlks[i].getCol());
            }
            game.removePiece(row, col);

            //figure out where they click
            row = c.getRow();
            col = c.getCol();
            //initiates move for the doctor
            who.move(row, col);
            //sets the row and col as the doctors row and col
            row = who.getRow();
            col = who.getCol();
            //places the doctor
            game.putPiece(row, col, Color.GREEN);
            //initiates move for all of the daleks
            for (int i = 0; i < dlks.length; i++) {
                if (!dlks[i].hasCrashed()) {


                    dlks[i].advanceTowards(who);
                }

            }
            //checks if all of the daleks have crashed
            for (int i = 0; i < dlks.length - 1; i++) {
                for (int j = i + 1; j < dlks.length; j++) {
                    if (dlks[i].getRow() == dlks[j].getRow() && dlks[i].getCol() == dlks[j].getCol()) {
                        dlks[i].crash();
                        dlks[j].crash();
                    }
                }
            }

            //places the daleks if they are not crashed
            for (int i = 0; i < dlks.length; i++) {
                if (!dlks[i].hasCrashed()) {
                    game.putPiece(dlks[i].getRow(), dlks[i].getCol(), Color.YELLOW);
                } else {
                    game.putPiece(dlks[i].getRow(), dlks[i].getCol(), Color.RED);
                }


            }
            //ends game if doctor dies and displays message 
            for (int i = 0; i < dlks.length; i++) {
                if (who.getRow() == dlks[i].getRow() && who.getCol() == dlks[i].getCol()) {
                    gameover = true;
                    game.setMessage("You have been captured!!! uh oh");
                    game.putPiece(who.getRow(), who.getCol(), Color.blue);
                }
            }
            //ends game if all dalek crash and displays message
            if (!gameover) {
                if (dlks[0].hasCrashed() && dlks[1].hasCrashed() && dlks[2].hasCrashed()) {
                    game.setMessage("You have defeated all of the Daleks!!");
                    gameover = true;
                }
            }
        }
    }
}
