
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
        int count = 0;
        Doctor tim = new Doctor(3, 5);
        Dalek clayton = new Dalek(1, 2);
        Dalek leo = new Dalek(5, 5);
        GameBoard board = new GameBoard();
        board.printBoard();
        board.putPiece(clayton.getRow(), clayton.geCol(), Color.yellow);
        board.putPiece(leo.getRow(), leo.geCol(), Color.yellow);
        board.putPiece(tim.getRow(), tim.getCol(), Color.green);


        while (true) {

            Coordinate click = board.getClick();
            count ++;
            board.setMessage("You have moved " + count + " times");
            int row = click.getRow();
            int col = click.getCol();
            board.removePiece(tim.getRow(), tim.getCol());
            board.removePiece(clayton.getRow(), clayton.geCol());
            board.removePiece(leo.getRow(), leo.geCol());
            tim.move(row, col);
            board.putPiece(tim.getRow(), tim.getCol(), Color.green);
            clayton.advanceTowards(tim);
            leo.advanceTowards(tim);
            board.putPiece(clayton.getRow(), clayton.geCol(), Color.yellow);
            board.putPiece(leo.getRow(), leo.geCol(), Color.yellow);


        }
    }
}
