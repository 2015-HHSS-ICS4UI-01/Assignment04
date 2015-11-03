
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
        int docRow = (int)(Math.random()*16); 
        int docCol = (int)(Math.random()*16); 
        
        //initiates the daleks coordinates
        int dalRow1 = (int)(Math.random()*16); 
        int dalCol1 = (int)(Math.random()*16); 
        int dalRow2 = (int)(Math.random()*16); 
        int dalCol2 = (int)(Math.random()*16); 
        int dalRow3 = (int)(Math.random()*16); 
        int dalCol3 = (int)(Math.random()*16); 
        int dalRow4 = (int)(Math.random()*16); 
        int dalCol4 = (int)(Math.random()*16);
        int dalRow5 = (int)(Math.random()*16); 
        int dalCol5 = (int)(Math.random()*16);
        int dalRow6 = (int)(Math.random()*16); 
        int dalCol6 = (int)(Math.random()*16);
        int dalRow7 = (int)(Math.random()*16); 
        int dalCol7 = (int)(Math.random()*16);
        
        //creates the gameboard to work on
        GameBoard board = new GameBoard();
        
        //creates the pegs for the daleks and the doctor
        Dalek one = new Dalek(dalRow1, dalCol1);
        Dalek two = new Dalek(dalRow2, dalCol2);
        Dalek three = new Dalek(dalRow3, dalCol3);
        Dalek four = new Dalek(dalRow4, dalCol4);
        Dalek five = new Dalek(dalRow5, dalCol5);
        Dalek six = new Dalek(dalRow6, dalCol6);
        Dalek seven = new Dalek(dalRow7, dalCol7);
        Doctor nima = new Doctor(docRow, docCol);
                      
        //randomly spawns the daleks and the doctor
        board.putPiece(nima.getRow(), nima.getCol() , Color.YELLOW);
        board.putPiece(one.getRow(), one.getCol(), Color.BLUE);
        board.putPiece(dalRow2, dalCol2, Color.BLUE);
        board.putPiece(dalRow3, dalCol3, Color.BLUE);
        board.putPiece(dalRow4, dalCol4, Color.BLUE);
        board.putPiece(dalRow5, dalCol5, Color.BLUE);
        board.putPiece(dalRow6, dalCol6, Color.BLUE);
        board.putPiece(dalRow7, dalCol7, Color.BLUE);
        
        boolean game = true;
        
        while(game){
        
        //makes the doctor move and do his thing
        Coordinate click = board.getClick();
        
        //removes all the pieces after a click
        board.removePiece(nima.getRow(), nima.getCol());
        board.removePiece(one.getRow(), one.getCol());
        board.removePiece(two.getRow(), two.getCol());
        board.removePiece(three.getRow(), three.getCol());
        board.removePiece(four.getRow(), four.getCol());
        board.removePiece(five.getRow(), five.getCol());
        board.removePiece(six.getRow(), six.getCol());
        board.removePiece(seven.getRow(), seven.getCol());
        
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
        four.advanceTowards(nima);
        board.putPiece(four.getRow(), four.getCol() , Color.BLUE);
        five.advanceTowards(nima);
        board.putPiece(five.getRow(), five.getCol() , Color.BLUE);
        six.advanceTowards(nima);
        board.putPiece(six.getRow(), six.getCol() , Color.BLUE);
        seven.advanceTowards(nima);
        board.putPiece(seven.getRow(), seven.getCol() , Color.BLUE);
        
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
