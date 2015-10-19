
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
        GameBoard board = new GameBoard();

    }
}
