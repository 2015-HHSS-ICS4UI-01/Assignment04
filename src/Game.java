



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * A Doctor Who style game, with the objective of controlling the Doctor to destroy all of the Daleks
 * @author kobed6328
 */
public class Game {

    static GameBoard board = new GameBoard(70, 70);
    
    static int numMoves = 0;
    static int numDaleks = 60;
    // array to store the daleks
    static Dalek[] daleks;
    
    static Doctor doctor;
    
    public static void main(String[] args) throws InterruptedException {
        
        // spawn the daleks and the doctor only at the beginning of the game
        spawnDaleks();
        spawnDoctor();
        // draw the board once before the game loop starts
        drawBoard();
        
        boolean gameon = true;
        while (gameon)
        {
            // wait for the player to click the mouse
            Coordinate clickPoint = board.getClick();
            // if the player clicks within one tile of the doctor, move the doctor to that tile
            if (withinWalkingRange(clickPoint))
            {
                moveDoctor(clickPoint);
            }
            // otherwise, teleport the doctor to a random position on the board
            else
            {
                teleportDoctor();
            }
            // after the doctor has moved, move all the daleks towards the doctor's new location
            moveDaleks();
            // stop the game once the doctor is dead or all of the daleks are crashed
            if (doctor.isDead() || numDaleks <= 0)
            {
                gameon = false;
            }
            // draw the board at the end of each turn
            numMoves ++;
            drawBoard();
        }
    }
    
    /**
     * Draws the Daleks, the doctor, and a message onto the GameBoard
     * 
     */
    public static void drawBoard()
    {
        for (Dalek dalek: daleks)
        {
            board.putPiece(dalek.getRow(), dalek.getCol(), dalek.getColor());
        }
        board.putPiece(doctor.getRow(), doctor.getCol(), doctor.getColor());
        
        // prompts the user to move while they are alive and there are daleks on the board. 
        // if no more daleks, YOU WIN
        // otherwise, YOU LOSE
        if (!doctor.isDead())
        {
            if (numDaleks > 0)
            {
                board.setMessage("Your Move " + numMoves);
            }
            else
            {
                board.setMessage("GAME OVER -- YOU WIN " + numMoves);
            }
        }
        else
        {
            board.setMessage("GAME OVER -- YOU LOSE " + numMoves);
        }
    }
    
    /**
     * Moves the Daleks towards the Doctor
     */
    public static void moveDaleks()
    {
        // remove the Daleks from their old position so they aren't duplicated
        removeDaleks();
        
        for (Dalek dalek: daleks)
        {
            // only move the Daleks that haven't crashed
            if (!dalek.hasCrashed())
            {
                // get the corresponding direction unit value
                int horizontalDistance = Integer.signum(doctor.getRow() - dalek.getRow());
                int verticalDistance = Integer.signum(doctor.getCol()- dalek.getCol());

                int newRow = dalek.getRow() + horizontalDistance;
                int newCol = dalek.getCol() + verticalDistance;

                dalek.moveTo(new Coordinate(newRow, newCol));
            }
        }
        // crash any daleks that are on the same grid spot
        crashDaleks();
        // kill the doctor if he is on the same gridspace as any daleks
        crashWithDoctor();
    }
    
    /**
     * Crashes any Daleks that are on the same grid spot
     */
    public static void crashDaleks()
    {
        for (int i = 0; i < daleks.length-1; i ++)
        {
            if (!daleks[i].hasCrashed())
            {
                for (int j = i+1; j < daleks.length; j ++)
                {
                    if (daleks[i].getRow() == daleks[j].getRow() && daleks[i].getCol() == daleks[j].getCol())
                    {
                        daleks[i].crash();
                        daleks[j].crash();
                    }
                }
            }
        }
    }
    
    public static void crashWithDoctor()
    {
        for (Dalek dalek: daleks)
        {
            if (dalek.getRow() == doctor.getRow() && dalek.getCol() == doctor.getCol())
            {
                numDaleks --;
                doctor.die();
            }
        }
    }
    
   // public static void collideDaleks()
    
    public static void removeDoctor()
    {
        board.removePiece(doctor.getRow(), doctor.getCol());
    }
    
    public static void removeDaleks()
    {
        for (int i = 0; i < daleks.length; i ++)
        {
            Dalek curDalek = daleks[i];
            board.removePiece(curDalek.getRow(), curDalek.getCol());
        }
    }
    public static void spawnDoctor()
    {
        
        Coordinate randCoordinate = null;
        do {
            randCoordinate = genRandomCoordinate();
        }while (!isValidSpawnLocation(daleks, randCoordinate));
        doctor = new Doctor(randCoordinate);
    }
    
    /**
     * Adds all the daleks to the daleks array, at a random row and col
     * @param daleks the array to be populated with daleks
     * @param board the board to which the daleks should be added
     */
    public static void spawnDaleks()
    {
        daleks = new Dalek[numDaleks];
        // spawn each dalek in a random location
        for (int i = 0; i < numDaleks; i ++)
        {
            Coordinate randCoordinate = null;
            do {
                randCoordinate = genRandomCoordinate();
            }while (!isValidSpawnLocation(daleks, i, randCoordinate));
            daleks[i] = new Dalek(randCoordinate);
        }
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
    public static boolean isValidSpawnLocation(Dalek[] daleks, Coordinate coordinate)
    {
        for (Dalek dalek: daleks)
        {
            if (dalek.getRow() == coordinate.getRow() && dalek.getCol() == coordinate.getCol())
            {
                return false;
            }
        }
        return true;
    }
    
    public static boolean withinWalkingRange(Coordinate click)
    {
        int horizontalDistance = Math.abs(click.getRow() - doctor.getRow());
        int verticalDistance = Math.abs(click.getCol() - doctor.getCol());
        
        return horizontalDistance <= 1 && verticalDistance <= 1;
    }
    
    public static void moveDoctor(Coordinate click)
    {
        removeDoctor();
        doctor.moveTo(click);
    }
    
    public static void teleportDoctor()
    {
        Coordinate randCoordinate = genRandomCoordinate();
        moveDoctor(randCoordinate);
    }
    
    public static Coordinate genRandomCoordinate()
    {
        int row = (int)(Math.random()*board.getBoardWidth());
        int col = (int)(Math.random()*board.getBoardHeight());
        return new Coordinate(row, col);
    }
    
}
