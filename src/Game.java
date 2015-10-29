
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lamonta
 */
public class Game {
    private static int[] x = new int[8];
    private static int[] y = new int[8];
    
   
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //gameboard
        GameBoard board = new GameBoard();
        //create start coordinates
        randomStart();
        //doctor
        Doctor player1 = new Doctor(x[0],y[0]);
        //daleks
        Dalek d1 = new Dalek(x[1],y[1]);
        Dalek d2 = new Dalek(x[2],y[2]);
        Dalek d3 = new Dalek(x[3],y[3]);
        //place initial players on board
        board.putPiece(player1.getRow(), player1.getCol(), Color.blue);
        board.putPiece(d1.getRow(), d1.getCol(), Color.yellow);
        board.putPiece(d2.getRow(), d2.getCol(), Color.yellow);
        board.putPiece(d3.getRow(), d3.getCol(), Color.yellow);
       
        
        //while player is alive
        while (!player1.hasCrashed()) {
            //get coordinates
            Coordinate c = board.getClick();
            //remove pieces
            board.removePiece(d1.getRow(), d1.getCol());
            board.removePiece(d2.getRow(), d2.getCol());
            board.removePiece(d3.getRow(), d3.getCol());
            board.removePiece(player1.getRow(), player1.getCol());
            //store player click coord.
            int row = c.getRow();
            int col = c.getCol();
            //move methods
            player1.move(row, col);
            d1.advanceTowards(player1);
            d2.advanceTowards(player1);
            d3.advanceTowards(player1);
            
            //replace player on board
            board.putPiece(player1.getRow(), player1.getCol(), Color.blue);
            board.putPiece(d1.getRow(), d1.getCol(), Color.yellow);
            board.putPiece(d2.getRow(), d2.getCol(), Color.yellow);
            board.putPiece(d3.getRow(), d3.getCol(), Color.yellow);
           
            //check for crashes
            d1.crash(d1,d2);
            d1.crash(d1,d3);
            d2.crash(d2,d1);
            d2.crash(d2,d3);
            d3.crash(d3,d1);
            d3.crash(d3,d2);
            d1.crashDoc(player1, d1);
            d2.crashDoc(player1, d2);
            d3.crashDoc(player1, d3);
            player1.crash(player1, d1);
            player1.crash(player1, d2);
            player1.crash(player1, d3);
            
            //replace crashed players
            if(d1.hasCrashed()){
              board.putPiece(d1.getRow(), d1.getCol(), Color.red);
            }
            if(d2.hasCrashed()){
              board.putPiece(d2.getRow(), d2.getCol(), Color.red);
            }
            if(d3.hasCrashed()){
              board.putPiece(d3.getRow(), d3.getCol(), Color.red);
            }
            
            //win
            if(d1.hasCrashed()&&d2.hasCrashed()&&d3.hasCrashed()&&!player1.hasCrashed()){
                board.setMessage("You Won!!!");
                break;
            }

        }
       //lose
       if(!d1.hasCrashed()||!d2.hasCrashed()||!d3.hasCrashed()){
           board.setMessage("you lost!!");
       }
    }
    /**
     * generate random start coordinates for player and daleks that are never the same
     */
    public static void randomStart(){
        for (int i = 0; i < 7; i++) {
           x[i] = i+1;
           y[i] = i+1;
        }
        
        ShuffleArray(x);
        ShuffleArray(y);
        
        }
    /**
     * Fisher-Yates shuffle function 
     * @param array 
     */
    private static void ShuffleArray(int[] array)
{
    int index;
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--)
    {
        index = random.nextInt(i + 1);
        if (index != i)
        {
            array[index] ^= array[i];
            array[i] ^= array[index];
            array[index] ^= array[i];
        }
    }
}
 
    }

