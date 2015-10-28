
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
        GameBoard board = new GameBoard();
        
        //creates the player Doctor and enemy Daleks
        //when put on the board, they will be in random spots
        Doctor doctor = new Doctor((int) (Math.random()*8), (int) (Math.random()*8));
        Dalek dalek1 = new Dalek((int) (Math.random()*8), (int) (Math.random()*8));
        Dalek dalek2 = new Dalek((int) (Math.random()*8), (int) (Math.random()*8));
        Dalek dalek3 = new Dalek((int) (Math.random()*8), (int) (Math.random()*8));
        
        //paints the Doctor and Daleks on the board
        board.putPiece(doctor.getRow(), doctor.getCol(), Color.GREEN);
        board.putPiece(dalek1.getRow(), dalek1.getCol(), Color.BLUE);
        board.putPiece(dalek2.getRow(), dalek2.getCol(), Color.BLUE);
        board.putPiece(dalek3.getRow(), dalek3.getCol(), Color.BLUE);
        
        boolean moved = false;
        boolean inProgress = true;
        boolean startCheck = true;
        
        while(inProgress){
            //perform checks of positions of doctor/enemies at start up
            //check if a pair of daleks are on the same spot
            //if they are, the two daleks crash
            while(startCheck){
                if(dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()){
                    dalek1.crash();
                    dalek2.crash();

                    //repaint the board
                    board.removePiece(dalek1.getRow(), dalek1.getCol());
                    board.removePiece(dalek2.getRow(), dalek2.getCol());
                    board.putPiece(dalek1.getRow(), dalek1.getCol(), Color.RED);
                }if(dalek1.getRow() == dalek3.getRow() && dalek1.getCol() == dalek3.getCol()){
                    dalek1.crash();
                    dalek3.crash();

                    //repaint the board
                    //board.clearBoard();
                    board.removePiece(dalek1.getRow(), dalek1.getCol());
                    board.removePiece(dalek3.getRow(), dalek3.getCol());
                    board.putPiece(dalek1.getRow(), dalek1.getCol(), Color.RED);

                }if(dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()){
                    dalek2.crash();
                    dalek3.crash();

                    //repaint the board
                    //board.clearBoard();
                    board.removePiece(dalek2.getRow(), dalek2.getCol());
                    board.removePiece(dalek3.getRow(), dalek3.getCol());
                    board.putPiece(dalek2.getRow(), dalek2.getCol(), Color.RED);
                }  

                //check if the doctor is on the same spot as a dalek
                //if the doctor is, the doctor dies and the game ends
                if(doctor.getRow() == dalek1.getRow() && doctor.getCol() == dalek1.getCol()){
                    inProgress = false;

                    //repaint board
                    board.removePiece(doctor.getRow(), doctor.getCol());
                    board.removePiece(dalek1.getRow(), dalek1.getCol());
                    board.putPiece(doctor.getRow(), doctor.getCol(), Color.YELLOW);

                }if(doctor.getRow() == dalek2.getRow() && doctor.getCol() == dalek2.getCol()){
                    inProgress = false;

                    //repaint board
                    board.removePiece(doctor.getRow(), doctor.getCol());
                    board.removePiece(dalek2.getRow(), dalek2.getCol());
                    board.putPiece(doctor.getRow(), doctor.getCol(), Color.YELLOW);

                }if(doctor.getRow() == dalek3.getRow() && doctor.getCol() == dalek3.getCol()){
                    inProgress = false;

                    //repaint board
                    board.removePiece(doctor.getRow(), doctor.getCol());
                    board.removePiece(dalek3.getRow(), dalek3.getCol());
                    board.putPiece(doctor.getRow(), doctor.getCol(), Color.YELLOW);
                }if(dalek1.hasCrashed() && dalek2.hasCrashed() && dalek3.hasCrashed()){
                    inProgress = false;
                }
                
                startCheck = false;
            }
             
            while(!moved && inProgress && !startCheck){

                  Coordinate c = board.getClick();
                  int row = c.getRow();
                  int col = c.getCol();
                  board.removePiece(doctor.getRow(), doctor.getCol());
                  doctor.move(row,col);
                  board.putPiece(doctor.getRow(), doctor.getCol(), Color.GREEN);
                
                startCheck = true;
                moved = true;
            }
            
            while(moved && inProgress && !startCheck){
                //removes the Daleks from the board
                board.removePiece(dalek1.getRow(), dalek1.getCol());
                board.removePiece(dalek2.getRow(), dalek2.getCol());
                board.removePiece(dalek3.getRow(), dalek3.getCol());
                
                //moves the Daleks around on the board
                //if they have not crashed, they will move towards the Doctor
                //if they have crashed, they well remain in the same spot
                if(!dalek1.hasCrashed()){
                    dalek1.advanceTowards(doctor);
                    board.putPiece(dalek1.getRow(), dalek1.getCol(), Color.BLUE);
                }else if(dalek1.hasCrashed()){
                    board.putPiece(dalek1.getRow(), dalek1.getCol(), Color.RED);
                }
                if(!dalek2.hasCrashed()){
                    dalek2.advanceTowards(doctor);
                    board.putPiece(dalek2.getRow(), dalek2.getCol(), Color.BLUE);
                }else if(dalek2.hasCrashed()){
                    board.putPiece(dalek2.getRow(), dalek2.getCol(), Color.RED);
                }
                if(!dalek3.hasCrashed()){
                    dalek3.advanceTowards(doctor);
                    board.putPiece(dalek3.getRow(), dalek3.getCol(), Color.BLUE);
                }else if(dalek3.hasCrashed()){
                    board.putPiece(dalek3.getRow(), dalek3.getCol(), Color.RED);
                }
                
                moved = false;
                startCheck = true;
            }
  
        }
            
    }
}

