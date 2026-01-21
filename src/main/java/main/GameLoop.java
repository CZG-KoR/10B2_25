package main;

import gameObject.GameObjekts;
import gamelogic.GameLogic;
import helper.Pause;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class GameLoop extends GamePanel {
static GamePanel gamePanel;
    public void startGameLoop(Thread gameTread, GameObjekts gameObjekts,int FpsUps){
        gamePanel=new GamePanel();
        while (gameTread != null){

            //Timer Strart
            long start =System.nanoTime();

            //gameLoop
            GameLogic.update(gamePanel,gameObjekts);
            gamePanel.repaint();

            //Timer Ende
            long finish =System.nanoTime();
            long updatePaintTime = finish-start;

            //Pausieren fals Nötig
            if (updatePaintTime<1000000/FpsUps){
                Pause.ns((int) ((1000000-updatePaintTime)/FpsUps));}


        }
    }






}
