
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
        
        //randomize the spawning position of dalek three
        Doctor doc = new Doctor((int)(Math.random()*8),(int)(Math.random()*8));
        //randomize the spawning position of dalek three
        Dalek dalekone = new Dalek((int)(Math.random()*8),(int)(Math.random()*8));
        //randomize the spawning position of dalek three
        Dalek dalektwo = new Dalek((int)(Math.random()*8),(int)(Math.random()*8));
        //randomize the spawning position of dalek three
        Dalek dalekthree = new Dalek((int)(Math.random()*8),(int)(Math.random()*8));
        
        //click counter
        int click = 0;
        
        //draw the dalek and the doctor on the board
        board.putPiece(doc.getx(), doc.gety(), Color.GREEN);
        board.putPiece(dalekone.getx(), dalekone.gety(), Color.BLUE);
        board.putPiece(dalektwo.getx(), dalektwo.gety(), Color.BLUE);
        board.putPiece(dalekthree.getx(), dalekthree.gety(), Color.BLUE);
        board.printBoard();
        
       while(true){
            //wait for the user to click
           //get the click coordinate
            Coordinate c = board.getClick();
            //when its clicked, remove the doctor from his position
            board.removePiece(doc.getx(), doc.gety());
            click++;
            //the click coordinates are the new doctor x and y
            int x = c.getRow();
            int y = c.getCol();
            //use the doctor's move methor
            doc.move(x, y);
            //put a piece where they clicked or random position
            board.putPiece(doc.getx(), doc.gety(), Color.GREEN);
            
            //check if the first dalek is not crashed
            if(!dalekone.hasCrashed()){
            //get dalek one to move towards the doctor
            //remove the daleks piece to move it to another spot
            board.removePiece(dalekone.getx(), dalekone.gety());
            dalekone.advanceTowards(doc);
            //put the dalek in the new position closer to the doctor
            board.putPiece(dalekone.getx(),dalekone.gety(), Color.BLUE);
            }
            
            //check if the first dalek is not crashed
            if(!dalektwo.hasCrashed()){
            //get dalek two to move towards the doctor
            //remove the daleks piece to move it to another spot
            board.removePiece(dalektwo.getx(), dalektwo.gety());
            dalektwo.advanceTowards(doc);
            //put the dalek in the new position closer to the doctor
            board.putPiece(dalektwo.getx(),dalektwo.gety(), Color.BLUE);
            }
            
            if(!dalekthree.hasCrashed()){
            //get third dalek to move towards the doctor
            //remove the daleks piece to move it to another spot
            board.removePiece(dalekthree.getx(), dalekthree.gety());
            dalekthree.advanceTowards(doc);
            //put the dalek in the new position closer to the doctor
            board.putPiece(dalekthree.getx(),dalekthree.gety(), Color.BLUE); 
            }
            
            //if dalek one crashes with dalek two
            if(dalekone.getx() == dalektwo.getx() && dalekone.gety() == dalektwo.gety())
            {
                //go to their crash methods
                dalekone.crash();
                dalektwo.crash();
                //remove their pieces
                board.removePiece(dalekone.getx(), dalekone.gety());
                board.removePiece(dalektwo.getx(), dalektwo.gety());
                //put a crash piece 
                board.putPiece(dalekone.getx(), dalekone.gety(), Color.YELLOW);
                board.setMessage("Yes! You got two Daleks to crash!");
            }
            
            //if dalek one crashes with dalek three
            if(dalekone.getx() == dalekthree.getx() && dalekone.gety() == dalekthree.gety())
            {
                //go to their crash methods
                dalekone.crash();
                dalekthree.crash();
                //remove their pieces
                board.removePiece(dalekone.getx(), dalekone.gety());
                board.removePiece(dalekthree.getx(), dalekthree.gety());
                //put a crash piece 
                board.putPiece(dalekone.getx(), dalekone.gety(), Color.YELLOW);
                board.setMessage("Yes! You got two Daleks to crash!");
            }
            
            //if dalek two crashes with dalek three
            if(dalektwo.getx() == dalekthree.getx() && dalektwo.gety() == dalekthree.gety())
            {
                //go to their crash methods
                dalektwo.crash();
                dalekthree.crash();
                //remove their pieces
                board.removePiece(dalektwo.getx(), dalektwo.gety());
                board.removePiece(dalekthree.getx(), dalekthree.gety());
                //put a crash piece 
                board.putPiece(dalektwo.getx(), dalektwo.gety(), Color.YELLOW);
                board.setMessage("Yes! You got two Daleks to crash!");
            }
            
            //if all daleks crash
            if(dalekone.hasCrashed() && dalektwo.hasCrashed() && dalekthree.hasCrashed())
            {
                board.setMessage("You have won! You won in " + click + " moves!");
                //end the game
                break;
            }
            
            //if dalek one captures doctor
            if(dalekone.getx() == doc.getx() && dalekone.gety() == doc.gety())
            {
                //remove their pieces
                board.removePiece(dalekone.getx(), dalekone.gety());
                board.removePiece(doc.getx(), doc.gety());
                //put a crash piece 
                board.putPiece(doc.getx(), doc.gety(), Color.RED);
                board.setMessage("You have been captured. You lose.");
                //end the game
                break;
            }
            
            //if dalek two captures doctor
            if(dalektwo.getx() == doc.getx() && dalektwo.gety() == doc.gety())
            {
                //remove their pieces
                board.removePiece(dalektwo.getx(), dalektwo.gety());
                board.removePiece(doc.getx(), doc.gety());
                //put a crash piece 
                board.putPiece(doc.getx(), doc.gety(), Color.RED);
                board.setMessage("You have been captured. You lose.");
                //end the game
                break;
            }
            
            //if dalek one captures doctor
            if(dalekthree.getx() == doc.getx() && dalekthree.gety() == doc.gety())
            {
                //remove their pieces
                board.removePiece(dalekthree.getx(), dalekthree.gety());
                board.removePiece(doc.getx(), doc.gety());
                //put a crash piece 
                board.putPiece(doc.getx(), doc.gety(), Color.RED);
                board.setMessage("You have been captured. You lose.");
                //end the game
                break;
            }
        }
    }
}
