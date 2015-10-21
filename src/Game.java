
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
        Doctor tim = new Doctor(6, 5);
        Dalek clayton = new Dalek(0, 0);
        Dalek leo = new Dalek(3, 4);
        Dalek cole = new Dalek(7, 0);
        GameBoard board = new GameBoard();
        board.printBoard();
        board.putPiece(clayton.getRow(), clayton.getCol(), Color.yellow);
        board.putPiece(cole.getRow(), cole.getCol(), Color.yellow);
        board.putPiece(leo.getRow(), leo.getCol(), Color.yellow);
        board.putPiece(tim.getRow(), tim.getCol(), Color.green);


        while (true) {

            Coordinate click = board.getClick();
            count++;
            board.setMessage("You have moved " + count + " times");
            int row = click.getRow();
            int col = click.getCol();
            board.removePiece(tim.getRow(), tim.getCol());
            board.removePiece(clayton.getRow(), clayton.getCol());
            board.removePiece(leo.getRow(), leo.getCol());
            board.removePiece(cole.getRow(), cole.getCol());
            tim.move(row, col);
            board.putPiece(tim.getRow(), tim.getCol(), Color.green);
            
            if (!clayton.hasCrashed()) {
                clayton.advanceTowards(tim);
                board.putPiece(clayton.getRow(), clayton.getCol(), Color.yellow);

            } else {
                board.removePiece(clayton.getRow(), clayton.getCol());
            }
            if (!leo.hasCrashed()) {
                leo.advanceTowards(tim);
                board.putPiece(leo.getRow(), leo.getCol(), Color.yellow);
            } else {
                board.removePiece(leo.getRow(), leo.getCol());
            }
            if (!cole.hasCrashed()) {
                cole.advanceTowards(tim);
                board.putPiece(cole.getRow(), cole.getCol(), Color.yellow);
            } else {
                board.removePiece(cole.getRow(), cole.getCol());
            }
            if (tim.getRow() == cole.getRow() && tim.getCol() == cole.getCol()){
                board.setMessage("The doctor loses! You moved " + count + " times!");
                break;
            }
            if (tim.getRow() == clayton.getRow() && tim.getCol() == clayton.getCol()){
                board.setMessage("The doctor loses! You moved " + count + " times!");
                break;
            }
            if (tim.getRow() == leo.getRow() && tim.getCol() == leo.getCol()){
                board.setMessage("The doctor loses! You moved " + count + " times!");
                break;
            }

            if (clayton.getRow() == cole.getRow() && clayton.getCol() == cole.getCol()) {
                clayton.crash();
                cole.crash();
                board.removePiece(clayton.getRow(), clayton.getCol());
                board.removePiece(cole.getRow(), cole.getCol());

                board.putPiece(clayton.getRow(), clayton.getCol(), Color.red);
            }
            if (leo.getRow() == cole.getRow() && leo.getCol() == cole.getCol()) {
                leo.crash();
                cole.crash();
                board.removePiece(leo.getRow(), leo.getCol());
                board.removePiece(cole.getRow(), cole.getCol());
                board.putPiece(leo.getRow(), leo.getCol(), Color.red);
            }
            if (clayton.getRow() == leo.getRow() && clayton.getCol() == leo.getCol()) {
                clayton.crash();
                leo.crash();
                board.removePiece(clayton.getRow(), clayton.getCol());
                board.removePiece(leo.getRow(), leo.getCol());
                board.putPiece(clayton.getRow(), clayton.getCol(), Color.red);
            }
            if (clayton.hasCrashed() && leo.hasCrashed() && cole.hasCrashed()) {
                board.setMessage("You win! You moved " + count + " times!");

            }

        }
    }
}
