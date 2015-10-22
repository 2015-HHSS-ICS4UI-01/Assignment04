
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
        Doctor tim = new Doctor((int) (Math.random() * 8), (int) (Math.random() * 8));//new doctor at a random spot
        Dalek clayton = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));//new dalek at a random spot
        Dalek leo = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));//new dalek at a random spot
        Dalek cole = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));//new dalek at a random spot
        GameBoard board = new GameBoard();//new gameboard
        board.printBoard();//will print the gameboard
        board.putPiece(clayton.getRow(), clayton.getCol(), Color.yellow);//will put the dalek piece on the board
        board.putPiece(cole.getRow(), cole.getCol(), Color.yellow);//will put the dalek piece on the board
        board.putPiece(leo.getRow(), leo.getCol(), Color.yellow);//will put the dalek piece on the board
        board.putPiece(tim.getRow(), tim.getCol(), Color.green);//will put the doc piece on the board


        while (true) {//while the game is running

            Coordinate click = board.getClick();//will get where the player clicks
            count++;//add one to count
            board.setMessage("You have moved " + count + " times");//will output how many times the player has click/moved
            int row = click.getRow();//gets the row of the click 
            int col = click.getCol();//gets the col fo the click
            board.removePiece(tim.getRow(), tim.getCol());//removes the doc piece
            board.removePiece(clayton.getRow(), clayton.getCol());//removes the dalke piece
            board.removePiece(leo.getRow(), leo.getCol());//removes the dalke piece
            board.removePiece(cole.getRow(), cole.getCol());//removes the dalke piece
            tim.move(row, col);//calls the move method
            board.putPiece(tim.getRow(), tim.getCol(), Color.green);//re-places the piece of the doc

            if (!clayton.hasCrashed()) {//while dalek hasnt crashed 
                clayton.advanceTowards(tim);//dalek moves towards doc
                board.putPiece(clayton.getRow(), clayton.getCol(), Color.yellow);//puts new peice in advanced spot

            } else {
                board.removePiece(clayton.getRow(), clayton.getCol());//removes the dalek piece
            }
            if (!leo.hasCrashed()) {//while dalek hasnt crashed 
                leo.advanceTowards(tim);//dalek moves towards doc
                board.putPiece(leo.getRow(), leo.getCol(), Color.yellow);//puts new peice in advanced spot
            } else {
                board.removePiece(leo.getRow(), leo.getCol());//removes the dalek piece
            }
            if (!cole.hasCrashed()) {//while dalek hasnt crashed 
                cole.advanceTowards(tim);//dalek moves towards doc
                board.putPiece(cole.getRow(), cole.getCol(), Color.yellow);//puts new peice in advanced spot
            } else {
                board.removePiece(cole.getRow(), cole.getCol());//removes the dalek piece
            }
            if (tim.getRow() == cole.getRow() && tim.getCol() == cole.getCol()) {//if one of the daleks is on top of the doc
                board.setMessage("The doctor loses! You moved " + count + " times!");//messages shows that you lose
                break;//breaks the game loop
            }
            if (tim.getRow() == clayton.getRow() && tim.getCol() == clayton.getCol()) {//if one of the daleks is on top of the doc
                board.setMessage("The doctor loses! You moved " + count + " times!");//messages shows that you lose
                break;//breaks the game loop
            }
            if (tim.getRow() == leo.getRow() && tim.getCol() == leo.getCol()) {//if one of the daleks is on top of the doc
                board.setMessage("The doctor loses! You moved " + count + " times!");//messages shows that you lose
                break;//breaks the game loop
            }

            if (clayton.getRow() == cole.getRow() && clayton.getCol() == cole.getCol()) {//if dalek is on top/on same peice as another dalek both daleks crash
                clayton.crash();
                cole.crash();
                board.removePiece(clayton.getRow(), clayton.getCol());
                board.removePiece(cole.getRow(), cole.getCol());

                board.putPiece(clayton.getRow(), clayton.getCol(), Color.red);
            }
            if (leo.getRow() == cole.getRow() && leo.getCol() == cole.getCol()) {//if dalek is on top/on same peice as another dalek both daleks crash
                leo.crash();
                cole.crash();
                board.removePiece(leo.getRow(), leo.getCol());
                board.removePiece(cole.getRow(), cole.getCol());
                board.putPiece(leo.getRow(), leo.getCol(), Color.red);
            }
            if (clayton.getRow() == leo.getRow() && clayton.getCol() == leo.getCol()) {//if dalek is on top/on same peice as another dalek both daleks crash
                clayton.crash();
                leo.crash();
                board.removePiece(clayton.getRow(), clayton.getCol());
                board.removePiece(leo.getRow(), leo.getCol());
                board.putPiece(clayton.getRow(), clayton.getCol(), Color.red);
            }
            if (clayton.hasCrashed() && leo.hasCrashed() && cole.hasCrashed()) {//if all the daleks have crashed
                board.setMessage("You win! You moved " + count + " times!");

            }

        }
    }
}
