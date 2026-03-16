package gamelogic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
        static String aktiveKey;

        @Override
        public void keyTyped(KeyEvent keyEvent) {
            aktiveKey =KeyEvent.getKeyText(keyEvent.getKeyCode());


    }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            aktiveKey =KeyEvent.getKeyText(keyEvent.getKeyCode());
            System.out.println("Taste gewdrückt: " + KeyEvent.getKeyText(keyEvent.getKeyCode()));
    }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            aktiveKey ="";

    }

    public static String getAktiveKey() {
        return aktiveKey;
    }
}

