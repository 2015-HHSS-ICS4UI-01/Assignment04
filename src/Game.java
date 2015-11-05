
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
        
        //checks whether the Doctor has moved or not
        boolean moved = false;
        //checks whether game is still in progress (at least 1 Dalek alive, Doctor alive)
        boolean inProgress = true;
        //checks for any collisions between Daleks/Doctor before allowing a turn
        boolean startCheck = true;
        //checks if the Doctor won or lost the game
        boolean won = true;
        
        //game runs until Doctor is captured or all Daleks have crashed
        while(inProgress){
            //perform checks of positions of doctor/enemies at start up and all future turns
            while(startCheck){      
                
                //check if a pair of daleks are on the same spot
                //if they are, the two daleks crash
                if(dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()){
                    dalek1.crash();
                    dalek2.crash();

                    //repaint the Daleks
                    board.removePiece(dalek1.getRow(), dalek1.getCol());
                    board.removePiece(dalek2.getRow(), dalek2.getCol());
                    board.putPiece(dalek1.getRow(), dalek1.getCol(), Color.RED);
                    
                }if(dalek1.getRow() == dalek3.getRow() && dalek1.getCol() == dalek3.getCol()){
                    dalek1.crash();
                    dalek3.crash();

                    //repaint the Daleks
                    board.removePiece(dalek1.getRow(), dalek1.getCol());
                    board.removePiece(dalek3.getRow(), dalek3.getCol());
                    board.putPiece(dalek1.getRow(), dalek1.getCol(), Color.RED);

                }if(dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()){
                    dalek2.crash();
                    dalek3.crash();

                    //repaint the Daleks
                    board.removePiece(dalek2.getRow(), dalek2.getCol());
                    board.removePiece(dalek3.getRow(), dalek3.getCol());
                    board.putPiece(dalek2.getRow(), dalek2.getCol(), Color.RED);
                }  

                //check if the doctor is on the same spot as each of the dalek
                //if the doctor is, the doctor is captured, and the game ends
                //the player loses the game
                if(doctor.getRow() == dalek1.getRow() && doctor.getCol() == dalek1.getCol()){
                    inProgress = false;

                    //repaint the Doctor
                    board.removePiece(doctor.getRow(), doctor.getCol());
                    board.removePiece(dalek1.getRow(), dalek1.getCol());
                    board.putPiece(doctor.getRow(), doctor.getCol(), Color.YELLOW);
                    
                    won = false;

                }if(doctor.getRow() == dalek2.getRow() && doctor.getCol() == dalek2.getCol()){
                    inProgress = false;

                    //repaint the Doctor
                    board.removePiece(doctor.getRow(), doctor.getCol());
                    board.removePiece(dalek2.getRow(), dalek2.getCol());
                    board.putPiece(doctor.getRow(), doctor.getCol(), Color.YELLOW);
                    
                    won = false;

                }if(doctor.getRow() == dalek3.getRow() && doctor.getCol() == dalek3.getCol()){
                    inProgress = false;

                    //repaint the Doctor
                    board.removePiece(doctor.getRow(), doctor.getCol());
                    board.removePiece(dalek3.getRow(), dalek3.getCol());
                    board.putPiece(doctor.getRow(), doctor.getCol(), Color.YELLOW);
                    
                    won = false;
                    
                }//check if all daleks have crashed
                //if they have, the game ends
                //the player wins the game
                if(dalek1.hasCrashed() && dalek2.hasCrashed() && dalek3.hasCrashed() && won){
                    inProgress = false;
                }
                
                //all checks have been performed, allow Doctor's next turn to be made
                startCheck = false;
            }
            //allow the Doctor to click and move for one turn
            while(!moved && inProgress && !startCheck){
    
                //inform user of how to play 
                board.setMessage("Click yourself (the green peg) to wait, click any of the 8 squares"
                        + " around you to move to that spot, and click anywhere else to randomly teleport.");
                
                //when click is found, move the Doctor based off of the user's click
                Coordinate c = board.getClick();
                int row = c.getRow();
                int col = c.getCol();
                
                //repaint the Doctor
                board.removePiece(doctor.getRow(), doctor.getCol());
                doctor.move(row,col);
                board.putPiece(doctor.getRow(), doctor.getCol(), Color.GREEN);
                
                //Doctor has moved, check for any collisions
                startCheck = true;
                moved = true;
            }
            
            //Daleks move after the Doctor has moved
            while(moved && inProgress && !startCheck){
                //removes the Daleks from the board
                board.removePiece(dalek1.getRow(), dalek1.getCol());
                board.removePiece(dalek2.getRow(), dalek2.getCol());
                board.removePiece(dalek3.getRow(), dalek3.getCol());
                
                //moves the Daleks around on the board
                //if they have not crashed, they will move towards the Doctor
                //if they have crashed, they will remain in the same spot and not move
                if(!dalek1.hasCrashed()){
                    dalek1.advanceTowards(doctor);
                    //repaint the Dalek
                    board.putPiece(dalek1.getRow(), dalek1.getCol(), Color.BLUE);
                }else if(dalek1.hasCrashed()){
                    //repaint the Dalek
                    board.putPiece(dalek1.getRow(), dalek1.getCol(), Color.RED);
                }
                
                if(!dalek2.hasCrashed()){
                    dalek2.advanceTowards(doctor);
                    //repaint the Dalek
                    board.putPiece(dalek2.getRow(), dalek2.getCol(), Color.BLUE);
                }else if(dalek2.hasCrashed()){
                    //repaint the Dalek
                    board.putPiece(dalek2.getRow(), dalek2.getCol(), Color.RED);
                }
                
                if(!dalek3.hasCrashed()){
                    dalek3.advanceTowards(doctor);
                    //repaint the Dalek
                    board.putPiece(dalek3.getRow(), dalek3.getCol(), Color.BLUE);
                }else if(dalek3.hasCrashed()){
                    //repaint the Dalek
                    board.putPiece(dalek3.getRow(), dalek3.getCol(), Color.RED);
                }
                
                //Daleks have moved, check for any collisions
                moved = false;
                startCheck = true;
            }
  
        }
        
        //if the user lost, give the user a game over message
        if(!won){
            board.setMessage("GAME OVER: You were captured.");
        //if the user won, congratulate the user
        }else if(won){
            board.setMessage("All Daleks have been defeated. You Win!");
        }
        
    }
}

