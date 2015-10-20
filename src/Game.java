
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
        Doctor theDoctor = new Doctor(rand.nextInt(8), rand.nextInt(8)); //randomly generate starting position of the doctor 
        boolean gameOver = false;
        
        //generating the initial Dalek positions
        for (int x = 0; x < dalek.length; x++) {
            dalek[x] = new Dalek(rand.nextInt(8), rand.nextInt(8));
            if (dalek[x].getX() == theDoctor.getX() && dalek[x].getY() == theDoctor.getY()) {
                x--; //subtract from the increment value in order to loop again (to get new coordinates)
            } else {
                board.putPiece(dalek[x].getX(), dalek[x].getY(), dalek[x].getColour()); //draw the dalek
            }
        }
        
        board.putPiece(theDoctor.getX(), theDoctor.getY(), Color.green); //draw the doctor
        
        while (!gameOver) { //while nothing has triggered a game over event
            
            Coordinate click = board.getClick(); //waits for and stores the coordinate of the click

            //drawing the Doctor
            board.removePiece(theDoctor.getX(), theDoctor.getY()); //remove the old doctor position
            theDoctor.move(click.getX(), click.getY());
            board.putPiece(theDoctor.getX(), theDoctor.getY(), Color.green); //add new doctor position

            //drawing the Daleks
            for (int x = 0; x < dalek.length; x++) {
                board.removePiece(dalek[x].getX(), dalek[x].getY()); //remove the old dalek
                dalek[x].moveTowards(theDoctor); //move the daleks toward the doctor's new position
            }

            //iterating through daleks to check for a crash
            for (int x = 0; x < dalek.length; x++) {
                for (int y = x + 1; y < dalek.length; y++) {
                    
                    //if the first dalek has crashed with another dalek, invoke the crash method on both.
                    if (dalek[x].getX() == dalek[y].getX() && dalek[x].getY() == dalek[y].getY()) {
                        board.setMessage("Dalek " + (x + 1) + " has crashed with Dalek " + (y + 1));
                        dalek[x].crash();
                        dalek[y].crash();
                    }
                }
            }

            boolean allDaleksCrashed = true; //boolean that stores whether all the Daleks have crashed
            for (int x = 0; x < dalek.length; x++) {
                
                if (!dalek[x].hasCrashed()) { //if any of the daleks are still living, the boolean must be false
                    allDaleksCrashed = false;
                }
                
                //check if the Doctor has been captured
                if (dalek[x].getX() == theDoctor.getX() && dalek[x].getY() == theDoctor.getY()) {
                    theDoctor.captured();
                }
                
                //draw the daleks onto the board
                board.putPiece(dalek[x].getX(), dalek[x].getY(), dalek[x].getColour());
            }

            //check for a game over event
            if (theDoctor.isCaptured() || allDaleksCrashed) {
                gameOver = true;
                board.setMessage("Game Over");
            }
        }
    }

}
