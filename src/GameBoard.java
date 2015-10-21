
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * A class that represents a game board not unlike one used in checkers.
 *
 * @author haidj9901
 */
public class GameBoard extends JComponent implements MouseListener, KeyListener{

    //initializing class variables
    private String message = "";
    private JFrame window;
    private final int TILE_SIZE = 66; //side length of each tile
    private final int BOARD_LENGTH = 10; //length of the board
    private final int BOARD_WIDTH = 10; //width of the board
    private Color[][] grid = new Color[BOARD_WIDTH][BOARD_LENGTH]; //2D array of colors based on board length and width
    public Coordinate click = null;

    /**
     * GameBoard constructor used to initialize the grid and JFrame window
     */
    public GameBoard() {
        //assign null value to each position on the board
        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_LENGTH; y++) {
                grid[x][y] = null;
            }
        }

        //creating the frame
        window = new JFrame("Game Board");
        window.add(this);
        this.setPreferredSize(new Dimension(BOARD_WIDTH * TILE_SIZE + TILE_SIZE, BOARD_LENGTH * TILE_SIZE + TILE_SIZE));
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initializing mouse listener
        this.addMouseListener(this);
    }

    /**
     * Drawing the game board
     * @param g Graphics object to draw with
     */
    @Override
    public void paintComponent(Graphics g) {
        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_LENGTH; y++) {
                //alternates colors
                if ((x + y) % 2 == 0) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.black);
                }
                //draws each grid on the board
                g.fillRect(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, TILE_SIZE, TILE_SIZE);
                
                //draws any pieces on the board
                if (grid[x][y] != null) {
                    g.setColor(grid[x][y]);
                    g.fillOval(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, TILE_SIZE, TILE_SIZE);
                }
            }
        }
        
        //outputs any messages that are on the board
        g.setColor(Color.black);
        g.drawString(message, TILE_SIZE / 2, TILE_SIZE * BOARD_LENGTH + 3 * TILE_SIZE / 4);
    }

    public int getBoardLength()
    {
        return BOARD_LENGTH;
    }

    public int getBoardWidth()
    {
        return BOARD_WIDTH;
    }
    /**
     * places a piece of a specific colour on the board
     *
     * @param x the column at which to place the piece
     * @param y the row at which to place the piece
     * @param colour the colour of the piece
     */
    public void putPiece(int x, int y, Color colour) {
        if (x >= 0 || y >= 0) {
            grid[x][y] = colour;
        } else {
            message = "Please enter a valid position";
        }
        repaint();
    }

    /**
     * removes a piece from the board
     *
     * @param x the column at which the piece is found
     * @param y the row at which the piece is found
     */
    public void removePiece(int x, int y) {
        grid[x][y] = null;
        repaint();
    }

    /**
     * removes all pieces from the board
     */
    public void clearBoard() {
        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_LENGTH; y++) {
                grid[x][y] = null;
            }
        }
    }

    /**
     * displays a message to the user to explain what is happening
     *
     * @param message the message to be displayed
     */
    public void setMessage(String theMessage) {
        message = theMessage;
        repaint();
    }
    
    
    /**
     * waits for and stores the coordinates of a mouse click
     * @return the Coordinate class with the x and y coordinates of the click
     */
    public Coordinate getClick() {
        click = null;
        while (click == null) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return click;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * Event that handles when a mouse is clicked
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int x = (e.getX() - TILE_SIZE / 2) / TILE_SIZE;
        int y = (e.getY() - TILE_SIZE / 2) / TILE_SIZE;


        if (x >= 0 && x <= BOARD_LENGTH - 1 && y >= 0 && y <= BOARD_WIDTH) {
            click = new Coordinate(x, y);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
