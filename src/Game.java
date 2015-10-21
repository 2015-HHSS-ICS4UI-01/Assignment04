
import java.awt.Color;



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
    public static void main(String[] args) throws InterruptedException {
        
        GameBoard board = new GameBoard(8, 8);
        
        final int numDaleks = 3;
        Dalek[] daleks = spawnDaleks(numDaleks, board);
        addDaleks(daleks, board);
        
        Doctor doctor = spawnDoctor(daleks, board);
        addDoctor(doctor, board);
        
        boolean gameon = true;
        while (gameon)
        {
            Coordinate clickPoint = board.getClick();
            if (clickPoint != null)
            {
                //board.putPiece(clickPoint.getRow(), clickPoint.getCol(), Color.RED);
            }
        }
    }
    
    public static void addDoctor(Doctor doctor, GameBoard board)
    {
        board.putPiece(doctor.getRow(), doctor.getCol(), doctor.getColor());
    }
    
    public static void addDaleks(Dalek[] daleks, GameBoard board)
    {
        for (Dalek dalek: daleks)
        {
            board.putPiece(dalek.getRow(), dalek.getCol(), dalek.getColor());
        }
    }
    public static void removeDaleks(Dalek[] daleks, GameBoard board)
    {
        for (int i = 0; i < daleks.length; i ++)
        {
            Dalek curDalek = daleks[i];
            board.removePiece(curDalek.getRow(), curDalek.getCol());
        }
    }
    
    public static Doctor spawnDoctor(Dalek[] daleks, GameBoard board)
    {
        
        int row = 0;
        int col = 0;
        do
        {
            row = (int)(Math.random()*board.getBoardWidth());
            col = (int)(Math.random()*board.getBoardHeight());
        }while (!isValidSpawnLocation(daleks, row, col));
        Doctor doctor = new Doctor(row, col);
        
        return doctor;
    }
    
    /**
     * Adds all the daleks to the daleks array, at a random row and col
     * @param daleks the array to be populated with daleks
     * @param board the board to which the daleks should be added
     */
    public static Dalek[] spawnDaleks(int numDaleks, GameBoard board)
    {
        Dalek[] daleks = new Dalek[numDaleks];
        // spawn each dalek in a random location
        for (int i = 0; i < numDaleks; i ++)
        {
            int col = 0;
            int row = 0;
            do {
                row = (int)(Math.random()*board.getBoardWidth());
                col = (int)(Math.random()*board.getBoardHeight());
            }while (!isValidSpawnLocation(daleks, i, row, col));
            daleks[i] = new Dalek(row, col);
        }
        return daleks;
    }
    
    public static boolean isValidSpawnLocation(Dalek[] daleks, int lastDalekIndex, int row, int col)
    {
        for (int i = 0; i < lastDalekIndex; i++)
        {
            if (daleks[i].getRow() == row && daleks[i].getCol() == col)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean isValidSpawnLocation(Dalek[] daleks, int row, int col)
    {
        for (Dalek dalek: daleks)
        {
            if (dalek.getRow() == row && dalek.getCol() == col)
            {
                return false;
            }
        }
        return true;
    }
    
}
