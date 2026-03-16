package main;
import gamelogic.KeyInput;
import helper.ImageLoader;

import javax.swing.*;
import java.awt.event.KeyListener;

/**
 * Fenster, in welchem das Spiel ausgeführt wird (bitte nicht anfassen ohne zu fragen!!!!)
 */
public class GameWindow {

    public static void openWindow(){
    JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Pharmacy");
        window.setIconImage(ImageLoader.loadImage("Logo.png"));
    GamePanel gamePanel;
    gamePanel =new GamePanel();
            window.add(gamePanel);
            window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        window.setFocusable(true);
        window.requestFocus();
        window.addKeyListener((KeyListener) new KeyInput());


        gamePanel.run();}


}
