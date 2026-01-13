package main;



import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int orignialTileZise = 32;
    final int colums =32;
    final int rows =32;
    final int defaultwidth = orignialTileZise*colums;
    final int defaultheight = orignialTileZise*rows;
    final int FpsUps=60;
    Thread gameTread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(defaultwidth,defaultheight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
    }

    private void startGameTread(){
        gameTread =new Thread(this);
        gameTread.start();
    }
    @Override
    public void run() {
        startGameTread();
        GameLoop g= new GameLoop();
        g.startGameLoop(gameTread,FpsUps);
    }




}
