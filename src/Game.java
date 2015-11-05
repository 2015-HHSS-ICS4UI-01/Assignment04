
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
        //start the daleks and walter on a random row and column
        int walterRow = (int) (Math.random() * 8);
        int walterCol = (int) (Math.random() * 8);

        int d1Row = (int) (Math.random() * 8);
        int d1Col = (int) (Math.random() * 8);

        int d2Row = (int) (Math.random() * 8);
        int d2Col = (int) (Math.random() * 8);

        int d3Row = (int) (Math.random() * 8);
        int d3Col = (int) (Math.random() * 8);

        //if walter spawns on one of the daleks start on a different row and column
        while (walterRow == d1Row || walterRow == d2Row || walterRow == d3Row) {
            walterRow = (int) (Math.random() * 8);
        }
        while (walterCol == d1Col || walterCol == d2Col || walterCol == d3Col) {
            walterCol = (int) (Math.random() * 8);
        }

        //if dalek1 spawns on one of the daleks or walter start on a different row and column
        while (d1Row == walterRow || d1Row == d2Row || d1Row == d3Row) {
            d1Row = (int) (Math.random() * 8);
        }
        while (d1Col == walterCol || d1Col == d2Col || d1Col == d3Col) {
            d1Col = (int) (Math.random() * 8);
        }

        //if dalek2 spawns on one of the daleks or walter start on a different row and column
        while (d2Row == d1Row || d2Row == walterRow || d2Row == d3Row) {
            d2Row = (int) (Math.random() * 8);
        }
        while (d2Col == d1Col || d2Col == walterCol || d2Col == d3Col) {
            d2Col = (int) (Math.random() * 8);
        }

        //if dalek3 spawns on one of the daleks or walter start on a different row and column
        while (d3Row == d1Row || d3Row == d2Row || d3Row == walterRow) {
            d3Row = (int) (Math.random() * 8);
        }
        while (d3Col == d1Col || d3Col == d2Col || d3Col == walterCol) {
            d3Col = (int) (Math.random() * 8);
        }

        // create the daleks and the doctor
        Doctor walter = new Doctor(walterRow, walterCol);
        Dalek dalek1 = new Dalek(d1Row, d1Col);
        Dalek dalek2 = new Dalek(d2Row, d2Col);
        Dalek dalek3 = new Dalek(d3Row, d3Col);

        // place the daleks and the doctors on the board
        catchGame.putPiece(dalek1.getRow(), dalek1.getCol(), Color.yellow);
        catchGame.putPiece(dalek2.getRow(), dalek2.getCol(), Color.yellow);
        catchGame.putPiece(dalek3.getRow(), dalek3.getCol(), Color.yellow);
        catchGame.putPiece(walter.getRow(), walter.getCol(), Color.green);
        catchGame.printBoard();


        while (true) {
            //wait for the user to click
            Coordinate c = catchGame.getClick();
            int row = c.getRow();
            int col = c.getCol();

            catchGame.removePiece(dalek1.getRow(), dalek1.getCol());
            catchGame.removePiece(dalek2.getRow(), dalek2.getCol());
            catchGame.removePiece(dalek3.getRow(), dalek3.getCol());
            catchGame.removePiece(walter.getRow(), walter.getCol());

            if (!walter.hasCrashed()) {
                //if walter hasnt crashed move
                walter.move(row, col);
            }

            if (!dalek1.hasCrashed()) {
                //if dalek1 hasnt crashed move towards walter
                dalek1.advanceTowards(walter);
            }

            if (!dalek2.hasCrashed()) {
                //if dalek2 hasnt crashed move towards walter
                dalek2.advanceTowards(walter);
            }

            if (!dalek3.hasCrashed()) {
                //if dalek3 hasnt crashed move towards walter
                dalek3.advanceTowards(walter);
            }

            //check if the daleks or walter has crashed
            dalek1.crash(dalek2);
            dalek1.crash(dalek3);
            dalek1.crash(walter);

            dalek2.crash(dalek1);
            dalek2.crash(dalek3);
            dalek2.crash(walter);

            dalek3.crash(dalek1);
            dalek3.crash(dalek2);
            dalek3.crash(walter);

            walter.crash(dalek1);
            walter.crash(dalek2);
            walter.crash(dalek3);

            if (dalek1.hasCrashed()) {
                //if dalek1 has crashed place a red piece 
                catchGame.putPiece(dalek1.getRow(), dalek1.getCol(), Color.red);
            } else {
                //if not continue to move as a yellow piece
                catchGame.putPiece(dalek1.getRow(), dalek1.getCol(), Color.yellow);
            }


            if (dalek2.hasCrashed()) {
                //if dalek2 has crashed place a red piece 
                catchGame.putPiece(dalek2.getRow(), dalek2.getCol(), Color.red);
            } else {
                //if not continue to move as a yellow piece
                catchGame.putPiece(dalek2.getRow(), dalek2.getCol(), Color.yellow);
            }

            if (dalek3.hasCrashed()) {
                //if dalek3 has crashed place a red piece 
                catchGame.putPiece(dalek3.getRow(), dalek3.getCol(), Color.red);
            } else {
                //if not continue to move as a yellow piece
                catchGame.putPiece(dalek3.getRow(), dalek3.getCol(), Color.yellow);
            }

            if (walter.hasCrashed()) {
                //if walter has crashed place a red piece 
                catchGame.putPiece(walter.getRow(), walter.getCol(), Color.red);
                catchGame.setMessage("you have lost!");
                break;
            } else {
                //if not continue to move as a green piece
                catchGame.putPiece(walter.getRow(), walter.getCol(), Color.green);
            }

            if (dalek1.hasCrashed() && dalek2.hasCrashed() && dalek3.hasCrashed()) {
                //if all the daleks have crashed into eachother
                catchGame.setMessage("you have won!");
                break;
            }


        }

    }
}
