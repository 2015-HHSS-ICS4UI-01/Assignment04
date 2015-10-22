
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
        boolean lose = false;
        Doctor leo = new Doctor((int)(Math.random() * 8),(int)(Math.random() * 8));
        
        Dalek dalek = new Dalek((int)(Math.random() * 8),(int)(Math.random() * 8));
        Dalek dalek1 = new Dalek((int)(Math.random() * 8),(int)(Math.random() * 8));
        Dalek dalek2 = new Dalek((int)(Math.random() * 8),(int)(Math.random() * 8));
        
        board.putPiece(dalek.getRow(),dalek.getCol(), Color.YELLOW);
        board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.YELLOW);
        board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.YELLOW);
        board.putPiece(leo.getRow(),leo.getCol(), Color.GREEN);
        
        
        while((!dalek.hasCrashed()||!dalek1.hasCrashed()||!dalek2.hasCrashed())&&lose == false){
        
        if(dalek1.getCol() == dalek.getCol() && dalek1.getRow() == dalek.getRow()){
                dalek.crash();
                dalek1.crash();
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.RED);
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.RED);

            }if(dalek1.getCol() == dalek2.getCol() && dalek1.getRow() == dalek2.getRow()){
                dalek2.crash();
                dalek1.crash();
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.RED);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.RED);

            }
            if(dalek2.getCol() == dalek.getCol() && dalek2.getRow() == dalek.getRow()){
                dalek.crash();
                dalek2.crash();
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.RED);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.RED);
            }
            Coordinate c = board.getClick();
            board.removePiece(dalek.getRow(),dalek.getCol());
            board.removePiece(dalek1.getRow(),dalek1.getCol());
            board.removePiece(dalek2.getRow(),dalek2.getCol());
            
            
            
            board.removePiece(leo.getRow(),leo.getCol());
            
            int row = c.getRow();
            int col = c.getCol();
            
            leo.move(row,col);
            board.removePiece(dalek.getRow(),dalek.getCol());
            board.removePiece(dalek1.getRow(),dalek1.getCol());
            board.removePiece(dalek2.getRow(),dalek2.getCol());
            if(!dalek.hasCrashed()){
                dalek.advanceTowards(leo);
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.YELLOW);
            }
            if(!dalek1.hasCrashed()){
                dalek1.advanceTowards(leo);
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.YELLOW);
            }
            if(!dalek2.hasCrashed()){
                dalek2.advanceTowards(leo);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.YELLOW);
            }
            
            
            
            
            
            
            
            
            board.putPiece(leo.getRow(),leo.getCol(), Color.GREEN);
            
            board.setMessage("" + dalek.getRow() + dalek1.getRow() + dalek.getCol() + dalek1.getCol());
            
            
            if((leo.getCol() == dalek.getCol()&&leo.getRow() == dalek.getRow())||(leo.getCol() == dalek1.getCol()&&leo.getRow() == dalek1.getRow())||(leo.getCol() == dalek2.getCol()&&leo.getRow() == dalek2.getRow())){
                board.setMessage("GG, Daleks win");
                board.putPiece(leo.getRow(),leo.getCol(), Color.YELLOW);
                lose = true;
            }
            
            
            if(dalek1.getCol() == dalek.getCol() && dalek1.getRow() == dalek.getRow()){
                dalek.crash();
                dalek1.crash();
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.RED);
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.RED);

            }if(dalek1.getCol() == dalek2.getCol() && dalek1.getRow() == dalek2.getRow()){
                dalek2.crash();
                dalek1.crash();
                board.putPiece(dalek1.getRow(),dalek1.getCol(), Color.RED);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.RED);

            }
            if(dalek2.getCol() == dalek.getCol() && dalek2.getRow() == dalek.getRow()){
                dalek.crash();
                dalek2.crash();
                board.putPiece(dalek.getRow(),dalek.getCol(), Color.RED);
                board.putPiece(dalek2.getRow(),dalek2.getCol(), Color.RED);
            }
        
        }
        if(!lose){
        board.setMessage("GG, Doctor Win");
        }
    }
}
