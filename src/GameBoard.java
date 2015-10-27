
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * A class that represents an 8x8 Game Board like used in Checkers
 *
 * @author lamonta
 */
public class GameBoard extends JComponent implements MouseListener {

    private Color[][] grid = new Color[8][8];
    private String message = "";
    private JFrame window;
    private final int TILE_SIZE = 100;
    private Coordinate click = null;

    /**
     * Creates a brand new empty 8x8 Board
     */
    public GameBoard() {
        // sets all positions to be null
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                grid[row][col] = null;
            }
        }
        // create the frame to display the board
        window = new JFrame("Game Board");
        // add the board to the frame
        window.add(this);
        // make the frame visible
        window.setVisible(true);
        //set the size of our board
        this.setPreferredSize(new Dimension(8 * TILE_SIZE + 50, 8 * TILE_SIZE + 100));
        // resize the window
        window.pack();
        //set the X
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add the mouse mouse listener
        this.addMouseListener(this);
    }

    /**
     * Drawing the Game Board
     *
     * @param g Graphics object to draw with
     */
    @Override
    public void paintComponent(Graphics g) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                // alternate the colours of the grid
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                // draws a single grid spot
                g.fillRect(col * TILE_SIZE + TILE_SIZE / 4, row * TILE_SIZE + TILE_SIZE / 4, TILE_SIZE, TILE_SIZE);
                // draw a piece
                if (grid[row][col] != null) {
                    if (grid[row][col] == Color.BLUE) {
                        paintDoc(g,row,col);
                    } else if (grid[row][col] == Color.PINK) {
                        paintAliveDalek(g);
                    } else if (grid[row][col] == Color.RED){
                        paintDeadDalek(g);
                    }
                    
                    g.setColor(grid[row][col]);
                    g.fillRect(col * TILE_SIZE + TILE_SIZE / 2, row * TILE_SIZE + TILE_SIZE / 4, TILE_SIZE / 2, TILE_SIZE / 1);
                    g.fillRect(col * TILE_SIZE + TILE_SIZE / 2, row * TILE_SIZE + TILE_SIZE / 4, TILE_SIZE / 2, TILE_SIZE / 1);
                }
            }
        }
        g.setColor(Color.BLACK);
        g.drawString(message, TILE_SIZE / 4, TILE_SIZE * 8 + TILE_SIZE / 2);
    }

    public void paintDoc(Graphics g, int row, int col) {
        
    }
    
    public void paintAliveDalek(Graphics g) {
        
    }
    public void paintDeadDalek(Graphics g) {
        
    }

    /**
     * Place a piece of a specific colour on the board
     *
     * @param row the row at which to place the piece
     * @param col the column at which to place the piece
     * @param colour the colour to make the piece
     */
    public void putPiece(int row, int col, Color colour) {
        grid[row][col] = colour;
        repaint();
    }

    /**
     * Removes a piece that is on the board
     *
     * @param row the row to remove the piece from
     * @param col the column to remove the piece from
     */
    public void removePiece(int row, int col) {
        grid[row][col] = null;
        repaint();
    }

    /**
     * Removes all piece from the board
     */
    public void clearBoard() {
        // sets all positions to be null
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                grid[row][col] = null;
            }
        }
        repaint();
    }

    /**
     * Displays a message on the game area
     *
     * @param theMessage the message to display
     */
    public void setMessage(String theMessage) {
        message = theMessage;
        repaint();
    }

    public void printBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (grid[row][col] == Color.RED) {
                    System.out.print("R  ");
                } else if (grid[row][col] == Color.BLUE) {
                    System.out.print("B  ");
                } else if (grid[row][col] == null) {
                    System.out.print("_  ");
                }
            }
            System.out.println("");
        }
        System.out.println(message);
        System.out.println("");
    }

    public Coordinate getClick() {
        // wipe out the previous click
        click = null;
        // wait for a click to happen
        while (click == null) {
            // do nothing
            // wait for click to happen
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

    @Override
    public void mousePressed(MouseEvent e) {
        // get x and y of click
        // shift them so the top and left boarders are gone
        int x = e.getX() - TILE_SIZE / 4;
        int y = e.getY() - TILE_SIZE / 4;

        // get the row and column of the click
        int row = y / TILE_SIZE;
        int col = x / TILE_SIZE;

        // validate the coordinate
        if (row >= 0 && row <= 7
                && col >= 0 && col <= 7) {
            click = new Coordinate(row, col);
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
}
