
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
        //Contains the row value of the player
        int row = rand.nextInt(8);
        //Contains the column value of the player
        int col = rand.nextInt(8);
        //Create the player and sets start position
        Doctor player = new Doctor(row, col);
        // put a randomly generated piece
        board.putPiece(row, col, Color.BLUE);
        //Contains the value for the row value of Dalek1
        int row1 = rand.nextInt(8);
        //Contains the value for the column value of Dalek1
        int col1 = rand.nextInt(8);
        //Check if Dalek1 start row is equal to the players row
        if (row1 == row) {
            //randomly generate new starting row value for Dalek1
            row1 = rand.nextInt(8);
        }
        //Check if Dalek1 start column is equal to the players column
        if (col1 == col) {
            //randomly generate new starting column value for Dalek1
            col = rand.nextInt(8);
        }
        //Create Dalek1 and sets start position
        Dalek enemy1 = new Dalek(row1, col1);
        //Place DAlek1 on the board
        board.putPiece(row1, col1, Color.RED);
        //Contains the value for the row value of Dalek2
        int row2 = rand.nextInt(8);
        //Contains the value for the column value of Dalek2
        int col2 = rand.nextInt(8);
        //Check if Dalek3 has the same row value as another pawn
        if (row2 == row || row2 == row1) {
            //randomly generate new starting row value for Dalek2
            row2 = rand.nextInt(8);
        }
        //Check if Dalek2 has the same column value as another pawn
        if (col2 == col || col2 == col1) {
            //randomly generate new starting column value for Dalek2
            col2 = rand.nextInt(8);
        }
        //Create Dalek2 and sets start position
        Dalek enemy2 = new Dalek(row2, col2);
        //Places Dalek 2 at the set coordinates
        board.putPiece(row2, col2, Color.RED);
        //Contains the value for the row value of Dalek3
        int row3 = rand.nextInt(8);
        //Contains the value for the column value of Dalek3
        int col3 = rand.nextInt(8);
        //Check if Dalek3 has the same row value as another pawn
        if (row3 == row || row3 == row1 || row3 == row2) {
            //randomly generate new starting row value for Dalek3
            row3 = rand.nextInt(8);
        }
        //Check if Dalek3 has the same column value as another pawn
        if (col3 == col || col3 == col1 || col3 == col2) {
            //randomly generate new starting column value for Dalek3
            col3 = rand.nextInt(8);
        }
        //Creates Dalek3 and sets start position
        Dalek enemy3 = new Dalek(row3, col3);
        //Place Dalek3 at the set coordinates
        board.putPiece(row3, col3, Color.RED);

        while (running) {
            //check if the player has been captured or if all Daleks have crashed
            if (player.getRow() == enemy1.getRow() && player.getCol() == enemy1.getCol()
                    || player.getRow() == enemy2.getRow() && player.getCol() == enemy2.getCol()
                    || player.getRow() == enemy3.getRow() && player.getCol() == enemy3.getCol()) {
                //Stop running the game
                running = false;
                //Display "failure" to the player
                board.setMessage("You have been Captured.");
                //Check if all Daleks have crashed 
            } else if (enemy1.hasCrashed() && enemy2.hasCrashed() && enemy3.hasCrashed()) {
                //Display "victory" message to the player
                board.setMessage("You Win!.");
                //Stop running the game
                running = false;

            } else {
                //Set the coordinates of where the player clicks in "cords"
                Coordinate cords = board.getClick();
                //Remove the player from the board
                board.removePiece(player.getRow(), player.getCol());
                //
                row = cords.getRow();
                //
                col = cords.getCol();
                //
                player.move(row, col);
                //
                row = player.getRow();
                //
                col = player.getCol();
                //Place player on the board at the updated coordinates
                board.putPiece(row, col, Color.BLUE);
            //check if the player has been captured or if all Daleks have crashed
                if (player.getRow() == enemy1.getRow() && player.getCol() == enemy1.getCol()
                        || player.getRow() == enemy2.getRow() && player.getCol() == enemy2.getCol()
                        || player.getRow() == enemy3.getRow() && player.getCol() == enemy3.getCol()) {
                    //Display "failure" message to the player
                    board.setMessage("You have been Captured.");
                    //Stop running the game
                    running = false;
                }
            }
            //check if Dalek1 has crashed
            if (!enemy1.hasCrashed()) {
                //Remove Dalek1 from the board
                board.removePiece(enemy1.getRow(), enemy1.getCol());
                //Update Dalek1's coordinates to move towards the player
                enemy1.advanceTowards(player);
                //Place Dalek1 on the board in updated position
                board.putPiece(enemy1.getRow(), enemy1.getCol(), Color.RED);
                //check if Dalek1 crashed with Dalek3 during movement
                if (enemy1.getRow() == enemy3.getRow() && enemy3.getCol() == enemy1.getCol()) {
                    //Remove Dalek 1 from the baord
                    board.removePiece(enemy1.getRow(), enemy1.getCol());
                    //Remove Dalek3 from the board
                    board.removePiece(enemy3.getRow(), enemy3.getCol());
                    //place crashed piece on board 
                    board.putPiece(enemy3.getRow(), enemy3.getCol(), Color.GRAY);
                    //Set Dalek1 as crashed
                    enemy1.crash();
                    //Set Dalek3 as crashed
                    enemy3.crash();
                }
                //check if Dalek1 crashed with Dalek2 during movement
                if (enemy1.getRow() == enemy2.getRow() && enemy1.getCol() == enemy2.getCol()) {
                    //Remove Dalek1 from the board
                    board.removePiece(enemy1.getRow(), enemy1.getCol());
                    //Remove Dalek2 from the board
                    board.removePiece(enemy2.getRow(), enemy2.getCol());
                    //place crashed piece on board 
                    board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                    //Set Dalek1 as crashed
                    enemy1.crash();
                    //Set Dalek2 as crashed
                    enemy2.crash();
                }
            }
            //check if Dalek2 has crashed
            if (!enemy2.hasCrashed()) {
                //Remove Dalek2 from the board
                board.removePiece(enemy2.getRow(), enemy2.getCol());
                //Update Dalek2's coordinates to move towards the player
                enemy2.advanceTowards(player);
                //Place Dalek2 on the board at updated position
                board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.RED);
                //check if Dalek2 crashed with Dalek3 during movement
                if (enemy2.getRow() == enemy3.getRow() && enemy2.getCol() == enemy3.getCol()) {
                    //Remove Dalek3 from board
                    board.removePiece(enemy3.getRow(), enemy3.getCol());
                    //Remove Dalek2 from board
                    board.removePiece(enemy2.getRow(), enemy2.getCol());
                    //place crashed piece where Dalek 2 crashed on the board
                    board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                    //Set Dalek3 as crashed
                    enemy3.crash();
                    //Set Dalek2 as crashed
                    enemy2.crash();
                }
                //check if Dalek2 crashed with Dalek1 during movement
                if (enemy1.getRow() == enemy2.getRow() && enemy1.getCol() == enemy2.getCol()) {
                    //Remove Dalek1 from board
                    board.removePiece(enemy1.getRow(), enemy1.getCol());
                    //Remove Dalek2 from board
                    board.removePiece(enemy2.getRow(), enemy2.getCol());
                    //Place crashed piece where Dalek2 crashed on the board
                    board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                    //Set Dalek1 as crashed
                    enemy1.crash();
                    //Set Dalek2 as crashed
                    enemy2.crash();
                }
            }
            //check if Dalek3 has crashed
            if (!enemy3.hasCrashed()) {
                //Remove Dalek3 from the board
                board.removePiece(enemy3.getRow(), enemy3.getCol());
                //Update Dalek3's coordinates to move towards the player
                enemy3.advanceTowards(player);
                //Place Dalek3 on the board in updated position
                board.putPiece(enemy3.getRow(), enemy3.getCol(), Color.RED);
                
                //check if Dalek3 crashed with Dalek2 during movement
                if (enemy2.getRow() == enemy3.getRow() && enemy2.getCol() == enemy3.getCol()) {
                    //Remove Dalek3
                    board.removePiece(enemy3.getRow(), enemy3.getCol());
                    //remove Dalek2
                    board.removePiece(enemy2.getRow(), enemy2.getCol());
                    //place crashed piece where Dalek 2 crashed on the board
                    board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                    //Set Dalek3 as crashed
                    enemy3.crash();
                    //Set Dalek2 as crashed
                    enemy2.crash();
                }
                //check if Dalek3 crashed with Dalek1 during movement
                if (enemy1.getRow() == enemy3.getRow() && enemy3.getCol() == enemy1.getCol()) {
                    //Remove Dalek1
                    board.removePiece(enemy1.getRow(), enemy1.getCol());
                    //Remove Dalek3
                    board.removePiece(enemy3.getRow(), enemy3.getCol());
                    //place crashed piece where Dalek3 crashed on the board
                    board.putPiece(enemy3.getRow(), enemy3.getCol(), Color.GRAY);
                    //Set Dalek1 as crashed
                    enemy1.crash();
                    //Set Dalek3 as crashed
                    enemy3.crash();
                }
            }
        }
    }
}
