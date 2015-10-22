
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
        boolean GameOver = false;
        Doctor doctor = new Doctor(random.nextInt(8), random.nextInt(8));
        correctSpawnDalek(daleks, random, doctor);
//        correctSpawnDoctor(daleks, random);
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
            for (int y = 1; y + x < daleks.length; y++) {
                if (daleks[x].getX() == daleks[y].getX() && daleks[x].getY() == daleks[y].getY()) {
                    daleks[x].crash();
                    daleks[y].crash();
                }
            }
        }

    }

    public static void spawnDalek(Dalek[] daleks, Random random) {
        for (int x = 0; x < daleks.length; x++) {
            daleks[x] = new Dalek(random.nextInt(8), random.nextInt(8));
        }
    }

    public static void correctSpawnDalek(Dalek[] daleks, Random random, Doctor doctor) {
        spawnDalek(daleks, random);
        for (int x = 0; x < daleks.length-1; x++) {
            for (int y = 1; y + x < daleks.length; y++) {
                if ((daleks[x].getX() == daleks[y].getX() && daleks[x].getY() == daleks[y].getY()) || (daleks[x].getX() == doctor.getX() && daleks[x].getY() == doctor.getY())) {
                    spawnDalek(daleks, random);
                }
            }
        }

    }

    public static void correctSpawnDoctor(Dalek[] daleks, Random random) {
        Doctor doctor = new Doctor(random.nextInt(8), random.nextInt(8));
        int x = 0;
        while (doctor.getX() == daleks[x].getX() && doctor.getY() == daleks[x].getY() && x < daleks.length) {
            doctor = new Doctor(random.nextInt(8), random.nextInt(8));
            x++;
        }
    }
}
