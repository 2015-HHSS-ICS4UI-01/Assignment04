
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
        //This boolean will be used for the doctor to see if he is on the same spot as a dalek, and if he is it changes to true, and the game ends.
        boolean end = false;
        /**
         * The array and the for loop are to create random numbers for the doctors starting position.
         */
        int spot[] = new int[8];
        for(int i = 0;i< spot.length; i++){
        spot[i]=(int)(Math.random()*8);
        }
        //These are the starting positions that the Doctor and the daleks will spawn on, which are randomized by the randomizer above.
        Doctor ermen = new Doctor(spot[0],spot[1]);
        Dalek leo = new Dalek(spot[2],spot[3]);
        Dalek cena = new Dalek(spot[4],spot[5]);
        Dalek pepe = new Dalek(spot[6],spot[7]);
        GameBoard board = new GameBoard();
        
        //Placeing the pieces on the board to start the game
        board.putPiece(ermen.getRow(), ermen.getCol(), Color.GREEN);
        board.putPiece(leo.getRow(), leo.getCol(), Color.YELLOW);
        board.putPiece(cena.getRow(), cena.getCol(), Color.YELLOW);
        board.putPiece(pepe.getRow(), pepe.getCol(), Color.YELLOW);
        //This loop will run while the game should not have ended and all of the daleks have not crashed yet.
        while(end==false && leo.hasCrashed()==false || cena.hasCrashed()==false || pepe.hasCrashed()==false){
           
            //The if statments above the movement are to check if the Doctor or any of the Daleks spawn on top of eachother, the same
            //if statments are repeated below after movment to see if there was any crashing.
            //If the doctor is on the same space as any of the Daleks. 
            if(ermen.getRow() == leo.getRow() &&ermen.getCol()==leo.getCol() || ermen.getRow() == cena.getRow() &&ermen.getCol()==cena.getCol() 
                   || ermen.getRow() == pepe.getRow() &&ermen.getCol()==pepe.getCol()){
               //The game will end
                end = true;
                //Will place a red piece showing that a crash has occured.
               board.putPiece(ermen.getRow(), ermen.getCol(), Color.RED);
               //The game will set the message that the doctor has lost.
               board.setMessage("GameOver Daleks have overpowered you... Better luck next time");
           }
            //To check to see if Dalek Leo has the same coordinates as Dalek cena, if so, they will crash and their pieces will now be red.
            if(leo.getRow() == cena.getRow() && leo.getCol() == cena.getCol()){
                leo.crash();
                cena.crash();
                board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
                board.putPiece(cena.getRow(), cena.getCol(), Color.RED);
            }
            //To check to see if Dalek Leo has the same coordinates as Dalek pepe, if so, they will crash and their pieces will now be red.
            if(leo.getRow() == pepe.getRow() && leo.getCol() == pepe.getCol()){
                leo.crash();
                pepe.crash();
                board.putPiece(leo.getRow(), leo.getCol(), Color.RED);
                board.putPiece(pepe.getRow(), pepe.getCol(), Color.RED);
            }
             //To check to see if Dalek cena has the same coordinates as Dalek cena, if so, they will crash and their pieces will now be red.
            if(cena.getRow() == pepe.getRow() && cena.getCol() == pepe.getCol()){
                cena.crash();
                pepe.crash();
                board.putPiece(cena.getRow(), cena.getCol(), Color.RED);
                board.putPiece(pepe.getRow(), pepe.getCol(), Color.RED);
            }
            
            
            //wait for the user to click
            Coordinate c = board.getClick();
            //The peices are removed from the previous postions.
            board.removePiece(ermen.getRow(), ermen.getCol());
            board.removePiece(leo.getRow(),leo.getCol());
            board.removePiece(cena.getRow(), cena.getCol());
            board.removePiece(pepe.getRow(),pepe.getCol());
            //To get the space that the user clicked 
            int row = c.getRow();
            int col = c.getCol();
            
            
            
           //This if statment moves the Doctor, if he has not crashed yet 
           if(end == false){
            ermen.move(row, col);
            board.putPiece(ermen.getRow(),ermen.getCol(), Color.GREEN);
           }
           //This if statment move the Dalek leo, is he has not crashed yet
            if(leo.hasCrashed()==false){
                leo.advancesTowards(ermen);
                board.putPiece(leo.getRow(),leo.getCol(),Color.YELLOW);
            }
            //This is statment moves the Dalek cena, if he has not crashed yet
            if(cena.hasCrashed()==false){
               cena.advancesTowards(ermen);
                board.putPiece(cena.getRow(),cena.getCol(),Color.YELLOW);
            }
            //This if statement moves the Dalek pepe, if he has not crashed yet
            if(pepe.hasCrashed()==false){
                pepe.advancesTowards(ermen);
                board.putPiece(pepe.getRow(), pepe.getCol(), Color.YELLOW);
            }
            
            
            //Like above, this is to check if the Doctor or any of the Daleks have crashed after movment has occured 
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
        //If the Doctor survives and all the Daleks crash the game will output a winning message to the user showing that they will have won
        //The user will also no longer be able to move, since the while statment above will close since the Daleks have crashed.
        if(end == false){
            board.setMessage("The Doctor WINS!! GG");
        }
        
    }
}
