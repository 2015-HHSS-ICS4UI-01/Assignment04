
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
    public static void main(String[] args) {
        //spawn new gameboard
        GameBoard board = new GameBoard();
        boolean lose = false;
        
        //sapwn doctor and dalek in random positions
        Doctor leo = new Doctor((int)(Math.random() * 8),(int)(Math.random() * 8));
        Dalek dalek = new Dalek((int)(Math.random() * 8),(int)(Math.random() * 8));
        Dalek dalek1 = new Dalek((int)(Math.random() * 8),(int)(Math.random() * 8));
        Dalek dalek2 = new Dalek((int)(Math.random() * 8),(int)(Math.random() * 8));
        
        //put the pieces on the board
        board.putPiece(dalek.getRow(),dalek.getCol(), Color.YELLOW);
        board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.YELLOW);
        board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.YELLOW);
        board.putPiece(leo.getRow(),leo.getCol(), Color.GREEN);
        
        //if not in an end game status, loop
        while((!dalek.hasCrashed()||!dalek1.hasCrashed()||!dalek2.hasCrashed())&&lose == false){
        
            
            //check if dalek1 and dalek has crashed
            if(dalek1.getCol() == dalek.getCol() && dalek1.getRow() == dalek.getRow()){
                //if dalek1 and dalek has crashed, mark them as crashed and turn them red
                dalek.crash();
                dalek1.crash();
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.RED);
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.RED);

            //check if dalek2 and dalek 1 has crashed
            }if(dalek1.getCol() == dalek2.getCol() && dalek1.getRow() == dalek2.getRow()){
                //if dalek 2 and dalek 1 has crashed, mark them as crashed and turn them red
                dalek2.crash();
                dalek1.crash();
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.RED);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.RED);

            }
            //check if dalek2 and dalek has crashed
            if(dalek2.getCol() == dalek.getCol() && dalek2.getRow() == dalek.getRow()){
                //if dalek 2 and dalek has crashed, mark them as crashed and turn them red
                dalek.crash();
                dalek2.crash();
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.RED);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.RED);
            }
            
            //find the clicked coordinates
            Coordinate c = board.getClick();
            
            //reset the locations of the daleks and doctors (remove the previous position)
            board.removePiece(dalek.getRow(),dalek.getCol());
            board.removePiece(dalek1.getRow(),dalek1.getCol());
            board.removePiece(dalek2.getRow(),dalek2.getCol());
            board.removePiece(leo.getRow(),leo.getCol());
            
            
            //find the coordinates of the click
            int row = c.getRow();
            int col = c.getCol();
            
            //use the move command in the doctor to find the new coordinates for the doctor
            leo.move(row,col);
            

            
            //for each of the daleks, if they have not crashed, use the advancetowards command and set the cooridinates to advance towards doctor
            //then put the piece down (yellow)
            if(!dalek.hasCrashed()){
                dalek.advanceTowards(leo);
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.YELLOW);
            }
            if(!dalek1.hasCrashed()){
                dalek1.advanceTowards(leo);
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.YELLOW);
            }
            if(!dalek2.hasCrashed()){
                dalek2.advanceTowards(leo);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.YELLOW);
            }
            
            
            
            
            
            
            
            //put the doctor down (green, because it is still living)
            board.putPiece(leo.getRow(),leo.getCol(), Color.GREEN);
            
           
            
            //if any dalek crashes with doctor, end game by setting doctor yellow, message, and lose to be true
            if((leo.getCol() == dalek.getCol()&&leo.getRow() == dalek.getRow())||(leo.getCol() == dalek1.getCol()&&leo.getRow() == dalek1.getRow())||(leo.getCol() == dalek2.getCol()&&leo.getRow() == dalek2.getRow())){
                board.setMessage("GG, Daleks win");
                board.putPiece(leo.getRow(),leo.getCol(), Color.YELLOW);
                lose = true;
            }
            
            //again, check the collisions between the daleks, ensure that even if lost the crashed doctors still show up in red
            if(dalek1.getCol() == dalek.getCol() && dalek1.getRow() == dalek.getRow()){
                dalek.crash();
                dalek1.crash();
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.RED);
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.RED);

            }if(dalek1.getCol() == dalek2.getCol() && dalek1.getRow() == dalek2.getRow()){
                dalek2.crash();
                dalek1.crash();
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.RED);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.RED);

            }
            if(dalek2.getCol() == dalek.getCol() && dalek2.getRow() == dalek.getRow()){
                dalek.crash();
                dalek2.crash();
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.RED);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.RED);
            }
        
        }
        //when the game ends in a end game situation, if the boolean lose is not true, that means the doctor wins
        //set the message for winning condition
        if(!lose){
        board.setMessage("GG, Doctor Win");
        }
    }
}
