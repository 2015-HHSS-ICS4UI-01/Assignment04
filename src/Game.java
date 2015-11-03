
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

    public static int randInt(int min, int max) {

        Random rand = new Random();
        //generate a random number
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int min = 0;
        int max = 7;

        boolean done = false;
        boolean win = false;
        boolean docDead = false;
        int timesClicked = 0;

        GameBoard board = new GameBoard();

        //Starts each piece in a random location
        Doctor doc = new Doctor(randInt(min, max), randInt(min, max));
        Dalek d1 = new Dalek(randInt(min, max), randInt(min, max));
        Dalek d2 = new Dalek(randInt(min, max), randInt(min, max));
        Dalek d3 = new Dalek(randInt(min, max), randInt(min, max));

        while (!done) {
            
            //puts all peices down
            board.putPiece(doc.getRow(), doc.getCol(), Color.green);
            //checks if the peices are still active before putting them down
            if (!d1.hasCrashed()) {
                board.putPiece(d1.getRow(), d1.getCol(), Color.gray);
            }
            
            if (!d2.hasCrashed()) {
                board.putPiece(d2.getRow(), d2.getCol(), Color.gray);
            }
            
            if (!d3.hasCrashed() == false) {
                board.putPiece(d3.getRow(), d3.getCol(), Color.gray);
            }

            //Removes the daleks before placing them again
            board.removePiece(d1.getRow(), d1.getCol());
            board.removePiece(d2.getRow(), d2.getCol());
            board.removePiece(d3.getRow(), d3.getCol());

            //checks if the daleks are colliding
            //if they do collide they turn red and are set to not move 
            if (d1.getRow() == d2.getRow() && d1.getCol() == d2.getCol()) {
                d1.crash(d1, d2);

                board.putPiece(d1.getRow(), d1.getCol(), Color.red);
                board.putPiece(d2.getRow(), d2.getCol(), Color.red);
            }
            
            if (d1.getRow() == d3.getRow() && d1.getCol() == d3.getCol()) {
                d1.crash(d1, d3);

                board.putPiece(d1.getRow(), d1.getCol(), Color.red);
                board.putPiece(d3.getRow(), d3.getCol(), Color.red);
            }
            
            if (d2.getRow() == d3.getRow() && d2.getCol() == d3.getCol()) {
                d2.crash(d2, d3);
                board.putPiece(d2.getRow(), d2.getCol(), Color.red);
                board.putPiece(d3.getRow(), d3.getCol(), Color.red);
            }

            //Checks if the daleks are still alive before moving them towards the doctor
            if (!d1.hasCrashed()) {
                d1.advanceTowards(doc);
                board.putPiece(d1.getRow(), d1.getCol(), Color.gray);
            }
            
            if (!d2.hasCrashed()) {
                d2.advanceTowards(doc);
                board.putPiece(d2.getRow(), d2.getCol(), Color.gray);
            }
            
            if (!d3.hasCrashed()) {
                d3.advanceTowards(doc);
                board.putPiece(d3.getRow(), d3.getCol(), Color.gray);
            }
            
            //Checks if any of the daleks are dolliding with the doctor
            //if they are the doctor is dead and he turns red
            //and a game over message
            if (doc.getRow() == d1.getRow() && doc.getCol() == d1.getCol()
                    || doc.getRow() == d2.getRow() && doc.getCol() == d2.getCol()
                    || doc.getRow() == d3.getRow() && doc.getCol() == d3.getCol()) {
                done = true;
                docDead = true;
                board.removePiece(doc.getRow(), doc.getCol());
                board.putPiece(doc.getRow(), doc.getCol(), Color.yellow);
                board.setMessage("Game Over");
            }

            //prevents the player from making moves while the doctor is dead
            //if the doctor is still alive the coordinates of the click are collected
            if (!docDead) {
                Coordinate c = board.getClick();
                board.removePiece(doc.getRow(), doc.getCol());
                int row = c.getRow();
                int col = c.getCol();
                //checks if the click is more than 1 space away from the doctor
                if (col >= doc.getCol() + 2 || row >= doc.getRow() + 2) {
                    //teleport the doctor to a random location
                    doc.teleport(row, col);
                    //If click is within one space of the doctor
                } else {
                    //Doctor moves to area clicked
                    doc.move(row, col);
                }
                //tells the player how many moves they have made
                timesClicked ++;
                board.setMessage("You have clicked " + timesClicked + " times");
            } 
           
            
            //if all daleks have crashed then the game is won
            if (d1.hasCrashed() && d2.hasCrashed() && d3.hasCrashed()) {
                win = true;
                done = true;
                board.setMessage("You win!");
            }
        }
        //if the doctor won it keeps it's piece on the board
        if (win) {
            board.putPiece(doc.getRow(), doc.getCol(), Color.green);
        }

    }
}
