
import java.awt.Color;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author haidj9901
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //initializing objects/variables
        GameBoard board = new GameBoard();
        Random rand = new Random();
        Dalek[] dalek = new Dalek[3]; //three daleks on the gameboard
        Doctor theDoctor = new Doctor(rand.nextInt(board.getBoardWidth()), rand.nextInt(board.getBoardLength())); //randomly generate starting position of the doctor 
        boolean gameOver = false; //boolean for whether a gameover event has occurred

        //generating the initial Dalek positions
        for (int x = 0; x < dalek.length; x++) {
            //choose a random position for the Dalek based on the width and length of the game board
            dalek[x] = new Dalek(rand.nextInt(board.getBoardWidth()), rand.nextInt(board.getBoardLength()));
            //check if the dalek spawned in the same position as the Doctor
            if (dalek[x].getX() == theDoctor.getX() && dalek[x].getY() == theDoctor.getY()) {
                x--; //loop this dalek position to get a new position
            } else {
                //draw the dalek
                board.putPiece(dalek[x].getX(), dalek[x].getY(), dalek[x].getColour());
            }
        }

        board.putPiece(theDoctor.getX(), theDoctor.getY(), Color.green); //draw the doctor

        while (!gameOver) { //while the game is not over

            Coordinate click = board.getClick(); //waits for and stores the coordinate of the click

            //drawing the Doctor
            board.removePiece(theDoctor.getX(), theDoctor.getY()); //remove the old doctor position
            theDoctor.move(click.getX(), click.getY(), board.getBoardWidth(), board.getBoardLength()); //move the Doctor
            board.putPiece(theDoctor.getX(), theDoctor.getY(), Color.green); //add new doctor position

            //drawing the Daleks
            for (int x = 0; x < dalek.length; x++) {
                board.removePiece(dalek[x].getX(), dalek[x].getY()); //remove the old dalek
                dalek[x].moveTowards(theDoctor); //move the daleks toward the doctor's new position
            }

            //iterating through all the daleks to check for a crash
            for (int x = 0; x < dalek.length; x++) {
                for (int y = x + 1; y < dalek.length; y++) {
                    //if the first dalek has crashed with another dalek,
                    if (dalek[x].getX() == dalek[y].getX() && dalek[x].getY() == dalek[y].getY()) {
                        //informs user of crash
                        board.setMessage("Dalek " + (x + 1) + " has crashed with Dalek " + (y + 1));
                        //invoke crash method
                        dalek[x].crash();
                        dalek[y].crash();
                    }
                }
            }

            boolean allDaleksCrashed = true; //boolean that stores whether all the Daleks have crashed
            for (int x = 0; x < dalek.length; x++) {
                //if any Dalek is still alive
                if (!dalek[x].hasCrashed()) {
                    allDaleksCrashed = false;
                }
                //check if the Doctor has been captured
                if (dalek[x].getX() == theDoctor.getX() && dalek[x].getY() == theDoctor.getY()) {
                    theDoctor.captured(); //invoke capture method
                    board.setMessage("The Doctor has been captured by Dalek " + (x + 1) + "!");
                }

                //draw the daleks onto the board
                board.putPiece(dalek[x].getX(), dalek[x].getY(), dalek[x].getColour());
            }

            //check for a game over event
            if (theDoctor.isCaptured() || allDaleksCrashed) {
                gameOver = true;
            }
        }
    }
}
