
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
        boolean finish = false;
        
        //This array chooses a random number between 0-7 to randomly choose a spot for the
        //doctor to spawn
        int [] numbers = new int[8];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = (int)(Math.random()*8);
        }
        //Daleks and Doctor are spawned randomly
        Dalek doge = new Dalek(numbers[4], numbers[5]);
        Dalek leo = new Dalek(numbers[2],numbers[3]);
        Dalek NateThompson = new Dalek(numbers[3], numbers[6]);
        Doctor stewy = new Doctor(numbers[0],numbers[4]);
      //Daleks and Doctor are placed in their random starting position
      board.putPiece(stewy.getRow(), stewy.getCol(), Color.GREEN);
      board.putPiece(leo.getRow(), leo.getCol(), Color.YELLOW);
      board.putPiece(NateThompson.getRow(), NateThompson.getCol(), Color.YELLOW);
      board.putPiece(doge.getRow(), doge.getCol(), Color.YELLOW);
       //Doctor may crash with a Dalek at the start and game ends. Doctor loses
               if (stewy.getRow() == leo.getRow() && stewy.getCol() == leo.getCol()){
            
                board.putPiece(stewy.getRow(), stewy.getCol(), Color.RED);
                finish = true;
                board.setMessage("YOU LOSE");
            }
               if (stewy.getRow() == NateThompson.getRow() && stewy.getCol() == NateThompson.getCol()){
                   board.putPiece(stewy.getRow(), stewy.getCol(), Color.RED);
                   finish = true;
                   board.setMessage("YOU LOSE");
               }
               if (stewy.getRow() == doge.getRow() && stewy.getCol() == doge.getCol()){
                   board.putPiece(stewy.getRow(), stewy.getCol(), Color.RED);
                   finish = true;
                   board.setMessage("YOU LOSE");
               } 
                //Daleks may crash at the beginning of the game
            if(leo.getRow() == doge.getRow() && leo.getCol() == doge.getCol())
            {
                leo.crash();
                doge.crash();
                board.putPiece(doge.getRow(), doge.getCol(), Color.RED);
                board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
            }     
            if(leo.getRow() == NateThompson.getRow() && leo.getCol() == NateThompson.getCol())
            {
            leo.crash();
            NateThompson.crash();
            board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
            board.putPiece(NateThompson.getRow(), NateThompson.getCol(), Color.RED);
            } 
            if (NateThompson.getRow() == doge.getRow() && NateThompson.getCol() == doge.getCol())
            {
                NateThompson.crash();
                doge.crash();
                board.putPiece(NateThompson.getRow(), NateThompson.getCol(), Color.RED);
                board.putPiece(doge.getRow(), doge.getCol(), Color.RED);
            }
        while(finish == false){
            //wait for the user to click
            Coordinate c = board.getClick();
            board.removePiece(stewy.getRow(), stewy.getCol());
            board.removePiece(leo.getRow(),leo.getCol());
            board.removePiece(NateThompson.getRow(), NateThompson.getCol());
            board.removePiece(doge.getRow(),doge.getCol());
            int row = c.getRow();
            int col = c.getCol(); 
            //put a piece where they click 
            stewy.move(row, col); 
            row = stewy.getRow();
            col = stewy.getCol();
            board.putPiece(row, col, Color.GREEN);
            //Daleks advance towards Doctor
            if(doge.hasCrashed() == false){
                 doge.advanceTowards(stewy);
                board.putPiece(doge.getRow(), doge.getCol(), Color.YELLOW);
            }
            if (NateThompson.hasCrashed() == false){
                NateThompson.advanceTowards(stewy);
                board.putPiece(NateThompson.getRow(), NateThompson.getCol(), Color.YELLOW);
            } 
            if (leo.hasCrashed() == false){
                leo.advanceTowards(stewy);
                board.putPiece(leo.getRow(), leo.getCol(), Color.YELLOW);
            }
             //Daleks crash
            if(leo.getRow() == doge.getRow() && leo.getCol() == doge.getCol())
            {
                leo.crash();
                doge.crash();
                board.putPiece(doge.getRow(), doge.getCol(), Color.RED);
                board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
            }     
            if(leo.getRow() == NateThompson.getRow() && leo.getCol() == NateThompson.getCol())
            {
            leo.crash();
            NateThompson.crash();
            board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
            board.putPiece(NateThompson.getRow(), NateThompson.getCol(), Color.RED);
            } 
            if (NateThompson.getRow() == doge.getRow() && NateThompson.getCol() == doge.getCol())
            {
                NateThompson.crash();
                doge.crash();
                board.putPiece(NateThompson.getRow(), NateThompson.getCol(), Color.RED);
                board.putPiece(doge.getRow(), doge.getCol(), Color.RED);
            }
                //Doctor crashes with a Dalek and game ends. Doctor loses
               if (stewy.getRow() == leo.getRow() && stewy.getCol() == leo.getCol()){
            
                board.putPiece(stewy.getRow(), stewy.getCol(), Color.RED);
                finish = true;
                board.setMessage("YOU LOSE");
            }
               if (stewy.getRow() == NateThompson.getRow() && stewy.getCol() == NateThompson.getCol()){
                   board.putPiece(stewy.getRow(), stewy.getCol(), Color.RED);
                   finish = true;
                   board.setMessage("YOU LOSE");
               }
               if (stewy.getRow() == doge.getRow() && stewy.getCol() == doge.getCol()){
                   board.putPiece(stewy.getRow(), stewy.getCol(), Color.RED);
                   finish = true;
                   board.setMessage("YOU LOSE");
               }
            
            //All Daleks crash with each other. Game ends. Doctor wins
            if (leo.getRow() == doge.getRow() && leo.getRow() == NateThompson.getRow() && leo.getCol() == doge.getCol() && leo.getCol() == NateThompson.getCol())
            {
                finish = true;
                board.setMessage("YOU WIN!!!!!!");
            }
        }
            
    }
 }

