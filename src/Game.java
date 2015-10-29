
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
        boolean end = false;
        /**
         * The array and the for loop are to create random numbers for the doctors starting position.
         */
        int spot[] = new int[8];
        for(int i = 0;i< spot.length; i++){
        spot[i]=(int)(Math.random()*8);
        }
        
        Doctor ermen = new Doctor(spot[0],spot[1]);
        Dalek leo = new Dalek(spot[2],spot[3]);
        Dalek cena = new Dalek(spot[4],spot[5]);
        Dalek pepe = new Dalek(spot[6],spot[7]);
        GameBoard board = new GameBoard();
        
        
        board.putPiece(ermen.getRow(), ermen.getCol(), Color.GREEN);
        board.putPiece(leo.getRow(), leo.getCol(), Color.YELLOW);
        board.putPiece(cena.getRow(), cena.getCol(), Color.YELLOW);
        board.putPiece(pepe.getRow(), pepe.getCol(), Color.YELLOW);
        
        while(end==false && leo.hasCrashed()==false || cena.hasCrashed()==false || pepe.hasCrashed()==false){
            if(ermen.getRow() == leo.getRow() &&ermen.getCol()==leo.getCol() || ermen.getRow() == cena.getRow() &&ermen.getCol()==cena.getCol() 
                   || ermen.getRow() == pepe.getRow() &&ermen.getCol()==pepe.getCol()){
               end = true;
               board.putPiece(ermen.getRow(), ermen.getCol(), Color.RED);
               board.setMessage("GameOver Daleks have overpowered you... Better luck next time");
           }
            if(leo.getRow() == cena.getRow() && leo.getCol() == cena.getCol()){
                leo.crash();
                cena.crash();
                board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
                board.putPiece(cena.getRow(), cena.getCol(), Color.RED);
            }
           
            if(leo.getRow() == pepe.getRow() && leo.getCol() == pepe.getCol()){
                leo.crash();
                pepe.crash();
                board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
                board.putPiece(pepe.getRow(), pepe.getCol(), Color.RED);
            }
            
            if(cena.getRow() == pepe.getRow() && cena.getCol() == pepe.getCol()){
                cena.crash();
                pepe.crash();
                board.putPiece(cena.getRow(), cena.getCol(), Color.RED);
                board.putPiece(pepe.getRow(), pepe.getCol(), Color.RED);
            }
            
            
            //wait for the user to click
            Coordinate c = board.getClick();
            board.removePiece(ermen.getRow(), ermen.getCol());
            board.removePiece(leo.getRow(),leo.getCol());
            board.removePiece(cena.getRow(), cena.getCol());
            board.removePiece(pepe.getRow(),pepe.getCol());
            
            int row = c.getRow();
            int col = c.getCol();
            
            
            
           
           if(end == false){
            ermen.move(row, col);
            board.putPiece(ermen.getRow(),ermen.getCol(), Color.GREEN);
           }
            if(leo.hasCrashed()==false){
                leo.advancesTowards(ermen);
                board.putPiece(leo.getRow(),leo.getCol(),Color.YELLOW);
            }
            if(cena.hasCrashed()==false){
               cena.advancesTowards(ermen);
                board.putPiece(cena.getRow(),cena.getCol(),Color.YELLOW);
            }
            if(pepe.hasCrashed()==false){
                pepe.advancesTowards(ermen);
                board.putPiece(pepe.getRow(), pepe.getCol(), Color.YELLOW);
            }
            
            
            
            if(ermen.getRow() == leo.getRow() &&ermen.getCol()==leo.getCol() || ermen.getRow() == cena.getRow() &&ermen.getCol()==cena.getCol() 
                   || ermen.getRow() == pepe.getRow() &&ermen.getCol()==pepe.getCol()){
               end = true;
               board.putPiece(ermen.getRow(), ermen.getCol(), Color.RED);
               board.setMessage("GameOver Daleks have overpowered you... Better luck next time");
           }
            
           if(leo.getRow() == cena.getRow() && leo.getCol() == cena.getCol()){
                leo.crash();
                cena.crash();
                board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
                board.putPiece(cena.getRow(), cena.getCol(), Color.RED);
            }
           
            if(leo.getRow() == pepe.getRow() && leo.getCol() == pepe.getCol()){
                leo.crash();
                pepe.crash();
                board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
                board.putPiece(pepe.getRow(), pepe.getCol(), Color.RED);
            }
            
            if(cena.getRow() == pepe.getRow() && cena.getCol() == pepe.getCol()){
                cena.crash();
                pepe.crash();
                board.putPiece(cena.getRow(), cena.getCol(), Color.RED);
                board.putPiece(pepe.getRow(), pepe.getCol(), Color.RED);
            }
            
        }
        if(end == false){
            board.setMessage("The Doctor WINS!! GG");
        }
        
    }
}
