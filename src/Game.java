
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

        boolean gameover = false;
        // TODO code application logic here
        GameBoard board = new GameBoard();

        //random doc starting position
        int startDocRow = (int) (Math.random() * 8);
        int startDocCol = (int) (Math.random() * 8);
        Doctor doc = new Doctor(startDocRow, startDocCol);

        //random dalek 1 starting position
        int d1row = (int) (Math.random() * 8);
        int d1col = (int) (Math.random() * 8);
        //if the dalek 1 spawn on top of something keep randomizing the positon until it is not on something
        while (startDocRow == d1row) {
            d1row = (int) (Math.random() * 8);
        }
        while (startDocCol == d1col) {
            d1col = (int) (Math.random() * 8);
        }
        Dalek d1 = new Dalek(d1row, d1col);

        //random dalek 2 starting position
        int d2row = (int) (Math.random() * 8);
        int d2col = (int) (Math.random() * 8);
        //if the dalek 2 spawn on top of something keep randomizing the positon until it is not on something
        while (startDocRow == d2row || d2row == d1row) {
            d2row = (int) (Math.random() * 8);
        }
        while (startDocCol == d2col || d2col == d1col) {
            d2col = (int) (Math.random() * 8);
        }
        Dalek d2 = new Dalek(d2row, d2row);
        
        //random dalek 3 starting position
        int d3row = (int) (Math.random() * 8);
        int d3col = (int) (Math.random() * 8);
        //if the dalek 3 spawn on top of something keep randomizing the positon until it is not on something
        while (startDocRow == d3row || d3row == d1row || d3row == d2row) {
            d3row = (int) (Math.random() * 8);
        }
        while (startDocCol == d1col || d3col == d1col || d3col == d2col) {
            d3col = (int) (Math.random() * 8);
        }
        Dalek d3 = new Dalek(d3row, d3col);
        
        //put all the peices on the board
        board.putPiece(startDocRow, startDocCol, Color.GREEN);
        board.putPiece(d1.getRow(), d1.getCol(), Color.yellow);
        board.putPiece(d2.getRow(), d2.getCol(), Color.yellow);
        board.putPiece(d3.getRow(), d3.getCol(), Color.yellow);
        board.printBoard();

        //click coutner
        int click = 0;


        while (true) {
            //look for a click
            Coordinate c = board.getClick();
            click++; //adds 1 to click
            board.setMessage("Clicks: " + click);
            //store the x and y coordinates of the click into variable
            int docrow = c.getRow();
            int doccol = c.getCol();

            //remove the postion the doctor was at 
            board.removePiece(doc.getRow(), doc.getCol());
            //send the row and colum of the click into the doctor move method 
            doc.move(docrow, doccol);
            //used the variabls with the click coordinates to palce doctor there  
            board.putPiece(doc.getRow(), doc.getCol(), Color.green);

            //remove the peices of the dalkes and move them to the doctor 
            board.removePiece(d1.getRow(), d1.getCol());
            d1.moveTowards(doc);
            board.removePiece(d2.getRow(), d2.getCol());
            d2.moveTowards(doc);
            board.removePiece(d3.getRow(), d3.getCol());
            d3.moveTowards(doc);


            //dalek1 crashes dalek2. Put a red peice where the crash takes palce
            if (d1.getRow() == d2.getRow() && d1.getCol() == d2.getCol()) {
                d1.crash();
                d2.crash();
                board.removePiece(d1.getRow(), d1.getCol());
                board.removePiece(d2.getRow(), d2.getCol());
                board.putPiece(d2.getRow(), d2.getCol(), Color.red);

            }
            //dalek1 crahes with dalek 3. Put a red peice where the crash takes palce
            if (d1.getRow() == d3.getRow() && d1.getCol() == d3.getCol()) {
                d1.crash();
                d3.crash();
                board.removePiece(d1.getRow(), d1.getCol());
                board.removePiece(d3.getRow(), d3.getCol());
                board.putPiece(d3.getRow(), d3.getCol(), Color.red);

            }

            //dalek2 crashes dalek3. Put a red peice where the crash takes palce
            if (d2.getRow() == d3.getRow() && d2.getCol() == d3.getCol()) {
                d2.crash();
                d3.crash();
                board.removePiece(d2.getRow(), d2.getCol());
                board.removePiece(d3.getRow(), d3.getCol());
                board.putPiece(d2.getRow(), d2.getCol(), Color.red);

            }

            //only place a dalek if the game is not over and they are not crashed
            if (d1.hasCrashed() && d2.hasCrashed() && d3.hasCrashed()) {
                board.setMessage("You won in " + click);
                break;
            }
            if (!d1.hasCrashed()) {
                board.putPiece(d1.getRow(), d1.getCol(), Color.yellow);
            }
            if (!d2.hasCrashed()) {
                board.putPiece(d2.getRow(), d2.getCol(), Color.yellow);
            }
            if (!d3.hasCrashed()) {
                board.putPiece(d3.getRow(), d3.getCol(), Color.yellow);
            }



            //dalek 1 crashed with doc. Put a red peice where the crash takes palce and break the game loop
            if (d1.getRow() == doc.getRow() && d1.getCol() == doc.getCol()) {
                board.removePiece(d1.getRow(), d1.getCol());
                board.removePiece(doc.getRow(), doc.getCol());
                board.putPiece(doc.getRow(), doc.getCol(), Color.blue);

                board.setMessage("You Lost");
                break;
            }

            //dalek 2 crashed with doc. Put a red peice where the crash takes palce and break the game loop
            if (d2.getRow() == doc.getRow() && d2.getCol() == doc.getCol()) {
                board.removePiece(d2.getRow(), d2.getCol());
                board.removePiece(doc.getRow(), doc.getCol());
                board.putPiece(doc.getRow(), doc.getCol(), Color.blue);

                board.setMessage("You Lost");
                break;
            }

            //dalek 3 crashed with doc. Put a red peice where the crash takes palce and break the game loop
            if (d3.getRow() == doc.getRow() && d3.getCol() == doc.getCol()) {
                board.removePiece(d3.getRow(), d3.getCol());
                board.removePiece(doc.getRow(), doc.getCol());
                board.putPiece(doc.getRow(), doc.getCol(), Color.blue);

                board.setMessage("You Lost");
                break;
            }
        }
    }
}
