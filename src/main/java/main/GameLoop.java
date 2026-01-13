package main;

import gamelogic.GameLogic;
import helper.Pause;

public class GameLoop extends GamePanel {

    public void startGameLoop(Thread gameTread,int FpsUps){
        while (gameTread != null){

            //Timer Strart
            long start =System.nanoTime();

            //gameLoop
            GameLogic.update();
            repaint();

            //Timer Ende
            long finish =System.nanoTime();
            long updatePaintTime = finish-start;

            //Pausieren fals Nötig
            if (updatePaintTime<1000000/FpsUps){
                Pause.ns((int) ((1000000-updatePaintTime)/FpsUps));}


        }
    }


}
