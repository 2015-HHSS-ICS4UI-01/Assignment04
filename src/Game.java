
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

        int[] ranNumx = new int[4];
        
        ranNumx[0] = (int) (Math.random() * 8);
        for(int i = 1; i < ranNumx.length; i++){
            ranNumx[i] = (int) (Math.random() * 8);
            for(int j = 0; j < i; j++){
                if(ranNumx[i] == ranNumx[j]){
                    ranNumx[j]++;
                }
            }
        }
        
        int[] ranNumy = new int[4];
        
        ranNumy[0] = (int) (Math.random() * 8);
        for(int i = 1; i < ranNumy.length; i++){
            ranNumy[i] = (int) (Math.random() * 8);
            for(int j = 0; j < i; j++){
                if(ranNumy[i] == ranNumy[j]){
                    ranNumy[j]++;
                }
            }
        }
        
        //herr Doktor
        Doctor who = new Doctor(ranNumx[0], ranNumy[0]);

        //EVIL EVIL EVIL EEEEEEEEEEEEEEEE
        Dalek[] enemies = {new Dalek(ranNumx[1], ranNumy[1]), new Dalek(ranNumx[2], ranNumy[2]), new Dalek(ranNumx[3], ranNumy[3])};

        //doKtor stuff
        int dRow = who.getX();
        int dCol = who.getY();
        board.putPiece(dRow, dCol, Color.BLUE);


        //Dalek 1 stuff
        board.putPiece(enemies[0].getRow(), enemies[0].getCol(), Color.PINK);

        //Dalek 2 stuff
        board.putPiece(enemies[1].getRow(), enemies[1].getCol(), Color.PINK);

        //Dalek 3 stuff
        board.putPiece(enemies[2].getRow(), enemies[2].getCol(), Color.PINK);

        //ending variables
        boolean win = false;
        boolean lose = false;


        //main game loop
        while (!win && !lose) {

            //doctor movement
            //
            //wher they clicked
            Coordinate p = board.getClick();

            //take the piece off the board
            board.removePiece(dRow, dCol);

            //hold onto the origional co-oridinates
            int holdx = dRow;
            int holdy = dCol;

            //get the click's co-ordinates
            dRow = p.getRow();
            dCol = p.getCol();

            //if the click was more than one space away, randomize the co-ordinates
            if (holdx + 1 < dRow || holdx - 1 > dRow) {
                dRow = (int) (Math.random() * 8);
                dCol = (int) (Math.random() * 8);
            }
            if (holdy + 1 < dCol || holdy - 1 > dCol) {
                dRow = (int) (Math.random() * 8);
                dCol = (int) (Math.random() * 8);
            }

            //put the doctor at his new co-ordinates
            who = new Doctor(dRow, dCol);
            board.putPiece(dRow, dCol, Color.BLUE);
            //


            //Dalek movement
            //
            //get all the Daleks off the board
            board.removePiece(enemies[0].getRow(), enemies[0].getCol());
            board.removePiece(enemies[1].getRow(), enemies[1].getCol());
            board.removePiece(enemies[2].getRow(), enemies[2].getCol());

            //if they haven't crashed yet they move
            if (!enemies[0].hasCrashed()) {
                enemies[0].advanceTowards(who);
            }
            if (!enemies[1].hasCrashed()) {
                enemies[1].advanceTowards(who);
            }
            if (!enemies[2].hasCrashed()) {
                enemies[2].advanceTowards(who);
            }

            //check if they crashed
            if (enemies[0].getRow() == enemies[1].getRow() && enemies[0].getCol() == enemies[1].getCol()) {
                enemies[0].crash();
                enemies[1].crash();
            } else if (enemies[0].getRow() == enemies[2].getRow() && enemies[0].getCol() == enemies[2].getCol()) {
                enemies[0].crash();
                enemies[2].crash();
            } else if (enemies[1].getRow() == enemies[2].getRow() && enemies[1].getCol() == enemies[2].getCol()) {
                enemies[1].crash();
                enemies[2].crash();
            }

            //put them back on the board if they havent crashed, if they have make em red
            //ENEMY 1
            if (!enemies[0].hasCrashed()) {
                board.putPiece(enemies[0].getRow(), enemies[0].getCol(), Color.PINK);
            } else {
                board.putPiece(enemies[0].getRow(), enemies[0].getCol(), Color.RED);
            }

            //ENEMY 2
            if (!enemies[1].hasCrashed()) {
                board.putPiece(enemies[1].getRow(), enemies[1].getCol(), Color.PINK);
            } else {
                board.putPiece(enemies[1].getRow(), enemies[1].getCol(), Color.RED);
            }

            //ENEMY 3
            if (!enemies[2].hasCrashed()) {
                board.putPiece(enemies[2].getRow(), enemies[2].getCol(), Color.PINK);
            } else {
                board.putPiece(enemies[2].getRow(), enemies[2].getCol(), Color.RED);
            }
            //

            //ending statements
            //
            if (enemies[0].hasCrashed() && enemies[1].hasCrashed() && enemies[2].hasCrashed()) {
                win = true;
            }
            for (int i = 0; i + 1 < enemies.length; i++) {
                if (who.getX() == enemies[i].getRow() && who.getY() == enemies[i].getCol()) {
                    board.putPiece(dRow, dCol, Color.YELLOW);
                    lose = true;
                }
            }
            //

        }
        //checking how the player ended the game
        if (lose) {
            board.setMessage("GAME OVER");
        } else {
            board.setMessage("WINNER WINNER CHICKEN DINNER!!!");
        }

    }
}
