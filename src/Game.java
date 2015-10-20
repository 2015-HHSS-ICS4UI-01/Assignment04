
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
        Doctor doctor = new Doctor(random.nextInt(8), random.nextInt(8));
        Dalek dalek1 = new Dalek(random.nextInt(8), random.nextInt(8));
        Dalek dalek2 = new Dalek(random.nextInt(8), random.nextInt(8));
        Dalek dalek3 = new Dalek(random.nextInt(8), random.nextInt(8));
        GameBoard board = new GameBoard();

        while (true) {
            board.putPiece(doctor.getX(), doctor.getY(), Color.BLUE);
            board.putPiece(dalek1.getX(), dalek1.getY(), Color.YELLOW);
            board.putPiece(dalek2.getX(), dalek2.getY(), Color.YELLOW);
            board.putPiece(dalek3.getX(), dalek3.getY(), Color.YELLOW);

            //move the doctor
            Coordinate c = board.getClick();
            board.removePiece(doctor.getX(), doctor.getY());
            doctor.move(c.getX(), c.getY());

            //move the daleks
            board.removePiece(dalek1.getX(), dalek1.getY());
            board.removePiece(dalek2.getX(), dalek2.getY());
            board.removePiece(dalek3.getX(), dalek3.getY());
            dalek1.advanceTowards(doctor);
            dalek2.advanceTowards(doctor);
            dalek3.advanceTowards(doctor);
            if (dalek1.getX() == doctor.getX() && dalek1.getY() == doctor.getY()
                    || dalek2.getX() == doctor.getX() && dalek2.getY() == doctor.getY()
                    || dalek3.getX() == doctor.getX() && dalek3.getY() == doctor.getY()) {
                break;
            }
        }
    }
}
