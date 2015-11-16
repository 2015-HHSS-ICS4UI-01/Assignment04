
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

        //makes all used variables
        GameBoard board = new GameBoard();
        int row, col;
        Dalek[] daleks = new Dalek[3];
        Doctor doc;
        boolean gameover, overlapping;
        while (true) {

            //makes desired number of daleks at random spots that don't overlap
            for (int i = 0; i < daleks.length; i++) {
                do {
                    overlapping = false;
                    daleks[i] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
                    for (int j = i - 1; j >= 0; j--) {
                        if (daleks[i].getRow() == daleks[j].getRow() && daleks[i].getCol() == daleks[j].getCol()) {
                            overlapping = true;
                        }
                    }
                } while (overlapping);
            }

            //makes a doctor at random spot that doesn't overlap with daleks 
            do {
                overlapping = false;
                doc = new Doctor((int) (Math.random() * 8), (int) (Math.random() * 8));
                for (int i = 0; i < daleks.length; i++) {
                    if (doc.getRow() == daleks[i].getRow() && doc.getCol() == daleks[i].getCol()) {
                        overlapping = true;
                    }
                }
            } while (overlapping);

            //places all the pieces 
            for (int i = 0; i < daleks.length; i++) {
                board.putPiece(daleks[i].getRow(), daleks[i].getCol(), Color.BLACK);
            }
            board.putPiece(doc.getRow(), doc.getCol(), Color.GREEN);
            do {
                Coordinate coordinate = board.getClick();
                board.removePiece(doc.getRow(), doc.getCol());
                doc.move(coordinate.getRow(), coordinate.getCol());
                board.putPiece(doc.getRow(), doc.getCol(), Color.GREEN);

                //removes dalek pieces
                for (int i = 0; i < daleks.length; i++) {
                    board.removePiece(daleks[i].getRow(), daleks[i].getCol());
                }

                //moves all uncrashed daleks towards the doctor
                for (int i = 0; i < daleks.length; i++) {
                    if (!daleks[i].hasCrashed()) {
                        daleks[i].move(doc);
                    }
                }

                //crashes any daleks that collide
                for (int i = 0; i < daleks.length - 1; i++) {
                    for (int j = i + 1; j < daleks.length; j++) {
                        if (daleks[i].getRow() == daleks[j].getRow() && daleks[i].getCol() == daleks[j].getCol()) {
                            daleks[i].crash();
                            daleks[j].crash();
                        }
                    }
                }

                //places all dalek pieces back on board
                for (int i = 0; i < daleks.length; i++) {
                    if (!daleks[i].hasCrashed()) {
                        board.putPiece(daleks[i].getRow(), daleks[i].getCol(), Color.BLACK);
                    } else {
                        board.putPiece(daleks[i].getRow(), daleks[i].getCol(), Color.RED);
                    }
                }

                //tells user they have won and ends game
                gameover = true;
                for (int i = 0; i < daleks.length; i++) {
                    if (!daleks[i].hasCrashed()) {
                        gameover = false;
                    }
                }
                if (gameover) {
                    board.setMessage("You destroyed all the daleks!");
                }

                //tells user they have lost and ends game
                for (int i = 0; i < daleks.length; i++) {
                    if (daleks[i].getRow() == doc.getRow() && daleks[i].getCol() == doc.getCol()) {
                        board.setMessage("You were captured by a dalek!");
                        board.putPiece(doc.getRow(), doc.getCol(), Color.YELLOW);
                        gameover = true;
                    }
                }
            } while (!gameover);
            //waits 2 seconds before restarting game       
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            board.setMessage(""); //clears message
            board.clearBoard();   //clears board of all pieces
        }
    }
}