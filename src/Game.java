
import java.awt.Color;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean running = true;
        GameBoard board = new GameBoard();
        Random rand = new Random();
        int row = rand.nextInt(8);
        int col = rand.nextInt(8);
        Doctor player = new Doctor(row, col);
        // put a randomly generated piece
        board.putPiece(row, col, Color.BLUE);

        rand = new Random();
        int row1 = rand.nextInt(8);
        int col1 = rand.nextInt(8);
        Dalek enemy1 = new Dalek(row1, col1);
        // put a randomly generated piece
        board.putPiece(row1, col1, Color.RED);

        rand = new Random();
        int row2 = rand.nextInt(8);
        int col2 = rand.nextInt(8);
        Dalek enemy2 = new Dalek(row2, col2);
        board.putPiece(row2, col2, Color.RED);

        rand = new Random();
        int row3 = rand.nextInt(8);
        int col3 = rand.nextInt(8);
        Dalek enemy3 = new Dalek(row3, col3);
        board.putPiece(row3, col3, Color.RED);

        while (running) {
            
            if (player.getRow() == enemy1.getRow() && player.getCol() == enemy1.getCol() || 
                    player.getRow() == enemy2.getRow() && player.getCol() == enemy2.getCol()
                    || player.getRow() == enemy3.getRow() && player.getCol() == enemy3.getCol()) {
                running = false;
                board.putPiece(player.getRow(), player.getCol(), Color.GRAY);
                board.setMessage("You have been Captured.");
            }else{

            Coordinate cords = board.getClick();
            board.removePiece(row, col);
            row = cords.getRow();
            col = cords.getCol();

            player.move(row, col);
            
            
             row = player.getRow();
            col = player.getCol();
            
            board.putPiece(row, col, Color.BLUE);
            }
            
            
            if(!enemy1.hasCrashed()){
            board.removePiece(enemy1.getRow(), enemy1.getCol());
            enemy1.advanceTowards(player);
            board.putPiece(enemy1.getRow(), enemy1.getCol(), Color.RED);
            }
            
            if(!enemy2.hasCrashed()){
            board.removePiece(enemy2.getRow(), enemy2.getCol());
            enemy2.advanceTowards(player);
            board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.RED);
            }
            
            if(!enemy3.hasCrashed()){
            board.removePiece(enemy3.getRow(), enemy3.getCol());
            enemy3.advanceTowards(player);
            board.putPiece(enemy3.getRow(), enemy3.getCol(), Color.RED);
            }

      
            if (enemy1.getRow() == enemy2.getRow() && enemy1.getCol() == enemy2.getCol()) {
                board.removePiece(enemy1.getRow(), enemy1.getCol());
                board.removePiece(enemy2.getRow(), enemy2.getCol());
                
                board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                enemy1.crash();
                enemy2.crash();
            }
            
            if (enemy1.getRow() == enemy3.getRow() && enemy3.getCol() == enemy1.getCol()) {
                board.removePiece(enemy1.getRow(), enemy1.getCol());
                board.removePiece(enemy3.getRow(), enemy3.getCol());
                
                board.putPiece(enemy3.getRow(), enemy3.getCol(), Color.GRAY);
                enemy1.crash();
                enemy3.crash();
            }
            
            if (enemy2.getRow() == enemy3.getRow() && enemy2.getCol() == enemy3.getCol()) {
                board.removePiece(enemy3.getRow(), enemy3.getCol());
                board.removePiece(enemy2.getRow(), enemy2.getCol());
                
                board.putPiece(enemy2.getRow(), enemy2.getCol(), Color.GRAY);
                enemy3.crash();
                enemy2.crash();
            }

        }
    }
}
