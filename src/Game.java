/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * A Doctor Who style game, with the objective of controlling the Doctor to destroy all of the Daleks
 * @author kobed6328
 */
public class Game {

    static GameBoard board = new GameBoard(30, 30);
    
    static int aliveDaleks = 30;
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
            if (doctor.isDead() || aliveDaleks <= 0)
            {
                gameon = false;
            }
            // draw the board at the end of each turn
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
            if (aliveDaleks > 0)
            {
                board.setMessage("Your Move ");
            }
            else
            {
                board.setMessage("GAME OVER -- YOU WIN ");
            }
        }
        else
        {
            board.setMessage("GAME OVER -- YOU LOSE ");
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
        // for every single dalek, if it has not crashed, check every single dalek but itself for a collision
        for (int i = 0; i < daleks.length; i ++)
        {
            if (!daleks[i].hasCrashed())
            {
                for (int j = 0; j < daleks.length; j ++)
                {
                    // don't check itself
                    if (j != i)
                    {
                        // if the two daleks intersect on the grid
                        if (daleks[i].getRow() == daleks[j].getRow() && daleks[i].getCol() == daleks[j].getCol())
                        {
                            // crash the daleks and decrease alive daleks accordingly
                            daleks[i].crash();
                            aliveDaleks --;
                            // only crash the second dalek if it is still alive
                            if (!daleks[j].hasCrashed())
                            {
                                daleks[j].crash();
                                aliveDaleks --;
                            }
                            // don't check this dalek anymore since it's now dead... simply continue loop
                            break;
                        }
                    }
                }
            }
        }
    }
    /**
     * Kills the doctor if it is on the same grid spot as any Dalek
     */
    public static void crashWithDoctor()
    {
        // check each dalek if it intersects with the doctor
        for (Dalek dalek: daleks)
        {
            // if the doctor and the dalek share the same grispot
            if (dalek.getRow() == doctor.getRow() && dalek.getCol() == doctor.getCol())
            {
                // kill the doctor
                doctor.die();
            }
        }
    }
    /**
     * Removes the doctor from the gameboard
     */
    public static void removeDoctor()
    {
        board.removePiece(doctor.getRow(), doctor.getCol());
    }
    /**
     * Removes the Daleks from the gameboard
     */
    public static void removeDaleks()
    {
        for (int i = 0; i < daleks.length; i ++)
        {
            Dalek curDalek = daleks[i];
            board.removePiece(curDalek.getRow(), curDalek.getCol());
        }
    }
    /**
     * Spawns the doctor at a random location on the board
     */
    public static void spawnDoctor()
    {
        // generate a random coordinate while that coordinate is shared by any Dalek
        Coordinate randCoordinate = null;
        do {
            randCoordinate = genRandomCoordinate();
        }while (!isValidSpawnLocation(randCoordinate));
        doctor = new Doctor(randCoordinate);
    }
    
    /**
     * Spawns the daleks at random lactions on the board
     */
    public static void spawnDaleks()
    {
        daleks = new Dalek[aliveDaleks];
        // populate the dalek array
        for (int i = 0; i < aliveDaleks; i ++)
        {
            // generate a random coordinate while that coordinate is shared by any other dalek
            Coordinate randCoordinate = null;
            do {
                randCoordinate = genRandomCoordinate();
            }while (!isValidSpawnLocation(i, randCoordinate));
            daleks[i] = new Dalek(randCoordinate);
        }
    }
    /**
     * Checks whether a spawn coordinate is shared by any Dalek
     * @param lastDalekIndex the index of the Dalek at which to stop checking (this is used to avoid checking non-spawned Daleks)
     * @param coordinate the coordinate to be checked
     * @return false if the coordinate is shared with any other Dalek; otherwise, return true
     */
    public static boolean isValidSpawnLocation(int lastDalekIndex, Coordinate coordinate)
    {
        // iterate through the dalek array and check for intersections
        // stop once a the non-initialized Dalek index is reached
        for (int i = 0; i < lastDalekIndex; i++)
        {
            if (daleks[i].getRow() == coordinate.getRow() && daleks[i].getCol() == coordinate.getCol())
            {
                return false;
            }
        }
        return true;
    }
    /**
     * Checks whether a spawn coordinate is shared by any Dalek
     * @param coordinate the coordinate to be checked
     * @return false if the coordinate is shared with any other Dalek; otherwise, return true
     */
    public static boolean isValidSpawnLocation(Coordinate coordinate)
    {
        // iterate through all the daleks and check for an intersection
        for (Dalek dalek: daleks)
        {
            if (dalek.getRow() == coordinate.getRow() && dalek.getCol() == coordinate.getCol())
            {
                return false;
            }
        }
        return true;
    }
    /**
     * Checks whether or not a mouse click is within 1 grid space of the Doctor
     * @param click the coordinate of the mouse click
     * @return true if the mouse click is within one tile of the Doctor; otherwise, return false
     */
    public static boolean withinWalkingRange(Coordinate click)
    {
        // get the absolute horizontal and vertical distances between the mouse click and the Doctor's coordinates
        int horizontalDistance = Math.abs(click.getRow() - doctor.getRow());
        int verticalDistance = Math.abs(click.getCol() - doctor.getCol());
        
        return horizontalDistance <= 1 && verticalDistance <= 1;
    }
    /**
     * Moves the doctor to the specified mouse click
     * @param click the coordinate of the mouse click
     */
    public static void moveDoctor(Coordinate click)
    {
        // remove the doctor from the board before moving him
        removeDoctor();
        doctor.moveTo(click);
    }
    /**
     * Teleports the Doctor to a random location on the board
     */
    public static void teleportDoctor()
    {
        Coordinate randCoordinate = genRandomCoordinate();
        moveDoctor(randCoordinate);
    }
    /**
     * Generates a random coordinate
     * @return the random coordinate object
     */
    public static Coordinate genRandomCoordinate()
    {
        // generate a random row and column within the constraints of the board
        int row = (int)(Math.random()*board.getBoardWidth());
        int col = (int)(Math.random()*board.getBoardHeight());
        return new Coordinate(row, col);
    }
    
}
