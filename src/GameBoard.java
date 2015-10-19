
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
 * A class that represents an 8x8 game board not unlike one used in checkers.
 *
 * @author haidj9901
 */
public class GameBoard extends JComponent implements MouseListener {

    private String message = "";
    private JFrame window;
    private final int TILE_SIZE = 50;
    private final int BOARD_LENGTH = 12;
    private final int BOARD_WIDTH = 12;
    private Color[][] grid = new Color[BOARD_WIDTH][BOARD_LENGTH];
    public Coordinate click = null;

    public GameBoard() {
        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_LENGTH; y++) {
                grid[x][y] = null;
            }
        }

        //creating the frame
        window = new JFrame("Game Board");
        window.add(this);
        this.setPreferredSize(new Dimension(BOARD_WIDTH * TILE_SIZE + TILE_SIZE, BOARD_LENGTH * TILE_SIZE + TILE_SIZE / 2));
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initializing mouse listener
        this.addMouseListener(this);
    }

    /**
     * Drawing the game board
     *
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
                //draws a single spot
                g.fillRect(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 4, TILE_SIZE, TILE_SIZE);
                if (grid[x][y] != null) {
                    g.setColor(grid[x][y]);
                    g.fillOval(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 4, TILE_SIZE, TILE_SIZE);
                }
            }
        }
        g.setColor(Color.black);
        g.drawString(message, TILE_SIZE / 2, TILE_SIZE * 8 + 3 * TILE_SIZE / 8);
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

    public void printBoard() {
        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_LENGTH; y++) {
                if (grid[y][x] == Color.red) {
                    System.out.print("R  ");
                } else if (grid[y][x] == Color.blue) {
                    System.out.print("B  ");
                } else if (grid[x][y] == null) {
                    System.out.print("_  ");
                }
            }
            System.out.println();
        }
        System.out.println(message);
        System.out.println();
    }

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

    @Override
    public void mousePressed(MouseEvent e) {
        int x = (e.getX() - TILE_SIZE / 2) / TILE_SIZE;
        int y = (e.getY() - TILE_SIZE / 4) / TILE_SIZE;


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
}
