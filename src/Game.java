
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

        Doctor who = new Doctor(3, 5);


        Dalek[] enemies = {new Dalek(7, 4), new Dalek(1, 0), new Dalek(6, 7)};

        //doctor stuff
        int dRow = who.getX();
        int dCol = who.getY();
        board.putPiece(dRow, dCol, Color.GREEN);

        //Dalek 1 stuff

        board.putPiece(enemies[0].getRow(), enemies[0].getCol(), Color.PINK);

        //Dalek 2 stuff
        board.putPiece(enemies[1].getRow(), enemies[1].getCol(), Color.PINK);

        //Dalek 3 stuff
        board.putPiece(enemies[2].getRow(), enemies[2].getCol(), Color.PINK);

        int win
        while (true) {

            //doctor movement
            Coordinate p = board.getClick();
            board.removePiece(dRow, dCol);

            int holdx = dRow;
            int holdy = dCol;

            dRow = p.getRow();
            dCol = p.getCol();

            if (holdx + 1 < dRow || holdx - 1 > dRow) {
                dRow = (int) (Math.random() * 8);
                dCol = (int) (Math.random() * 8);
            }
            if (holdy + 1 < dCol || holdy - 1 > dCol) {
                dRow = (int) (Math.random() * 8);
                dCol = (int) (Math.random() * 8);
            }
            who = new Doctor(dRow, dCol);
            board.putPiece(dRow, dCol, Color.GREEN);

            //
            
            //Dalek movement
            board.removePiece(enemies[0].getRow(), enemies[0].getCol());
            board.removePiece(enemies[1].getRow(), enemies[1].getCol());
            board.removePiece(enemies[2].getRow(), enemies[2].getCol());

            if (!enemies[0].hasCrashed()) {
                enemies[0].advanceTowards(who);
            }
            if (!enemies[1].hasCrashed()) {
                enemies[1].advanceTowards(who);
            }
            if (!enemies[2].hasCrashed()) {
                enemies[2].advanceTowards(who);
            }
            board.putPiece(enemies[0].getRow(), enemies[0].getCol(), Color.PINK);
            board.putPiece(enemies[1].getRow(), enemies[1].getCol(), Color.PINK);
            board.putPiece(enemies[2].getRow(), enemies[2].getCol(), Color.PINK);
            
            //
            
            //check for crash
//            if (enemies[0].getRow() == enemies[1].getRow() && enemies[0].getCol() == enemies[1].getCol()) {
//                enemies[0].crash();
//                enemies[1].crash();
//            } else if (enemies[0].getRow() == enemies[2].getRow() && enemies[0].getCol() == enemies[2].getCol()) {
//                enemies[0].crash();
//                enemies[2].crash();
//            } else if (enemies[1].getRow() == enemies[2].getRow() && enemies[1].getCol() == enemies[2].getCol()) {
//                enemies[1].crash();
//                enemies[2].crash();
//            }
            //for Daleks
            for(int i = 0; i < enemies.length; i++){
                for(int j = 1; j < enemies.length; j++){
                    if (enemies[i].getRow() == enemies[j].getRow() && enemies[i].getCol() == enemies[j].getCol()){
                        
                    }
                
                }
            }
            
            
            
            if (enemies[0].hasCrashed() && enemies[1].hasCrashed() && enemies[2].hasCrashed()){
                break;
            }
            if (){
                break;
            }
            //

        }
        board.setMessage("GAME OVER");

    }
}
