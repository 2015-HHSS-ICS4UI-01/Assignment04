/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haidj9901
 */
public class Dalek {

    private int x;
    private int y;
    private boolean hasCrashed;

    public Dalek(int startX, int startY) {
        x = startX;
        y = startY;
    }

    public void moveTowards(TheDoctor doc) {
        if (doc.getX() > x) {
            x++;
        } else if (doc.getX() < x) {
            x--;
        }
        if (doc.getY() > y) {
            y++;
        } else if (doc.getY() < y) {
            y--;
        }
    }

    public void crash() {
    }

    public boolean hasCrashed() {

        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
