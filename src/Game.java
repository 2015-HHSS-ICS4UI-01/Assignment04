
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

        Random random = new Random(); //used to randomly spawn objects
        boolean GameOver = false; // indicates the progress of the game
        boolean allDaleksCrashed = true;

        Doctor doctor = new Doctor(random.nextInt(12), random.nextInt(12)); //spawn the doctor
        Dalek[] daleks = new Dalek[2]; // initialize dalek array
        correctlySpawnDaleks(daleks, random, doctor); // calls helper method to correctly spawn daleks
        GameBoard board = new GameBoard(); //the game board

        while (!GameOver) { //if game is still running 

            //place the piece for doctor
            board.putPiece(doctor.getX(), doctor.getY(), Color.GREEN);
            //place the pieces for daleks
            for (Dalek d : daleks) {
                if (!d.hasCrashed()) { // if the dalek hasn't crashed yet
                    board.putPiece(d.getX(), d.getY(), Color.BLACK);
                } else { //if the dalek has crashed, turn the crash site red
                    board.putPiece(d.getX(), d.getY(), Color.RED);
                }
            }

            //move the doctor by getting the coordinate of the user's click and moving according to game rules
            Coordinate c = board.getClick();
            board.removePiece(doctor.getX(), doctor.getY());
            doctor.move(c.getX(), c.getY());
            //move the daleks in accordance to the doctor's position
            for (Dalek d : daleks) {
                if (!d.hasCrashed()) {  // if they havent crashed, remove the piece and move its position towards doctor
                    board.removePiece(d.getX(), d.getY());
                    d.advanceTowards(doctor);
                }
                if (d.getX() == doctor.getX() && d.getY() == doctor.getY()) { // if the dalek catches the doctor
                    GameOver = true; // end game
                }
            }
            dalekHasCrashed(daleks); // check if the dalek's new positions cause them to be crashed, and if so, crash them
            allDaleksCrashed = true;
            for (Dalek d : daleks) {
                if (!d.hasCrashed()) {
                    allDaleksCrashed = false;
                }
            }
            if (allDaleksCrashed) {
                GameOver = true;
            }
        }
        // if the game ends, draw the board for the last time
        for (Dalek d : daleks) { // same as above method
            if (!d.hasCrashed()) {
                board.putPiece(d.getX(), d.getY(), Color.BLACK);
            } else {
                board.putPiece(d.getX(), d.getY(), Color.RED);
            }
        }
        if (allDaleksCrashed) {
            board.putPiece(doctor.getX(), doctor.getY(), Color.YELLOW); //place the doctor as yellow if caught
        } else {
            board.putPiece(doctor.getX(), doctor.getY(), Color.GREEN); //place the doctor as green if user won
        }
        board.setMessage("Game Over");
    }

    /**
     * Check if the daleks have crashed
     *
     * @param daleks array containing the daleks to be checked
     */
    public static void dalekHasCrashed(Dalek[] daleks) {
        boolean allCrashed = true;
        for (int x = 0; x < daleks.length - 1; x++) {
            for (int y = x + 1; y < daleks.length; y++) {
                //if the position of one dalek equals the position of another dalek
                if (daleks[x].getX() == daleks[y].getX() && daleks[x].getY() == daleks[y].getY()) {
                    daleks[x].crash();
                    daleks[y].crash();
                } else {
                    allCrashed = false;
                }
            }
        }

    }

    /**
     * Spawns the daleks correctly without overlapping daleks with other daleks
     * or with doctors
     *
     * @param daleks array of daleks to be checked for spawn
     * @param random random to randomize locations of daleks
     * @param doctor doctor object to check whether it conflicts with a dalek
     * spawn
     */
    public static void correctlySpawnDaleks(Dalek[] daleks, Random random, Doctor doctor) {
        boolean swapped = false;

        //for each spot in the dalek array
        for (int y = 0; y < daleks.length; y++) {
            //initialize location in array
            daleks[y] = new Dalek(random.nextInt(12), random.nextInt(12));
            do {
                swapped = false; //daleks original position has not been swapped for a new one
                for (int x = y - 1; x >= 0; x--) {
                    //check if the dalek that has just been initialized has the same position as the daleks initialized before
                    if ((daleks[y].getX() == daleks[x].getX() && daleks[y].getY() == daleks[x].getY())
                            || (daleks[y].getX() == doctor.getX() && daleks[y].getY() == doctor.getY())) {

                        //if the position is the same, swap the location of the newly initialized dalek
                        daleks[y] = new Dalek(random.nextInt(12), random.nextInt(12));
                        //mark as true in order to indicate that it was swapped. allows it to run to ensure the new location isn't the same as another dalek
                        swapped = true;
                    }
                }
            } while (swapped); //continue running while swapped was true
        }
    }
}
