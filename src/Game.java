
import java.awt.Color;
import java.util.Random;

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
        //States the game is running
        boolean running = true;
        //creates the board
        GameBoard board = new GameBoard();
        Random rand = new Random();

        int row = rand.nextInt(8);
        int col = rand.nextInt(8);
        //Create the player
        Doctor player = new Doctor(row, col);
        // put a randomly generated piece
        board.putPiece(row, col, Color.BLUE);

        rand = new Random();
        int row1 = rand.nextInt(8);
        int col1 = rand.nextInt(8);
        if (row1 == row) {
            row1 = rand.nextInt(8);
        }
        if (col1 == col) {
            col = rand.nextInt(8);
        }
        //Places Dalek1 in a randomly generated row and col
        Dalek enemy1 = new Dalek(row1, col1);
        board.putPiece(row1, col1, Color.RED);

        rand = new Random();
        int row2 = rand.nextInt(8);
        int col2 = rand.nextInt(8);
        if (row2 == row || row2 == row1) {
            row2 = rand.nextInt(8);
        }
        if (col2 == col || col2 == col1) {
            col2 = rand.nextInt(8);
        }
        //Places Dalek2 in a randomly generated row and col
        Dalek enemy2 = new Dalek(row2, col2);
        board.putPiece(row2, col2, Color.RED);

        rand = new Random();
        int row3 = rand.nextInt(8);
        int col3 = rand.nextInt(8);
        if (row3 == row || row3 == row1 || row3 == row2) {
            row3 = rand.nextInt(8);
        }
        if (col3 == col || col3 == col1 || col3 == col2) {
            col3 = rand.nextInt(8);
        }
        //Places Dalek3 in a randomly generated row and col
        Dalek enemy3 = new Dalek(row3, col3);
        board.putPiece(row3, col3, Color.RED);

        while (running) {
            //check if the player has been captured or if all Daleks have crashed
            if (player.getRow() == enemy1.getRow() && player.getCol() == enemy1.getCol()
                    || player.getRow() == enemy2.getRow() && player.getCol() == enemy2.getCol()
                    || player.getRow() == enemy3.getRow() && player.getCol() == enemy3.getCol()) {
                running = false;
                board.setMessage("You have been Captured.");

            } else if (enemy1.hasCrashed() && enemy2.hasCrashed() && enemy3.hasCrashed()) {

                running = false;
                board.setMessage("You Win!.");

            } else {

                Coordinate cords = board.getClick();
                board.removePiece(player.getRow(), player.getCol());
                row = cords.getRow();
                col = cords.getCol();

                player.move(row, col);


                row = player.getRow();
                col = player.getCol();

                board.putPiece(row, col, Color.BLUE);
            //check if the player has been captured or if all Daleks have crashed
            //place the player
                if (player.getRow() == enemy1.getRow() && player.getCol() == enemy1.getCol()
                        || player.getRow() == enemy2.getRow() && player.getCol() == enemy2.getCol()
                        || player.getRow() == enemy3.getRow() && player.getCol() == enemy3.getCol()) {
                    running = false;
                    board.setMessage("You have been Captured.");

                }
            }
            //check if any Daleks have crashed
            //place Dalek1
            if (!enemy1.hasCrashed()) {
                board.removePiece(enemy1.getRow(), enemy1.getCol());
                enemy1.advanceTowards(player);
                board.putPiece(enemy1.getRow(), enemy1.getCol(), Color.RED);

                if (enemy1.getRow() == enemy3.getRow() && enemy3.getCol() == enemy1.getCol()) {
                    board.removePiece(enemy1.getRow(), enemy1.getCol());
                    board.removePiece(enemy3.getRow(), enemy3.getCol());

                    board.putPiece(enemy3.getRow(), enemy3.getCol(), Color.GRAY);
                    enemy1.crash();
                    enemy3.crash();
                }
                if (enemy1.getRow() == enemy2.getRow() && enemy1.getCol() == enemy2.getCol()) {
                    board.removePiece(enemy1.getRow(), enemy1.getCol());
                    board.removePiece(enemy2.getRow(), enemy2.getCol());

                    board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                    enemy1.crash();
                    enemy2.crash();
                }
            }
            //check if any Daleks have crashed
            //place Dalek2
            if (!enemy2.hasCrashed()) {
                board.removePiece(enemy2.getRow(), enemy2.getCol());
                enemy2.advanceTowards(player);
                board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.RED);

                if (enemy2.getRow() == enemy3.getRow() && enemy2.getCol() == enemy3.getCol()) {
                    board.removePiece(enemy3.getRow(), enemy3.getCol());
                    board.removePiece(enemy2.getRow(), enemy2.getCol());

                    board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                    enemy3.crash();
                    enemy2.crash();
                }
                if (enemy1.getRow() == enemy2.getRow() && enemy1.getCol() == enemy2.getCol()) {
                    board.removePiece(enemy1.getRow(), enemy1.getCol());
                    board.removePiece(enemy2.getRow(), enemy2.getCol());

                    board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                    enemy1.crash();
                    enemy2.crash();
                }
            }
            //check if any Daleks have crashed
            //place Dalek3
            if (!enemy3.hasCrashed()) {
                board.removePiece(enemy3.getRow(), enemy3.getCol());
                enemy3.advanceTowards(player);
                board.putPiece(enemy3.getRow(), enemy3.getCol(), Color.RED);

                if (enemy2.getRow() == enemy3.getRow() && enemy2.getCol() == enemy3.getCol()) {
                    board.removePiece(enemy3.getRow(), enemy3.getCol());
                    board.removePiece(enemy2.getRow(), enemy2.getCol());

                    board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                    enemy3.crash();
                    enemy2.crash();
                }
                if (enemy1.getRow() == enemy3.getRow() && enemy3.getCol() == enemy1.getCol()) {
                    board.removePiece(enemy1.getRow(), enemy1.getCol());
                    board.removePiece(enemy3.getRow(), enemy3.getCol());

                    board.putPiece(enemy3.getRow(), enemy3.getCol(), Color.GRAY);
                    enemy1.crash();
                    enemy3.crash();
                }
            }
        }
    }
}
