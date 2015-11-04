
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
        //make a new doctor object at a random position
        Doctor who=new Doctor((int)(Math.random()*8),(int)(Math.random()*8));
        
        //make an array of Delek objects at random positions
        Delek[] enemies={new Delek((int)(Math.random()*8),(int)(Math.random()*8)),new Delek((int)(Math.random()*8),
                (int)(Math.random()*8)),new Delek((int)(Math.random()*8),(int)(Math.random()*8))};
        
        //make a new gameboard object
        GameBoard board=new GameBoard();
        
        //boolean for the player being alive
        boolean alive = true;
        
        //make a boolean for running the game
        boolean run = true;
        
        //place all of the deleks are palced onto the board in pink
        for (int i = 0; i < enemies.length; i++) 
            board.putPiece(enemies[i].getRow(), enemies[i].getCol(), Color.pink);
        
        //check to see if the doctor is sharing the same tile as any of the daleks
        for (int i = 0; i < enemies.length; i++)
            if(who.getRow()==enemies[i].getRow()&&who.getCol()==enemies[i].getCol()){
                alive=false; 
                run=false;
                board.putPiece(enemies[i].getRow(), enemies[i].getCol(), Color.orange);
            }
        
        //check to see if any of the daleks share the same tile then tell those daleks that they have crashed
            for (int i = 0; i < enemies.length-1; i++)
                for (int j = i+1; j < enemies.length; j++)
                    if(enemies[i].getRow()==enemies[j].getRow()&&enemies[i].getCol()==enemies[j].getCol()){
                        enemies[i].crash(); 
                        enemies[j].crash();
                        board.putPiece(enemies[i].getRow(), enemies[i].getCol(), Color.red);
                    }
        
        //place who onto the board in green
        board.putPiece(who.getRow(),who.getCol(),Color.green);
        
        while(run){
            //make the coordinate object
            Coordinate c=board.getClick();
            //amount of deleks that have crashed this turn
            int crashCount=0;
            //row equals the coordinate of the mouse
            int row=c.getRow();
            //col equals the coordinate of the mouse
            int col=c.getCol();

            //remove the doctor from the board, change its positions and place it there on the board
            board.removePiece(who.getRow(),who.getCol());
            who.move(row,col);
            board.putPiece(who.getRow(), who.getCol(), Color.green);

            // if a dalek is alive, remove it, move it towards the doctor then place it there on the board
            for (int i = 0; i < enemies.length; i++) {   
                if(!enemies[i].getCrash()){
                    board.removePiece(enemies[i].getRow(),enemies[i].getCol());
                    enemies[i].advanceTowards(who);
                    board.putPiece(enemies[i].getRow(), enemies[i].getCol(), Color.pink);
                }
            }

            //check to see if the doctor is sharing the same tile as any of the daleks
            for (int i = 0; i < enemies.length; i++)
                if(who.getRow()==enemies[i].getRow()&&who.getCol()==enemies[i].getCol()){
                    //set the doctor as dead 
                    alive=false; 
                    //set the game to finish
                    run=false;
                    //put a piece onto the board that shows that the player is dead
                    board.putPiece(enemies[i].getRow(), enemies[i].getCol(), Color.orange);
                }

            //check to see if any of the daleks share the same tile then tell those daleks that they have crashed
            for (int i = 0; i < enemies.length-1; i++)
                for (int j = i+1; j < enemies.length; j++)
                    if(enemies[i].getRow()==enemies[j].getRow()&&enemies[i].getCol()==enemies[j].getCol()){
                        enemies[i].crash(); 
                        enemies[j].crash();
                        board.putPiece(enemies[i].getRow(), enemies[i].getCol(), Color.red);
                    }

            //check how many daleks have creashed
            for (int i = 0; i < enemies.length; i++)
                if(enemies[i].getCrash())
                    crashCount++;

            //stop the game if all daleks have crashed
            if (crashCount == 3)
                run = false;
        }
        //if the doctor is dead then you lose
        if(!alive)
            board.setMessage("You are dead. Try Again.");
        //if the doctor is alve after the game is done you win 
        if(alive)
            board.setMessage("Congratulations you beat the game!");
    }
}
