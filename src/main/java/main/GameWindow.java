package main;

import gameObject.GameObjekts;

import javax.swing.*;

import java.awt.*;

/**
 * Fenster, in welchem das Spiel ausgeführt wird (bitte nicht anfassen ohne zu fragen!!!!)
 */
public class GameWindow {

    public static void openWindow(){
    JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Pharmacy");
        GameObjekts gameObjekts;
    GamePanel gamePanel =new GamePanel();
            window.add(gamePanel);
            window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.run();}


}
