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
        
        //making a boolean for my game
        boolean running = true;
        
        // placing doctor at random spot
        int row = (int)(Math.random()*8);
        int col = (int)(Math.random()*8);
        
        // making doctor
        Doctor mystic = new Doctor(row,col);
        
        // placing a doctor
        board.putPiece(row, col, Color.GREEN);
        
        
        // setting the daleks at a random spot
        Dalek dal1 = new Dalek ((int)(Math.random()*8),((int)(Math.random()*8)));
        Dalek dal2 = new Dalek ((int)(Math.random()*8),((int)(Math.random()*8)));
        Dalek dal3 = new Dalek ((int)(Math.random()*8),((int)(Math.random()*8)));
        
        // finding the first daleks row and colum
        int dal1Row = dal1.getrow();
        int dal1Col = dal1.getcol();
        
        // finding the second daleks row and colum
        int dal2Row = dal2.getrow();
        int dal2Col = dal2.getcol();
        
        // finding the third daleks row and colum
        int dal3Row = dal3.getrow();
        int dal3Col = dal3.getcol();
        
        // making three yellow daleks
        board.putPiece(dal1Row, dal1Col, Color.YELLOW);
        board.putPiece(dal2Row, dal2Col, Color.YELLOW);
        board.putPiece(dal3Row, dal3Col, Color.YELLOW);
        
        // making a loop until running is false
        while(running){ 
        
         //waiting for a click
        Coordinate c = board.getClick();
        
        // removing the last piece on the screen
        board.removePiece(dal1.getrow(), dal1.getcol());
        board.removePiece(dal2.getrow(), dal2.getcol());
        board.removePiece(dal3.getrow(), dal3.getcol());
        board.removePiece(mystic.getRow(), mystic.getCol());
        
        // finding out where they clicked
        row = c.getRow();
        col = c.getCol();
        
        //making the doctor move depending on where they clicked
        mystic.move(row, col); 
        
        
        row = c.getRow();
        col = c.getCol();
        
        // placing a doctor at the new spot
        board.putPiece(mystic.getRow(), mystic.getCol(), Color.GREEN);
        
        // if the first dalek is on a doctor the game ends and the piece turns blue
        if (mystic.getRow() == dal1.getrow() && mystic.getCol() == dal1.getcol()){
            running = false;
            board.removePiece(mystic.getRow(), mystic.getCol());
            board.putPiece(mystic.getRow(), mystic.getCol(), Color.BLUE);
            
            board.removePiece(dal1.getrow(), dal1.getcol());
            dal3.crash();
            board.putPiece(dal1.getrow(), dal1.getcol(), Color.BLUE);
            
            board.setMessage("Doctor Died!");
             
        }
        // if the second dalek is on a doctor the game ends and the piece turns blue
        if (mystic.getRow() == dal2.getrow() && mystic.getCol() == dal2.getcol()){
            running = false;
            board.removePiece(mystic.getRow(), mystic.getCol());
            board.putPiece(mystic.getRow(), mystic.getCol(), Color.BLUE);
            
            board.removePiece(dal2.getrow(), dal2.getcol());
            dal2.crash();
            board.putPiece(dal2.getrow(), dal2.getcol(), Color.BLUE);
            
            board.setMessage("Doctor Died!");
        }
        // if the third dalek is on a doctor the game ends and the piece turns blue
        if (mystic.getRow() == dal3.getrow() && mystic.getCol() == dal3.getcol()){
            running = false;
            board.removePiece(mystic.getRow(), mystic.getCol());
            board.putPiece(mystic.getRow(), mystic.getCol(), Color.BLUE);
            
            board.removePiece(dal3.getrow(), dal3.getcol());
            dal3.crash();
            board.putPiece(dal3.getrow(), dal3.getcol(), Color.BLUE);
            
            board.setMessage("Doctor Died!");
        }
        
        
        
        // if daleks are in the same spot, crash them
        if(dal1.getrow() == dal2.getrow() && dal1.getcol() == dal2.getcol()){
            dal1.crash();
            board.putPiece(dal1.getrow(), dal1.getcol(), Color.RED);
            
            dal2.crash();
            board.putPiece(dal2.getrow(), dal2.getcol(), Color.RED);
        }
        if (dal3.getrow() == dal2.getrow() && dal3.getcol() == dal2.getcol()){
            dal3.crash();
            board.putPiece(dal3.getrow(), dal3.getcol(), Color.RED);
            
            dal2.crash();
            board.putPiece(dal2.getrow(), dal2.getcol(), Color.RED);
        }
        if (dal1.getrow() == dal3.getrow() && dal1.getcol() == dal3.getcol()){
            dal1.crash();
            board.putPiece(dal1.getrow(), dal1.getcol(), Color.RED);
            
            dal3.crash();
            board.putPiece(dal3.getrow(), dal3.getcol(), Color.RED);
        }
        
        // as long as the first dalek isn't crashed. move towards the doctor
        if(!dal1.hasCrashed()){
           dal1.advanceTowards(mystic);
        }
        
        // as long as the second dalek isn't crashed. move towards the doctor
         if(!dal2.hasCrashed()){
           dal2.advanceTowards(mystic);
        }
         
         // as long as the third dalek isn't crashed. move towards the doctor
        if(!dal3.hasCrashed()){
           dal3.advanceTowards(mystic);
        }
        
        //tells user that they have won if all daleks crash
        else if(dal1.hasCrashed() && dal2.hasCrashed() && dal3.hasCrashed()){
            board.setMessage("YOU WIN!");
            running = false;
        }
        // as long as the first dalek isn't crashed. place a new piece
        if(!dal1.hasCrashed()){
            board.putPiece(dal1.getrow(), dal1.getcol(), Color.YELLOW);
        }
        
        // as long as the second dalek isn't crashed. place a new piece
        if(!dal2.hasCrashed()){
            board.putPiece(dal2.getrow(), dal2.getcol(), Color.YELLOW);
        }
            
        // as long as the third dalek isn't crashed. place a new piece
        if(!dal3.hasCrashed()){
            board.putPiece(dal3.getrow(), dal3.getcol(), Color.YELLOW);
        }
        
        // if the first dalek is on a doctor the game ends and the piece turns blue
        if (mystic.getRow() == dal1.getrow() && mystic.getCol() == dal1.getcol()){
            running = false;
            board.removePiece(mystic.getRow(), mystic.getCol());
            board.putPiece(mystic.getRow(), mystic.getCol(), Color.BLUE);
            
            board.removePiece(dal1.getrow(), dal1.getcol());
            dal3.crash();
            board.putPiece(dal1.getrow(), dal1.getcol(), Color.BLUE);
        }
        // if the second dalek is on a doctor the game ends and the piece turns blue
        if (mystic.getRow() == dal2.getrow() && mystic.getCol() == dal2.getcol()){
            running = false;
            board.removePiece(mystic.getRow(), mystic.getCol());
            board.putPiece(mystic.getRow(), mystic.getCol(), Color.BLUE);
            
            board.removePiece(dal2.getrow(), dal2.getcol());
            dal2.crash();
            board.putPiece(dal2.getrow(), dal2.getcol(), Color.BLUE);
        }
        // if the third dalek is on a doctor the game ends and the piece turns blue
        if (mystic.getRow() == dal3.getrow() && mystic.getCol() == dal3.getcol()){
            running = false;
            board.removePiece(mystic.getRow(), mystic.getCol());
            board.putPiece(mystic.getRow(), mystic.getCol(), Color.BLUE);
            
            board.removePiece(dal3.getrow(), dal3.getcol());
            dal3.crash();
            board.putPiece(dal3.getrow(), dal3.getcol(), Color.BLUE);
        }
        
        }
    }
}
