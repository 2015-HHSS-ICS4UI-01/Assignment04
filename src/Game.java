
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
    
    
    
    public static void main(String[] args) {
        
        
        
        //initiates the doctors coordinates
        int docRow = (int)(Math.random()*8); 
        int docCol = (int)(Math.random()*8); 
        
        //initiates the daleks coordinates
        int dalRow1 = (int)(Math.random()*8); 
        int dalCol1 = (int)(Math.random()*8); 
        int dalRow2 = (int)(Math.random()*8); 
        int dalCol2 = (int)(Math.random()*8); 
        int dalRow3 = (int)(Math.random()*8); 
        int dalCol3 = (int)(Math.random()*8); 
        
        //creates the gameboard to work on
        GameBoard board = new GameBoard();
        
        //creates the pegs for the daleks and the doctor
        Dalek one = new Dalek(dalRow1, dalCol1);
        Dalek two = new Dalek(dalRow2, dalCol2);
        Dalek three = new Dalek(dalRow3, dalCol3);
        Doctor nima = new Doctor(docRow, docCol);
                      
        //randomly spawns the daleks and the doctor
        board.putPiece(nima.getRow(), nima.getCol() , Color.YELLOW);
        board.putPiece(one.getRow(), one.getCol(), Color.BLUE);
        board.putPiece(dalRow2, dalCol2, Color.BLUE);
        board.putPiece(dalRow3, dalCol3, Color.BLUE);
        
        boolean game = true;
        
        while(game){
        
        //makes the doctor move and do his thing
        Coordinate click = board.getClick();
        
        //removes all the pieces after a click
        board.removePiece(nima.getRow(), nima.getCol());
        board.removePiece(one.getRow(), one.getCol());
        board.removePiece(two.getRow(), two.getCol());
        board.removePiece(three.getRow(), three.getCol());
        
        //moves the doctor
        nima.move(click.getRow(), click.getCol());
        board.putPiece(nima.getRow(), nima.getCol() , Color.YELLOW);
        
        //moving the daleks
        one.advanceTowards(nima);
        board.putPiece(one.getRow(), one.getCol() , Color.BLUE);
        two.advanceTowards(nima);
        board.putPiece(two.getRow(), two.getCol() , Color.BLUE);
        three.advanceTowards(nima);
        board.putPiece(three.getRow(), three.getCol() , Color.BLUE);
        
        //crashing the daleks
        if(one.getRow() == two.getRow() && one.getCol() == two.getCol()){
            //if they crashed then remove them
            board.removePiece(one.getRow(), one.getCol());
            board.removePiece(two.getRow(), two.getCol());
            //add a new piece at the spot they crashed
            board.putPiece(one.getRow(), one.getCol(), Color.RED);
            
            one.crash();
            two.crash();
        }
        
        if(three.getRow() == two.getRow() && three.getCol() == two.getCol()){
            //if they crashed then remove them
            board.removePiece(three.getRow(), three.getCol());
            board.removePiece(two.getRow(), two.getCol());
            //add a new piece at the spot they crashed
            board.putPiece(two.getRow(), two.getCol(), Color.RED);    
            
            three.crash();
            two.crash();
        }
        
        if(one.getRow() == three.getRow() && one.getCol() == three.getCol()){
            //if they crashed then remove them
            board.removePiece(one.getRow(), one.getCol());
            board.removePiece(three.getRow(), three.getCol());
            //add a new piece at the spot they crashed
            board.putPiece(three.getRow(), three.getCol(), Color.RED); 
            
            one.crash();
            three.crash();
            
            
        }        
        
        if((nima.getRow() == one.getRow() && nima.getCol() == one.getCol()) || (nima.getRow() == two.getRow() && nima.getCol() == two.getCol()) ||
                (nima.getRow() == three.getRow() && nima.getCol() == three.getCol())){
            
            board.setMessage("YOU LOSE!!!");
            
            if(nima.getRow() == one.getRow() && nima.getCol() == one.getCol()){
                board.removePiece(nima.getRow(), nima.getCol());
                board.removePiece(one.getRow(), one.getCol());
                
                board.putPiece(one.getRow(), one.getCol(), Color.RED);
                
                one.crash();
                
                game = false;
                
            }else if(nima.getRow() == two.getRow() && nima.getCol() == two.getCol()){
                board.removePiece(nima.getRow(), nima.getCol());
                board.removePiece(two.getRow(), two.getCol());
                
                board.putPiece(two.getRow(), two.getCol(), Color.RED);
                
                two.crash();
                
                game = false;
                
            }else if(nima.getRow() == three.getRow() && nima.getCol() == three.getCol()){
                
                board.removePiece(nima.getRow(), nima.getCol());
                board.removePiece(three.getRow(), three.getCol());
                
                board.putPiece(three.getRow(), three.getCol(), Color.RED);
                
                three.crash();
                
                game = false;
                
            }
            
                       
        }
        
        if((one.getRow() == three.getRow() && one.getCol() == three.getCol()) && (three.getRow() == two.getRow() && three.getCol() == two.getCol()) && 
                (one.getRow() == two.getRow() && one.getCol() == two.getCol())){
            
            board.setMessage("YOU WIN!!!");
            
            game = false;
            
        }
        
        
        }        
    }
}
