
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
        Dalek[] dalek = new Dalek[100]; //three daleks on the gameboard
        Doctor theDoctor = new Doctor(rand.nextInt(board.getBoardWidth()), rand.nextInt(board.getBoardLength())); //randomly generate starting position of the doctor 
        boolean gameOver = false; //boolean for whether a gameover event has occurred

        //generating the initial Dalek positions
        for (int x = 0; x < dalek.length; x++) {
            //choose a random position for the Dalek based on the width and length of the game board
            dalek[x] = new Dalek(rand.nextInt(board.getBoardWidth()), rand.nextInt(board.getBoardLength()));
        }
        //checking for duplicate positions
        for (int x = 0; x < dalek.length; x++) {
            //check if any daleks occur at the same position
            for (int y = x+1; y < dalek.length; y++) {
                if (dalek[x].getX() == dalek[y].getX() && dalek[x].getY() == dalek[y].getY()) {
                    dalek[x] = new Dalek(rand.nextInt(board.getBoardWidth()), rand.nextInt(board.getBoardLength())); //generate new position                              
                    if (dalek[x].getX() == theDoctor.getX() && dalek[x].getY() == theDoctor.getY()) {
                        dalek[x] = new Dalek(rand.nextInt(board.getBoardWidth()), rand.nextInt(board.getBoardLength())); //generate new position              

                    }
                    x = 0;
                    y = 0;
                }
            }
            //draw the dalek
            board.putPiece(dalek[x].getX(), dalek[x].getY(), dalek[x].getColour());
        }
        board.putPiece(theDoctor.getX(), theDoctor.getY(), Color.green); //draw the doctor

        while (!gameOver) { //while the game is not over

            Coordinate click = board.getClick(); //waits for and stores the coordinate of the click

            //determining new doctor position
            board.removePiece(theDoctor.getX(), theDoctor.getY()); //remove the old doctor position
            theDoctor.move(click.getX(), click.getY(), board.getBoardWidth(), board.getBoardLength()); //move the Doctor

            //determining new dalek position
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
                //draw the daleks onto the board
                board.putPiece(dalek[x].getX(), dalek[x].getY(), dalek[x].getColour());
                //draw the doctor onto the board

            }
            boolean allDaleksCrashed = true; //boolean that stores whether all the Daleks have crashed
            for (int x = 0; x < dalek.length; x++) { //loop through to check for capture and/or all daleks crashed
                //if any Dalek is still alive
                if (!dalek[x].hasCrashed()) {
                    allDaleksCrashed = false;
                }
                //check if the Doctor has been captured
                if (dalek[x].getX() == theDoctor.getX() && dalek[x].getY() == theDoctor.getY()) {
                    theDoctor.captured(); //invoke capture method
                }
            }
            //draw the doctor
            board.putPiece(theDoctor.getX(), theDoctor.getY(), theDoctor.getColour());
            //check for a game over event
            if (theDoctor.isCaptured()) { //handles doctor capture
                gameOver = true;
                board.setMessage("The Doctor has been captured. Game over.");
            } else if (allDaleksCrashed) { //handles all daleks crashed
                gameOver = true;
                board.setMessage("All Daleks have crashed. Game over.");
            }
        }
    }
}
