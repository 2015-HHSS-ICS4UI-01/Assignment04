
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
 * A class that represents a 12x12 board used in Dalek's Game
 *
 * @author branc2347
 */
public class GameBoard extends JComponent implements MouseListener {

    private Color[][] grid = new Color[12][12];
    private String message = "";
    private final int TILE_SIZE = 50;
    private JFrame window;
    private Coordinate click = null;

    public GameBoard() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                grid[x][y] = null;
            }
        }
        //create new frame to display the board
        window = new JFrame("Game Board");
        // add the board to the frame
        window.add(this);
        //make the frame visible
        window.setVisible(true);
        window.setPreferredSize(new Dimension(grid.length * TILE_SIZE + 50, grid.length * TILE_SIZE + 50));
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add the mouse listener to the game board
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {

                if ((x + y) % 2 == 0) {
                    g.setColor(Color.DARK_GRAY);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                if (grid[x][y] != null) {
                    g.setColor(grid[x][y]);
                    g.fillOval(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }
    }

    /**
     * Place a given piece of a specific colour on the board
     *
     * @param x the column at which to place the piece
     * @param y the row at which to place the piece
     * @param colour the colour to make the piece
     */
    public void putPiece(int x, int y, Color colour) {
        grid[x][y] = colour;
        repaint();
    }

    /**
     * Remove a piece from board
     *
     * @param x which column to remove from
     * @param y which row to remove from
     */
    public void removePiece(int x, int y) {
        grid[x][y] = null;
        repaint();
    }

    /**
     * Clear the board of pieces
     */
    public void clearBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                grid[x][y] = null;
                repaint();
            }
        }
    }

    /**
     * Display a message
     *
     * @param message the message to be displayed
     */
    public void setMessage(String message) {
    }

    public Coordinate getClick() {

        click = null;
        while (click == null) {
            //do nothing
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
        int x = (e.getX()) / TILE_SIZE;
        int y = (e.getY()) / TILE_SIZE;

        //get the row and column of the click
        if (y < grid.length && y >= 0 && x < grid.length && x >= 0) {
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
}
