package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class KeyMonitor extends KeyAdapter {

    private Motor motor;
    public KeyMonitor(Motor p) {
        motor = p;
    }
    public void keyPressed(KeyEvent e) {

        motor.keyPressed(e);

    }
    public void keyReleased(KeyEvent e) {

        motor.keyReleased(e);

    }

}