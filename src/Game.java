
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
        Dalek[] daleks = new Dalek[3];
        Doctor doctor = new Doctor(random.nextInt(8), random.nextInt(8));
        for (int x = 0; x < daleks.length; x++) {
            daleks[x] = new Dalek(random.nextInt(8), random.nextInt(8));
        }
        GameBoard board = new GameBoard();

        while (true) {
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
                    System.out.println("hello");
                }
            }
            for (int x = 0; x < daleks.length - 1; x++) {
                for (int y = 1; y + x < daleks.length; y++) {
                    dalekHasCrashed(daleks[x], daleks[x + y]);
                }
            }
        }
    }

    public static void dalekHasCrashed(Dalek dalek1, Dalek dalek2) {
        if (dalek1.getX() == dalek2.getX() && dalek1.getY() == dalek2.getY()) {
            dalek1.crash();
            dalek2.crash();
        }
    }
}
