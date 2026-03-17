package gamelogic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Klasse zum Managen aller Tastatur Tasten
 * */
public class KeyInput extends KeyAdapter {
        static char aktiveKey =' ';

        @Override
        public void keyTyped(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode()!=0) {
                aktiveKey = keyEvent.getKeyChar();
            }
    }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode()!=0) {
                aktiveKey = keyEvent.getKeyChar();
            }
            System.out.println("Taste gedrückt: " + KeyEvent.getKeyText(keyEvent.getKeyCode()));
    }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

    }

    public static char getAktiveKey() {
        return aktiveKey;
    }
}

