
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
        board.clearBoard();
        int row, col;
        Dalek[] daleks = new Dalek[3];
        Doctor doc;
        boolean gameover, overlapping;
        while (true) {
            gameover = false;
            do {
                for (int i = 0; i < daleks.length; i++) {
                    daleks[i] = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
                }
                overlapping = false;
                for (int i = 0; i < daleks.length - 1; i++) {
                    for (int j = i + 1; j < daleks.length; j++) {
                        if (daleks[i].getRow() == daleks[j].getRow() && daleks[i].getCol() == daleks[j].getCol()) {
                            overlapping = true;
                        }
                    }
                }
            } while (overlapping);
            do {
                overlapping = false;
                doc = new Doctor((int) (Math.random() * 8), (int) (Math.random() * 8));
                for (int i = 0; i < daleks.length; i++) {
                    if (doc.getRow() == daleks[i].getRow() && doc.getCol() == daleks[i].getCol()) {
                        overlapping = true;
                    }
                }
            } while (overlapping);
            for (int i = 0; i < daleks.length; i++) {
                board.putPiece(daleks[i].getRow(), daleks[i].getCol(), Color.BLACK);
            }
            board.putPiece(doc.getRow(), doc.getCol(), Color.GREEN);
            do {

                //Doctor Code

                Coordinate coordinate = board.getClick();
                board.removePiece(doc.getRow(), doc.getCol());
                row = coordinate.getRow();
                col = coordinate.getCol();
                doc.move(row, col);
                board.putPiece(doc.getRow(), doc.getCol(), Color.GREEN);

                //Dalek Code

                for (int i = 0; i < daleks.length; i++) {
                    board.removePiece(daleks[i].getRow(), daleks[i].getCol());
                }
                for (int i = 0; i < daleks.length; i++) {
                    if (!daleks[i].hasCrashed()) {
                        daleks[i].move(doc);
                    }
                }
                for (int i = 0; i < daleks.length; i++) {
                    for (int j = i + 1; j < daleks.length; j++) {
                        if (daleks[i].getRow() == daleks[j].getRow() && daleks[i].getCol() == daleks[j].getCol()) {
                            daleks[i].crash();
                            daleks[j].crash();
                        }
                    }
                }
                for (int i = 0; i < daleks.length; i++) {
                    if (!daleks[i].hasCrashed()) {
                        board.putPiece(daleks[i].getRow(), daleks[i].getCol(), Color.BLACK);
                    } else {
                        board.putPiece(daleks[i].getRow(), daleks[i].getCol(), Color.RED);
                    }
                }
                for (int i = 0; i < daleks.length; i++) {
                    if (daleks[i].getRow() == doc.getRow() && daleks[i].getCol() == doc.getCol()) {
                        board.setMessage("You were captured by a dalek!");
                        board.putPiece(doc.getRow(), doc.getCol(), Color.YELLOW);
                        gameover = true;
                    }
                }
                if (!gameover) {
                    if (daleks[0].hasCrashed() && daleks[1].hasCrashed() && daleks[2].hasCrashed()) {
                        board.setMessage("You destroyed all the daleks!");
                        gameover = true;
                    }
                }
            } while (!gameover);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            board.setMessage("");
            board.clearBoard();
        }
    }
}