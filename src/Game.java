
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
        // TODO code application logic here
        GameBoard board = new GameBoard();

        Doctor paul = new Doctor((int) (Math.random() * 8), (int) (Math.random() * 8));
        Dalek d1 = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
        Dalek d2 = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));
        Dalek d3 = new Dalek((int) (Math.random() * 8), (int) (Math.random() * 8));


        int paulRow = paul.getRow();
        int paulCol = paul.getCol();
        board.putPiece(paulRow, paulCol, Color.lightGray);

        int d1Row = d1.getRow();
        int d1Col = d1.getCol();
        board.putPiece(d1Row, d1Col, Color.orange);

        int d2Row = d2.getRow();
        int d2Col = d2.getCol();
        board.putPiece(d2Row, d2Col, Color.orange);

        int d3Row = d3.getRow();
        int d3Col = d3.getCol();
        board.putPiece(d3Row, d3Col, Color.orange);

        while (true) {
            // wait for the user to click
            Coordinate click = board.getClick();
            //figure out where click           
            board.removePiece(paul.getRow(), paul.getCol());

            paul.move(click.getRow(), click.getCol());
            paulRow = paul.getRow();
            paulCol = paul.getCol();
            board.putPiece(paulRow, paulCol, Color.lightGray);
            

        }

    }
}
