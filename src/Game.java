
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

        Random random = new Random();
        boolean GameOver = false;
        Doctor doctor = new Doctor(random.nextInt(12), random.nextInt(12));
        Dalek[] daleks = new Dalek[142];
        correctSpawnDalek(daleks, random, doctor);
        GameBoard board = new GameBoard();

        while (!GameOver) {
            //place the piece for doctor
            board.putPiece(doctor.getX(), doctor.getY(), Color.GREEN);
            //place the pieces for daleks
            for (Dalek d : daleks) {
                if (!d.hasCrashed()) {
                    board.putPiece(d.getX(), d.getY(), Color.BLACK);
                } else {
                    board.putPiece(d.getX(), d.getY(), Color.RED);
                }
            }

            //move the doctor
            Coordinate c = board.getClick();
            board.removePiece(doctor.getX(), doctor.getY());
            doctor.move(c.getX(), c.getY());

            //move the daleks
            for (Dalek d : daleks) {
                if (!d.hasCrashed()) {
                    board.removePiece(d.getX(), d.getY());
                    d.advanceTowards(doctor);
                }
                if (d.getX() == doctor.getX() && d.getY() == doctor.getY()) {
                    board.setMessage("Game Over");
                    GameOver = true;
                }
            }
            dalekHasCrashed(daleks);
        }
    }

    public static void dalekHasCrashed(Dalek[] daleks) {
        for (int x = 0; x < daleks.length - 1; x++) {
            for (int y = x + 1; y < daleks.length; y++) {
                if (daleks[x].getX() == daleks[y].getX() && daleks[x].getY() == daleks[y].getY()) {
                    daleks[x].crash();
                    daleks[y].crash();
                }
            }
        }

    }

    public static void correctSpawnDalek(Dalek[] daleks, Random random, Doctor doctor) {
        for (int y = 0; y < daleks.length; y++) {
            daleks[y] = new Dalek(random.nextInt(12), random.nextInt(12));
            for (int x = 1; x < daleks.length; x++) {
                if (y - x >= 0) {
                    while ((daleks[y].getX() == daleks[y - x].getX() && daleks[y].getY() == daleks[y - x].getY()) || (daleks[y].getX() == doctor.getX() && daleks[y].getY() == doctor.getY())) {
                        daleks[y] = new Dalek(random.nextInt(12), random.nextInt(12));
                    }
                }
            }


        }
    }
}
