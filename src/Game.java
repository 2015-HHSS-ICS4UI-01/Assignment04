
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
            if (withinWalkingRange(doctor, clickPoint))
            {
                moveDoctor(doctor, clickPoint, board);
            }
            else
            {
                teleportDoctor(doctor, board);
            }
        }
    }
    
    public static void addDoctor(Doctor doctor, GameBoard board)
    {
        board.putPiece(doctor.getRow(), doctor.getCol(), doctor.getColor());
    }
    public static void removeDoctor(Doctor doctor, GameBoard board)
    {
        board.removePiece(doctor.getRow(), doctor.getCol());
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
            Coordinate randCoordinate = null;
            do {
                randCoordinate = genRandomCoordinate(board);
            }while (!isValidSpawnLocation(daleks, i, randCoordinate));
            daleks[i] = new Dalek(randCoordinate);
        }
        return daleks;
    }
    
    public static boolean isValidSpawnLocation(Dalek[] daleks, int lastDalekIndex, Coordinate coordinate)
    {
        for (int i = 0; i < lastDalekIndex; i++)
        {
            if (daleks[i].getRow() == coordinate.getRow() && daleks[i].getCol() == coordinate.getCol())
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
    
    public static boolean withinWalkingRange(Doctor doctor, Coordinate click)
    {
        int horizontalDistance = Math.abs(click.getRow() - doctor.getRow());
        int verticalDistance = Math.abs(click.getCol() - doctor.getCol());
        
        return horizontalDistance <= 1 && verticalDistance <= 1;
    }
    
    public static void moveDoctor(Doctor doctor, Coordinate click, GameBoard board)
    {
        removeDoctor(doctor, board);
        doctor.moveTo(click);
        addDoctor(doctor, board);
    }
    
    public static void teleportDoctor(Doctor doctor, GameBoard board)
    {
        removeDoctor(doctor, board);
    }
    
    public static Coordinate genRandomCoordinate(GameBoard board)
    {
        int row = (int)(Math.random()*board.getBoardWidth());
        int col = (int)(Math.random()*board.getBoardHeight());
        return new Coordinate(row, col);
    }
    
}
