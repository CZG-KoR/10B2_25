package main;



import java.awt.*;


public class Gui extends GamePanel{

    public  void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.drawRect(1,1,100,100);
        System.out.println("Painting");
    }
}
