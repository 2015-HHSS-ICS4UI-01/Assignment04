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
        // TODO code application logic here
        Doctor paul = new Doctor(0,0);
        Dalek d1 = new Dalek ((int)Math.random()*8,(int)Math.random()*8);
        Dalek d2 = new Dalek ((int)Math.random()*8,(int)Math.random()*8);
        Dalek d3 = new Dalek ((int)Math.random()*8,(int)Math.random()*8);
    }
}
